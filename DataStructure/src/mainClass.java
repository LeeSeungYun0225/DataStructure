import java.io.*;


public class mainClass {
	public static void main(String[] args) throws IOException
	{
		AVL bst = new AVL();


		
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
		bst.BSTShowAll();
		
	}


	
	
	

}
