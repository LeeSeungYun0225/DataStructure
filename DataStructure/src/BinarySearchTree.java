
public class BinarySearchTree extends List_Tree { // 이진 탐색 트리, 이진 트리(연결리스트형)을 상속받는다. 	
	 // 이진 탐색 트리는 데이터의 수에 비해 매우 효율적으로 데이터를 탐색할 수 있다는 장점을 갖는다. 
	
	TreeNode root = new TreeNode();
	
	public BinarySearchTree()
	{
		root =null;
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
		
	
		
		return deleteTarget;
	}
	
	public void BSTShowAll()
	{
		InorderTraverse(root);
	}
	

}



/* 메인클래스 테스트용 구문 
 * BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode();
		bst.BSTMakeAndInit(root);
		
		bst.BSTInsert(root, 9, "9");
		bst.BSTInsert(root, 1, "1");
		bst.BSTInsert(root, 6, "6");
		bst.BSTInsert(root, 2, "2");
		bst.BSTInsert(root, 8, "8");
		bst.BSTInsert(root, 3, "3");
		bst.BSTInsert(root, 5, "5");
		
		TreeNode search;
		
		search = bst.BSTSearch(root, 1);
		
		if(search == null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("키 값 "+ search.key + "을 찾았습니다.");
		}
		
		search = bst.BSTSearch(root, 4);
		
		if(search == null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("키 값 "+ search.key + "을 찾았습니다.");
		}
		
		search = bst.BSTSearch(root, 6);
		
		if(search == null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("키 값 "+ search.key + "을 찾았습니다.");
		}
		search = bst.BSTSearch(root, 7);
		
		if(search == null)
		{
			System.out.println("탐색 실패");
		}
		else
		{
			System.out.println("키 값 "+ search.key + "을 찾았습니다.");
		}
		
		*/


