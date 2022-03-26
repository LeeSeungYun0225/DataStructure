
public class PQueue extends heap {
	
	
	private static final int HEAP_SIZE = 100;
	private heap h_arr[];
	private int numOfData;
	
	
	
	PQueue()
	{
		numOfData = 0;
		
		h_arr = new heap[HEAP_SIZE];
		
	}
	
	
	public void HeapInit()
	{
		numOfData = 0;
	}
	
	public boolean HeapIsEmpty()
	{
		return numOfData ==0 ? true : false;
	}
	

	public void HeapInsert(int data) 
	{
		int idx = numOfData+1;
		heap temp = new heap();
		
		temp.data = data;
		
		while(idx != 1)
		{
			if(getPriority(data,h_arr[getParentIdx(idx)].data)>0)
			{
				h_arr[idx] = h_arr[getParentIdx(idx)];
				idx = getParentIdx(idx);
			}
			else
			{
				break;
			}
		}
		
		h_arr[idx]= temp;
		numOfData ++;
	}
	
	
	public int getPriority(int a,int b)
	{
		return b-a;
	}
	public int HeapDelete()// 루트 데이터 삭제 
	{
		if(numOfData == 0)
		{
			return -1;
		}
		heap temp = h_arr[1];
		heap last = h_arr[numOfData];
		
		int parentIdx = 1;
		int childIdx;
		childIdx = getHighPriorityChildIdx(parentIdx);
		while(childIdx !=0)
		{
			
			if(getPriority(last.data,h_arr[childIdx].data) >= 0)//last.priority <= h_arr[childIdx].priority)
			{
				break;
			}
			
			h_arr[parentIdx] = h_arr[childIdx];
			parentIdx = childIdx;
			
			childIdx = getHighPriorityChildIdx(parentIdx);
		}
		
		
		h_arr[parentIdx] = last;
		numOfData --;
		
		return temp.data;
	}	
	public int getParentIdx(int index)
	{
		return index/2;
	}
	
	public int getLChildIdx(int index)
	{
		return index*2;
	}
	
	
	public int getRChildIdx(int index)
	{
		return index*2+1;
		
	}
	
	public int getHighPriorityChildIdx(int idx)
	{
		if(getLChildIdx(idx) > numOfData)
		{
			return 0;
		}
		else if(getLChildIdx(idx) == numOfData)
		{
			return getLChildIdx(idx);
		}
		else
		{
			if(getPriority(h_arr[getLChildIdx(idx)].data,h_arr[getRChildIdx(idx)].data) < 0)//h_arr[getLChildIdx(idx)].priority> h_arr[getRChildIdx(idx)].priority)
			{
				return getRChildIdx(idx);
			}
			else
			{
				return getLChildIdx(idx);
			}
		}
	}
	

}

/*
 * 	PQueue<String> pq = new PQueue<String>();
		
		
		pq.HeapInit();
		
		
		pq.HeapInsert("A", 1);
		pq.HeapInsert("B", 2);
		pq.HeapInsert("C", 3);
		System.out.println("" + pq.HeapDelete());
		
		pq.HeapInsert("A", 1);
		pq.HeapInsert("B", 2);
		pq.HeapInsert("C", 3);
		System.out.println("" + pq.HeapDelete());
		
		while(!pq.HeapIsEmpty())
		{
			System.out.println(""+ pq.HeapDelete());
		}
	}
	*/


