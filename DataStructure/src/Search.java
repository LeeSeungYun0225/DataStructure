import java.io.*;


public class Search { // 탐색 알고리즘 
	
	public static void main(String[] args) throws IOException
	{

		int arr[] = {1,2,3,4,5,6,7,8,9,10,22,33,44};
		
		int index;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		index = BinarySearch(arr,33);
		
		bw.write(index+"");
		bw.flush();
		bw.close();
		
		
	}
	
	
	
	public static int LinearSearch(int[] array,int target) // 순차탐색 
	{	
		
		for(int i=0;i<array.length;i++)
		{
			if(array[i]==target)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static int BinarySearch(int[] array,int target)// 이진탐색, 배열이 정렬된 경우에만 사용 가능 
	{
		
		int front=0,rear=array.length-1;
		int half;
		
		while(front<=rear)
		{
			half = (front+rear)/2;
			if(array[half]==target)
			{
				return half;
			}
			else if(array[half]>target)
			{
				rear = half-1;
			}
			else if(array[half]<target)
			{
				front = half+1;
			}
			
		}
		
		return -1;
		
	}
	
	public static int MergeSort(int[] arr)
	{
		
		return -1;
	}
}
