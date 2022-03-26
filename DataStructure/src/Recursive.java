import java.io.*;


public class Recursive { // 재귀 알고리즘
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("재귀 함수 목록\n");
		bw.write("1. 팩토리얼\n");
		bw.write("2. 피보나치\n");
		bw.write("3. 이진 탐색\n");
		bw.write("4. 하노이 타워\n");
		bw.flush();
		
		
		
	
		int selection = Integer.parseInt(br.readLine());
		Select(selection);
		bw.close();
	}
	
	
	
	public static void Select(int selection) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switch(selection)
		{
		
			case 1:
			{
				bw.write("팩토리얼 N 입력\n");
				bw.flush();
				int n = Integer.parseInt(br.readLine());
				bw.write(n+"! = " +Factorial(n));
				bw.flush();
				bw.close();
				
				break;	
			}
			case 2:
			{
				bw.write("피보나치 N 입력\n");
				bw.flush();
				int n = Integer.parseInt(br.readLine());
				for(int i=1;i<=n;i++)
				{
					bw.write(Fibonacci(i)+" ");
				}
				
				bw.flush();
				bw.close();
				break;
			}
			case 3:
			{
				int arr[] = {1,4,6,7,8,11,14,33,34,37,42,53,66,72};
				bw.write("찾고자 하는 값 입력\n");
				bw.flush();
				int n = Integer.parseInt(br.readLine());
				if(Binarysearch(arr,0,arr.length,n)==-1)
				{
					bw.write("배열에 없는 값입니다.");
				}
				else
				{
					bw.write(n +"은 인덱스 "+Binarysearch(arr,0,arr.length,n)+"에 있습니다.");
				}
				
				
				
				bw.flush();
				bw.close();
				break;
			}
			case 4:
			{
				bw.write("원반 갯수 입력\n");
				bw.flush();
				
				int n= Integer.parseInt(br.readLine());
				HonoiTower(n,'A','B','C');
				
				bw.flush();
				bw.close();
				break;
			}
		}
	
	
	
		
	}
	
	public static void HonoiTower(int num,char from,char by, char to) // 하노이 타워 , from에서 by를 거쳐 to로 이동 
	{
		
		if(num==1)
		{
			System.out.println("원반1을 "+ from +"에서 " + to+"로 이동");
		}
		else
		{
			HonoiTower(num-1,from,to,by);
			System.out.println("원반"+num+"을 "+from+"에서 " +to +"로 이동");
			HonoiTower(num-1,by,from,to);
		}
	}
	
	public static int Binarysearch(int[] arr,int first,int last,int target) // 이진탐색 
	{
		if(first>last)
		{
			return -1;
		}
		int mid = (first+last)/2;
	
		return arr[mid]==target ? mid : arr[mid]>target ? Binarysearch(arr,first,mid-1,target) : arr[mid]<target ? Binarysearch(arr,mid+1,last,target) : -1;
	}
	
	public static int Fibonacci(int n) // 피보나치 같은 케이스는 메모이제이션 방식으로 보다 효율적으로 설계 가능
	{
		if(n == 1)
		{
			return 0;
			
		}
		else if(n==2)
		{
			return 1;
		}
		else 
		{
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
	}
	
	public static int Factorial(int n) // 팩토리얼 
	{
		if(n == 0)
		{
			return 1;
		}
		else
		{
			return n*Factorial(n-1);
		}
	}
	
}
