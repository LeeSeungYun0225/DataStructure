
public class AVL extends List_Tree {
	
	
	private TreeNode root = new TreeNode();
	
	public AVL()
	{
		root =null;
	}
	
	public void left(TreeNode node)
	{
		if(node.getLeftSubTree()!= null)
		{
			System.out.println(node.getLeftSubTree().getKey()+" >> left");
		}
	}
	public void right(TreeNode node)
	{
		if(node.getRightSubTree()!= null)
		{
			System.out.println(node.getRightSubTree().getKey()+" >> right");
		}
		
	}
	
	public TreeNode getRoot()
	{
		return root;
	}

	public void BSTInsert(int key,Object data) // BST에 새 노드 추가, 데이터 삽입 , 노드 생성과정도 포함됨 
	{
		
		TreeNode newnode = new TreeNode(key,data);
		
		if(root==null)
		{
			root = newnode;
			return;
		}
		
		TreeNode parent = null;
		TreeNode current = root;
		
	
		// 새 노드의 적당한 위치 찾기 위한 while문, while문 탈출 시, 삽입되는 노드는 parent에 연결시킨다. 
		while(current != null)
		{ 
			if(key == current.getKey()) // 중복된 키라면 삽입을 중단한다. (키의 유일성 보존)
			{
				return;
			}
			
			
			parent = current;
			
			if(current.getKey() > key) // 현재 노드보다 작은 키일 경우에 
			{
				
				current = current.getLeftSubTree();

			}
			else // 현재 노드보다 큰 키일 경우에,
			{
				current = current.getRightSubTree();

			}
		}
		
	
		if(parent.key > key) 
		{
			parent.chainLeftSubTree(newnode);
		}
		else
		{
			parent.chainRightSubTree(newnode);
		}
		
		
		AVLSearch(key);
	}


	public void findParentAndChain(int targetKey,TreeNode newsubTree)
	{
		TreeNode temp = root;
		
		while(true)
		{
			if(targetKey>temp.key)
			{
				if(temp.getRightSubTree().key == targetKey)
				{
					temp.chainRightSubTree(newsubTree);
					return;
				}
				else
				{
					temp = temp.getRightSubTree();
				}
			}
			else
			{
				if(temp.getLeftSubTree().key== targetKey)
				{
					temp.chainLeftSubTree(newsubTree);
					return;
				}
				else
				{
					temp = temp.getLeftSubTree();
				}
			}
		}
	}
		
	public void AVLSearch(int targetKey) // BST에서 타겟 키를 탐색하는 메소드 
	{
		TreeNode current = root;
		TreeNode temp = null;
		int diff;
		
		while(current !=null) 
		{	
			diff = getHeightDiff(current); // 방금 삽입한 키를 찾아 내려가면서 균등인수 차이를 구한다.
			if(diff>1 || diff <-1) // 불균형인 지점을 temp에 임시 저장하고, 
			{
				temp = current;
			}	
			if(targetKey == current.key) // 키를 찾으면 
			{
				break; //중단 
			}
			else if(targetKey < current.key) // 찾는 키가 지금노드의 키보다 작으면 
			{
				current = current.getLeftSubTree();// 좌측 노드로 
			}
			else
			{
				current = current.getRightSubTree(); // 우측 노드로 
			}
		}
		if(temp == null) // 불균형인 지점을 찾지 못하였다면 함수 이탈 
		{
			return;
		}
		current = temp; // 탐색이 끝났으므로 불필요해진 current변수를 재사용 
		
		current = Rebalance(current); // 불균형 지점중 가장 하단에 위치한 지점에서 리밸런스 진행 
		
		if(temp.key == root.key) // temp는 리밸런스 시작 지점으로 리밸런스 시작된 지점이 기존의 루트이면 
		{
			root=current; // 루트가 밸런싱 된 새 루트를 가리키도록 지정 
		}
		else if(temp.key != current.key)// 리밸런싱 후에 기존의 불균형 지점과 current가 가리키는 지점이 변하였을때, >> 리밸런싱이 정상 진행되었을 때, 
		{
			findParentAndChain(temp.key,current); // 기존의 temp를 가리키던 부모 노드에서 밸런싱 된 새 자식 노드를 가리키도록 하는 메소드 호출 
			
		}
	}
	
	
	
