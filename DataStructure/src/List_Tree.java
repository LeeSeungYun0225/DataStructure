 
public class List_Tree  {

	
	List_Tree()
	{}

	public void InorderTraverse(TreeNode node)  // 중위순회 ,
	{
		if(node == null)
		{
			return;
		}

		InorderTraverse(node.getLeftSubTree());
		
		
		System.out.print(node.key+", " );

		InorderTraverse(node.getRightSubTree());
	}
	
	
	public void PreorderTraverse(TreeNode node) // 전위 순회,
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.key + "");

		PreorderTraverse(node.getLeftSubTree());


		PreorderTraverse(node.getRightSubTree());

	}
	
	public void PostorderTraverse(TreeNode node) // 후위순회 
	{
		if(node == null)
		{
			return;
		}

		PostorderTraverse(node.getLeftSubTree());

		PostorderTraverse(node.getRightSubTree());

		System.out.print(node.key 	+ "");
	}

}


/*List_Tree root = new List_Tree();
		List_Tree t1 = new List_Tree();
		
		
		List_Tree<String> t2 = new List_Tree();
		List_Tree<String> t3 = new List_Tree();
		List_Tree<String> t4 = new List_Tree();
		List_Tree<String> t5 = new TreeNode();
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
