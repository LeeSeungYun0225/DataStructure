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
	
	
	public int InterpolSearch(int[] array,int target) // 보간탐색 , 이진탐색을 개선하여 정렬 된 자료구조 내에서 찾고자 하는 데이터의 위치를 어느정도 예상하여 성능을 높인다.
	{
		int front=0,rear=array.length-1;
		double half;
		int idx;
		
		while(!(array[front]>target || array[rear] <target)) // 탈출 조건문도 이진탐색과 다르다 . 
		{
			half = (target-array[front])/(array[rear]-array[front])*(rear-front)+front; // 이진탐색은 단순히 배열을 반으로 나누지만, 보간 탐색은 저장된 데이터의 값과 데이터의 길이 등을 토대로 대략적 위치를 빠르게 추적함.
			idx= (int)half;
			if(array[idx]==target)
			{
				return idx;
			}
			else if(array[idx]>target)
			{
				rear = idx-1;
			}
			else if(array[idx]<target)
			{
				front = idx+1;
			}
			
		}
		
		return -1;
		
	}

}
