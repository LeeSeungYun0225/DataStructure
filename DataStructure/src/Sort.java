
public class Sort { // 정렬 알고리즘 
	
	
	public Sort()
	{}
	
	// 퀵소트는 최악 n^2, 평균적으로 nlog_2 n, 데이터의 이동이 적게 발생하고 별도의 메모리공간이 필요하지 않으며 평균적으로 가장 빠름 
	public void QuickSort(int[] arr,int left,int right) // 피봇(기준점)을 정해 이를 기준으로 작은값과 큰 값으로 나누어 정렬하는 방법 ㅇ
	{
		if(left <= right)
		{
			int pivot = Partition(arr,left,right); // 파티션 함수를 통해 정렬 된 값 
			QuickSort(arr,left,pivot-1);
			QuickSort(arr,pivot+1,right);
		}
	}
	
	public int Partition(int[] arr,int left,int right) {
		int pivot = arr[left]; //  피봇 설정 
		int low = left+1; // 오른쪽으로 이동하며 피봇보다 큰 값 찾기 
		int high = right; // 왼쪽으로 이동하며 피봇보다 큰 값 찾기 
		
		while(low<=high) // 로우 하이가 교차되면 탈출한다 . 
		{
			while(pivot > arr[low])
			{
				low++;
			}
			
			while(pivot<arr[high])
			{
				high--;
			}
			
			if(low<=high) // 교차 된 상태가 아니면 교환 
			{
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		
		int temp = arr[left];
		arr[left] = arr[high];
		arr[high] = temp;
		
		return high;
		
	}
	
	public static void MergeSort(int[] arr,int start,int end) // 병합정렬  구현 
	{
		int mid;
		
		if(start<end) // 재귀 탈출 조건 
		{
			mid = (start+end)/2;
			
			MergeSort(arr,start,mid); // 시작부터 중간 지점까지 병합정렬 호출 
			MergeSort(arr,mid+1,end); // 중간지점+1부터 끝 지점까지 병합정렬 호출 
			
			Merge(arr,start,mid,end); // 병합 함수 호출 >> 합치면서 앞에서부터 정렬하며 합친다 . 
			
		}
	}
	
	public static void Merge(int[] arr,int start,int mid, int end) // 병합절렬의 병합 함수 
	{
		int[] temp = new int[arr.length]; // 정렬한 데이터를 담기위한 임시 배열 
		int left = start; 
		int right = mid+1;
		int tempstart = left;
		
		while(left <=mid && right <=end) // 병합 하고자 하는 배열 두개 A, B의 데이터가 모두 남아있는 동안 실행 
		{
			if(arr[left] <= arr[right])
			{
				temp[tempstart++] = arr[left++];
				
			}
			else
			{
				temp[tempstart++] = arr[right++];
			}
		}
		
		if(left>mid) // 병합하고자 하는 배열 중 좌측 배열 (A)의 데이터가 모두 소진되었을 시에, 
		{
			for(int i=right;i<=end;i++) // 우측 배열 B의 데이터를 남은 공간에 하나씩 넣어준다. 
			{
				temp[tempstart++] = arr[i];
			}
		}
		else // 병합하고자 하는 배열 중 우측 배열 B의 데이터가 모두 소진되었을 경우 
		{
			for(int i=left;i<=mid;i++)
			{
				temp[tempstart++] = arr[i];
			}
		}
		
		for(int i=start;i<=end;i++) // 원래의 배열 arr에 정렬된 배열 temp값을 넣어준다. 
		{
			arr[i] = temp[i];
			
		}
	}
	
	public static void HeapSort(int[] arr) // 힙소트 > 힙 자료구조를 이용한 정렬 방식 , 힙에 데이터를 넣었다가 제거하면 정렬되어 나오는 원리를 이용함  O(nLog_2 N)
	{
		PQueue pq = new PQueue();
		pq.HeapInit();
		
		for(int i=0;i<arr.length;i++) // 힙에 모든 데이터 삽입 
		{
			pq.HeapInsert(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) // 힙으로 부터 모든 데이터 추출 
		{
			arr[i] = pq.HeapDelete();
		}
	}
	
	
	public void InsertionSort(int[] arr)  // 이미 정렬 된 소 배열 안에 인덱스를 추가하는 형태로 정렬 O(N^2)	
	{
		int target;
		for(int i=1;i<arr.length;i++) //  i 인덱스는 이번에 추가되는 인덱스, 
		{
			target = arr[i];
			
			for(int j=i-1;j>=0;j--) // j인덱스는 역 순회 하며 추가된 인덱스의 값과 비교, 
			{
				if(target<arr[j])
				{
					arr[j+1] = arr[j]; // 추가된 값이 더 작은 값이면 이전 정렬 된 값 들을 뒤로 한칸씩 밀어낸다 . 
				}
				else
				{
					
					break;
				}
				arr[j] = target; // 새로 추가된 값의 위치를 찾으면 맞는 위치에 해당 데이터를 저장하여 정렬.
				
				
			}
			
		}
	}
	
	
	public void SelectionSort(int[] arr)  // 정렬 순서에 맞게 하나씩 선택해서 옮겨 정렬시키는 방법 . O(N^2)
	{
		int minidx;
		int temp;
		
		for(int i=0;i<arr.length-1;i++) // i 는 이번에 정렬을 완성하고자 하는 인덱스 
		{
			minidx =i;
			for(int j=i+1;j<arr.length;j++) //j 는 순회하며 가장 작은 값을 가진 인덱스를 가져온다 . 
			{
				if(arr[j] < arr[minidx]) 
				{
					minidx = j;
				}
			}
			
			temp =  arr[i];		
			arr[i] = arr[minidx];
			arr[minidx] =  temp;
		}
		
		
	}
	public void BubbleSort(int[] arr) // 배열의 앞 부분부터 두개의 데이터를 비교해 가며 정렬해 가는 방법 > 가장 우측 인덱스부터 정렬됨. O(N^2) 
	{	
		int temp;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
		}
	}
	
}
