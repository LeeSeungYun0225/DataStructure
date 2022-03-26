
public class Doubly_linked_list<T> { // 양방향 연결 리스트 
	
	Doubly_node<T> head;
	Doubly_node<T> cur;
	Doubly_node<T> tail;
	int numOfData;
	
	public Doubly_linked_list()
	{
		head  = null;
		cur =  null;
		tail =  null;
		numOfData = 0;
	}
	
	public boolean list_IsEmpty() // 리스트가 비어있으면 true or false 반환 
	{
		return head == null ? true : false;
	}
	
	public void list_InsertFirst(Object data_in) // 리스트 첫 데이터 삽입 
	{
		Doubly_node<T> newnode = new Doubly_node<T>();
		newnode.data = (T) data_in;
		newnode.prev = null;

		newnode.next = head;
		
		if(!list_IsEmpty())
		{
			head.prev = newnode;
		}
		
		head = newnode;
		numOfData ++;
		if(tail == null)
		{
			tail = newnode;
		}
	}
	
	public void list_InsertLast(Object data_in) // 리스트 마지막 데이터 삽입 
	{
		Doubly_node<T> newnode = new Doubly_node<T>();
		newnode.data = (T) data_in;
		newnode.next = null;
		
		newnode.prev = tail;
		if(!list_IsEmpty())
		{
			tail.next = newnode;
		}
		
		tail = newnode;
		
		numOfData++;
		
		if(head == null)
		{
			head = newnode;
		}
		
	}
	
	
	public Object list_deleteFirst() // 리스트 첫 데이터 반환 , 삭제 
	{
		
		
		if(list_IsEmpty())
		{
			System.out.println("데이터 없음");
			return null;
		}
		else
		{
			Doubly_node<T> temp = head;
			if(cur == head)
			{
				cur = null;
			}
			head = head.next;
			head.prev = null;
			numOfData--;
			return temp.data;
		}
		
	}
	
	public Object list_deleteLast() // 리스트 마지막 데이터 반환, 삭제 
	{
		if(list_IsEmpty())
		{
			System.out.println("데이터 없음");
			return null;
		}
		else
		{
			Doubly_node<T> temp = tail;
			if(cur == tail)
			{
				cur = null;
			}
			tail = tail.prev;
			tail.next = null;
			numOfData--;
			return temp.data;
		}

	}
	
	public void list_Search() // 리스트를 앞에서부터 출력 
	{
		if(list_IsEmpty())
		{
			System.out.println("데이터 존재하지 않음.");
		}
		else 
		{
			cur = head;  // 커서가 헤드를 가리키도록 
			cur.printData();
			
			while(cur.next !=null)
			{
				cur = cur.next;
				cur.printData();
			}
		}
	}
	
	public void list_RSearch() // 리스트를 뒤에서부터 출력 
	{
		if(list_IsEmpty())
		{
			System.out.println("데이터 존재하지 않음.");
		}
		else 
		{
			cur = tail;  // 커서가 헤드를 가리키도록 
			cur.printData();
			
			while(cur.prev !=null)
			{
				cur = cur.prev;
				cur.printData();
			}
		}
	}
	
	public int list_Count() // 리스트 노드 갯수 반환 
	{
		return numOfData;
	}
	
	
	public Object list_First() // 리스트 첫번째 데이터 반환 
	{
		if(list_IsEmpty())
		{
			System.out.println("데이터 존재하지 않음.");
			return null;
		}
		return head.data;
	}
	
	public Object list_Last() // 리스트 마지막 데이터 반환 
	{
		if(list_IsEmpty())
		{
			System.out.println("데이터 존재하지 않음.");
			return null;
		}
		return tail.data;
	}
	
	public Object list_Next() // 커서의 다음 데이터 반환 
	{
		if(list_IsEmpty())
		{
			System.out.println("데이터 존재하지 않음.");
			return null;
		}
		if(cur == null)
		{
			cur = head;
			return cur.data;
		}
		if(cur.next != null)
		{
			cur = cur.next;
			return cur.data;
		}
		else
		{
			System.out.println("커서가 끝입니다.");
			return null;
		}
		
	}
	public Object list_Prev() // 커서의 이전 데이터 반환 
	{
		if(list_IsEmpty())
		{
			System.out.println("데이터 존재하지 않음.");
			return null;
		}
		if(cur == null) // 커서가 초기화 되지 않았으면 , 
		{
			cur = tail;
			return cur.data;
		}
		if(cur.prev != null)
		{
			cur = cur.prev;
			return cur.data;
		}
		else
		{
			System.out.println("커서가 처음입니다.");
			return null;
		}
		
	}
	

	
}

/*
 * Doubly_linked_list<Integer> dll = new Doubly_linked_list<Integer>();
		
		dll.list_InsertFirst(3);
		dll.list_InsertFirst(2);
		dll.list_InsertFirst(1);

		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Prev());
		System.out.println(dll.list_Prev());
		
		dll.list_InsertLast(4);
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		System.out.println(dll.list_Next());
		dll.list_InsertLast(5);
		System.out.println(dll.list_Next());
		
		System.out.println(dll.numOfData);
		
		System.out.println(dll.list_deleteFirst());
		System.out.println(dll.list_deleteLast());
		System.out.println(dll.list_Prev());
		
		System.out.println(dll.numOfData);
		dll.list_RSearch();
		dll.list_Search();
		
		*/
