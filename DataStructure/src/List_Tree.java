 
public class List_Tree {

	List_Tree()
	{}

	
	public Object getData(TreeNode node) // 데이터 반환 
	{
		return node.data;
	}
	
	public int getKey(TreeNode node) // 키 반환 
	{
		return node.key;
	}
	
	public void setData(TreeNode node, char in) // 데이터 저장
	{
		node.data = in;
	}
	
	public TreeNode getLeftSubTree(TreeNode node) // 왼쪽 서브트리 반환
	{
		return node.prev;
	}
	
	public TreeNode getRightSubTree(TreeNode node) // 오른쪽 서브트리 반환
	{
		return node.next;
	}
	
	
	
	
	public void chainLeftSubTree(TreeNode node,TreeNode subnode) // 왼쪽 서브트리 연결 
	{
		node.prev = subnode;
	}
	
	public void chainRightSubTree(TreeNode node,TreeNode subnode) // 오른쪽 서브트리 연결 
	{
		node.next = subnode;
	}
	
	
	public void InorderTraverse(TreeNode node)  // 중위순회 ,
	{
		
		if(getLeftSubTree(node) != null)
		{
			InorderTraverse(getLeftSubTree(node));
		}
		
		System.out.print(node.data + "");
		if(getRightSubTree(node) != null)
		{
			InorderTraverse(getLeftSubTree(node));
		}
		
	}
	
	public void PreorderTraverse(TreeNode node) // 전위 순회,
	{
		System.out.print(node.data + "");
		if(getLeftSubTree(node) != null)
		{
			PreorderTraverse(getLeftSubTree(node));
		}
		if(getRightSubTree(node) != null)
		{
			PreorderTraverse(getLeftSubTree(node));
		}
	}
	
	public void PostorderTraverse(TreeNode node) // 후위순회 
	{
		if(getLeftSubTree(node) != null)
		{
			PostorderTraverse(getLeftSubTree(node));
		}
		if(getRightSubTree(node) != null)
		{
			PostorderTraverse(getLeftSubTree(node));
		}
		System.out.print(node.data 	+ "");
	}

}


/*List_Tree<String> root = new List_Tree<String>();
		List_Tree<String> t1 = new List_Tree<String>();
		
		
		List_Tree<String> t2 = new List_Tree<String>();
		List_Tree<String> t3 = new List_Tree<String>();
		List_Tree<String> t4 = new List_Tree<String>();
		List_Tree<String> t5 = new List_Tree<String>();
		List_Tree<String> t6 = new List_Tree<String>();
		
		root.chainLeftSubTree(t1);
		
		root.chainRightSubTree(t2);
		t1.chainLeftSubTree(t3);
		t1.chainRightSubTree(t4);
		t4.chainLeftSubTree(t5);
		t4.chainRightSubTree(t6);
		
		root.setData("-");
		t1.setData("+");
		t2.setData("1");
		
		t3.setData("7");
		t4.setData("*");
		
		t5.setData("4");
		t6.setData("2");
		
		
		//System.out.println("" + root.getLeftSubTree().getLeftSubTree().getData());
		root.InorderTraverse();
		*/
