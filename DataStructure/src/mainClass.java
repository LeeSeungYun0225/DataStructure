import java.io.*;


public class mainClass {
	public static void main(String[] args) throws IOException
	{
		BinarySearchTree bst = new BinarySearchTree();
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
	}	
	
	
	

}
