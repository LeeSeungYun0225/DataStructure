
public class BinarySearchTree extends List_Tree { // 이진 탐색 트리, 이진 트리(연결리스트형)을 상속받는다. 	
	 // 이진 탐색 트리는 데이터의 수에 비해 매우 효율적으로 데이터를 탐색할 수 있다는 장점을 갖는다. 

	
	public void BSTMakeAndInit(TreeNode node) // BST의 생성과 초기화 메소드 
	{
		node.next = null;
		node.prev = null;
		node.data = '.';
		node.key = -999;
	}
	
	public void BSTInsert(TreeNode root,int key,Object data) // BST에 새 노드 추가, 데이터 삽입 , 노드 생성과정도 포함됨 
	{
		TreeNode parent = null;
		TreeNode newnode = null;
		TreeNode current = root;
		
		// 새 노드의 적당한 위치 찾기 위한 while문, while문 탈출 시, 삽입되는 노드는 parent에 연결시킨다. 
		while(current != null)
		{
			if(key == getKey(current)) // 중복된 키라면 삽입을 중단한다. (키의 유일성 보존)
			{
				return;
			}
			
			
			parent = current;
			
			if(getKey(current) > key) // 현재 노드보다 작은 키일 경우에 
			{
				current =current.prev; //current = getLeftSubTree(current);
				
			}
			else // 현재 노드보다 큰 키일 경우에,
			{
				current = current.next;
			}
		}
		
		newnode = new TreeNode(key,data);
		
		if(parent != null) // 삽입하려는 노드가 루트 노드가 아닌 경우
		{
			if(parent.key > key) 
			{
				chainLeftSubTree(parent,newnode);
			}
			else
			{
				chainRightSubTree(parent,newnode);
			}
		}
		else // 루트 노드를 처음 삽입할 경우 
		{
			root = newnode;
		}
		
	}
	
	
	
	public TreeNode BSTSearch(TreeNode node,int targetKey) // BST에서 타겟 키를 탐색하는 메소드 
	{
		TreeNode current = node;
		
		while(current !=null) // current가 null이 되어 탈출하는 경우 >> 해당 키가 존재하지 않음을 의미 
		{
			if(targetKey == current.key) // 키를 찾으면 
			{
				return current; // 해당 노드 반환 
			}
			else if(targetKey < current.key) // 찾는 키가 지금노드의 키보다 작으면 
			{
				current  = current.prev; // 좌측 노드로 
			}
			else
			{
				current = current.next; // 우측 노드로 
			}
		}
		
		return null; // 해당 키는 저장되어 있지 않다.  
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