	public boolean BSTSearch(int targetKey) // BST에서 타겟 키를 탐색하는 메소드 
	{
		TreeNode current = root;
		
		while(current !=null) // current가 null이 되어 탈출하는 경우 >> 해당 키가 존재하지 않음을 의미 
		{
			if(targetKey == current.key) // 키를 찾으면 
			{
				return true; // 해당 노드 반환 
			}
			else if(targetKey < current.key) // 찾는 키가 지금노드의 키보다 작으면 
			{
				current = current.getLeftSubTree();// 좌측 노드로 
			}
			else
			{
				current = current.getRightSubTree(); // 우측 노드로 
			}
		}
		
		
		
		return false; // 해당 키는 저장되어 있지 않다.  
	}
	
	
	
	
	public TreeNode BSTRemove(int targetKey)
	{

		TreeNode parent = null;
		TreeNode current = root;
		TreeNode deleteTarget;
		
		while(current !=null && current.getKey() != targetKey) // 타겟을 찾는 과정 
		{
			parent = current;
			
			if(targetKey < current.getKey()) // 타겟이 현재 키보다 작을 경우 
			{
				current= current.getLeftSubTree(); // 왼쪽으로 이동 
			}
			else // 타겟이 현재 키보다 클 경우 
			{
				current = current.getRightSubTree(); // 오른쪽으로 이동 
			}
		}
		
		
		if(current == null) // 탐색 실패 
		{
			return null;
		}
		
		// 이하 탐색 성공 구문 // 
		deleteTarget = current;
		
		//// 삭제 대상이 단말 노드일 때 ////
		if(deleteTarget.getLeftSubTree() == null && deleteTarget.getRightSubTree() == null)
		{
			if(parent.getLeftSubTree() == deleteTarget) // 부모의 좌측 서브트리가 삭제 대상일 때 
			{
				parent.prev= null;
			}
			else // 부모의 우측 서브트리가 삭제 대상일 때 
			{
				parent.next = null;
			}
		}
		/// 삭제대상이 하나의 자식 노드를 갖을 때 /// 
		else if(deleteTarget.getLeftSubTree() == null || deleteTarget.getRightSubTree() == null)
		{
			TreeNode subTarget; // 삭제 대상의 자식을 가리킬 트리 노드 
			
			if(deleteTarget.getLeftSubTree() == null) // 삭제 대상이 오른쪽 서브트리를 가질 때, 
			{
				subTarget = deleteTarget.getRightSubTree(); // subTarget 변수에 오른쪽 서브트리 저장 
			}
			else
			{
				subTarget = deleteTarget.getLeftSubTree();
			}
			
			if(parent.getLeftSubTree() == deleteTarget) // 삭제 대상이 부모 노드의 좌측 서브트리면, 
			{
				parent.prev = subTarget;
			
			}
			else
			{
				parent.next = subTarget;
			}
		}
		
		/// 삭제 대상이 두개의 자식 노드를 갖을 때 ///
		else
		{
		
			TreeNode tempNode = deleteTarget.getRightSubTree();
			TreeNode temp2Node = deleteTarget;
			Object deleteData = deleteTarget.data;
			
			while(tempNode.getLeftSubTree() != null) // 삭제대상 키가 있던 노드 대신 삭제 할 노드를 탐색한다 . 
			{
				temp2Node = tempNode;
				tempNode = tempNode.getLeftSubTree();
				
			}
			
			deleteTarget.setData(tempNode.getData()); // 최 하단 값(삭제 키를 대체하기 위한 값)을 가져와 저장한다.
			deleteTarget.setKey(tempNode.getKey());
			
			if(temp2Node.getLeftSubTree() == tempNode) // 대체되어 사용 하지 않는 말단 노드를 버리고, 버려진 노드에 대한 서브트리를 그 부모노드와 연결하는 과정 
			{
				temp2Node.prev = tempNode.next;
			}
			else
			{
				temp2Node.next = tempNode.next;
			
			}
			
			deleteTarget = tempNode;
			deleteTarget.setData(deleteData);
			deleteTarget.setKey(targetKey);
			
			
		}
		
		Rebalance(root);
		
		return deleteTarget;
	}
	
	public void BSTShowAll()
	{
		InorderTraverse(root);
		
		System.out.println("");
	}
	
