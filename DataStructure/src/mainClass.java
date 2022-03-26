import java.io.*;


public class mainClass {
	public static void main(String[] args) throws IOException
	{
		int[] test = {5,7,2,3,1,8,4,9};
		
		Sort st = new Sort();
		
		st.QuickSort(test,0,test.length-1);
		
		for(int i=0;i<test.length;i++)
		{
			System.out.print(" " + test[i]);
		}
	
	}
	
	
	

}