	public int getHeightDiff(TreeNode node)
	{
		int leftSubtreeHeight;
		int rightSubtreeHeight;
		
		if(node == null)
		{
			return 0;
		}
		
		leftSubtreeHeight = getHeight(node.getLeftSubTree());	
		rightSubtreeHeight = getHeight(node.getRightSubTree());
		return leftSubtreeHeight-rightSubtreeHeight;
	}
	
	
	public TreeNode Rebalance(TreeNode node) // AVL 리밸런싱 메소드 
	{
		int heightDiff = getHeightDiff(node); // 균형인수 받기 
	
		if(heightDiff>1) // LL or LR상태 임을 의미
		{
			if(getHeightDiff(node.getLeftSubTree())>0) // LL상태 일 경우
			{System.out.println("");
				System.out.println("catch LL");
				System.out.println("키 "+ node.key + "에서부터 회전 진행");
				node = RotateLL(node);		
			}
			else // LR 상태일 경우 
			{System.out.println("");
				System.out.println("catch LR");
				System.out.println("키 "+ node.key + "에서부터 회전 진행");
				node = RotateLR(node);
			}

		}
		
		if(heightDiff<-1) // -2이하인 경우 RR or RL상태 
		{
			if(getHeightDiff(node.getRightSubTree()) < 0 ) // RR 
			{
				System.out.println("키 "+ node.key + "에서부터 회전 진행");
				node = RotateRR(node);
				System.out.println("");
				System.out.println("catch RR");
				
			}
			else //RL상태 
			{
				System.out.println("키 "+ node.key + "에서부터 회전 진행");
				node = RotateRL(node);
				System.out.println("");
				System.out.println("catch RL");
				
			}
		}
		
		return node;
	}
	
	public int getHeight(TreeNode node) // 서브트리 중 가장 깊이가 깊은 케이스로 높이를 반환 
	{
		int leftHeight,rightHeight;
		
		if(node == null)
		{
			return 0;
		}
		
		leftHeight = getHeight(node.getLeftSubTree());
		rightHeight = getHeight(node.getRightSubTree());
		
		
		if(leftHeight> rightHeight) // 좌측 / 우측 서브트리중 깊이가 큰 것 선택해서 반환 
		{
			return leftHeight+1;
		}
		else
		{
			return rightHeight+1;
		}
		
		
		
	}
	
	
	public TreeNode RotateLL(TreeNode node) 
	{
		TreeNode pNode,cNode; // 부모 자식 노드 
		pNode = node;
		cNode = node.getLeftSubTree();
		
		pNode.chainLeftSubTree(cNode.getRightSubTree());
		cNode.chainRightSubTree(pNode);

		return cNode;
	}
	
	public void key()
	{
		System.out.println();
		System.out.println("현재 루트 키 : " + root.key);
	}
	
	public TreeNode RotateRR(TreeNode node)
	{
		TreeNode pNode,cNode;
		pNode = node;
		cNode = node.getRightSubTree();
		
		pNode.chainRightSubTree(cNode.getLeftSubTree());
		cNode.chainLeftSubTree(pNode);

		return cNode;
	}
	
	
	public TreeNode RotateLR(TreeNode node)
	{
		TreeNode pNode,cNode;
		pNode = node;
		cNode = node.getLeftSubTree();	

		pNode.chainLeftSubTree(RotateRR(cNode));
		return RotateLL(pNode);
	}
	
	public TreeNode RotateRL(TreeNode node)
	{
		TreeNode pNode,cNode;
		pNode = node;
		cNode = node.getRightSubTree();

		pNode.chainRightSubTree(RotateLL(cNode));
		return RotateRR(pNode);
	}
	
	
}


/*AVL bst = new AVL();



bst.BSTInsert(20, "20");
bst.BSTShowAll();
bst.BSTInsert(15, "15");
bst.BSTShowAll();
bst.BSTInsert(3, "3");
bst.BSTShowAll();
System.out.println("현재 루트 : " + bst.getRoot().getKey());
bst.BSTInsert(12, "12");
bst.BSTShowAll();
bst.BSTInsert(5, "5");
bst.BSTShowAll();
System.out.println("현재 루트 : " + bst.getRoot().getKey());
bst.BSTInsert(11, "11");
bst.BSTShowAll();
System.out.println("현재 루트 : " + bst.getRoot().getKey());
bst.BSTInsert(6, "6");
bst.BSTShowAll();
bst.BSTInsert(40, "40");
bst.BSTShowAll();
System.out.println("현재 루트 : " + bst.getRoot().getKey());
bst.BSTInsert(25, "25");
bst.BSTShowAll();
bst.BSTInsert(18, "18");
bst.BSTShowAll();*/
