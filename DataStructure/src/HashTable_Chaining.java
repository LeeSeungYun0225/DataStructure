
public class HashTable_Chaining<Data> {
	// 체이닝 방식을 이용한 예시 
	// 체이닝 방식은 데이터가 많아 질수록 효율적
	// 체인이 길어지면 비효율적이나, 해시 함수를 효율적으로 정의하여 데이터가 고르게 분산 저장된다면 효율적이다.
	
	private int sizeOfTable = 15;
	private Node<Data> hash_List[] = new Node[sizeOfTable];
	
	
	public HashTable_Chaining()
	{
		initTable();
	}

	public void initTable()
	{
		for(int i=0;i<sizeOfTable;i++)
		{
			hash_List[i] = new Node<Data>();
		}
	}
	
	public void insert(int key_in,Data data_in)
	{
		Node newNode = new Node(key_in,data_in);
		
		int index = hashFun(key_in);
		Node current = hash_List[index];
		while(current.next != null)
		{
			current = current.next;
		}
		
		current.next = newNode;
		
	}
	
	public void delete(int key_in)
	{
		int index = hashFun(key_in);
		Node current = hash_List[index];
		while(current.next != null)
		{
			if(current.next.key == key_in)
			{
				current.next = current.next.next;
				System.out.println("데이터 삭제 완료 _key : " + key_in);
				return;
			}
		
			current = current.next;
		}
		
		System.out.println("데이터 존재하지 않음");
		
	}
	
	public void search(int key_in)
	{
		int index = hashFun(key_in);
		int index2 = 0;
		Node current = hash_List[index];
		while(current.next != null)
		{
			if(current.next.key == key_in)
			{
				System.out.println("찾고자 하는 키 "+  key_in + "는 테이블 인덱스 " +index +"에 " + index2 + "번째에 존재");
				
				return;
			}
			index2++;
			current = current.next;
		}
		System.out.println("데이터 존재하지 않음");
		
	}
	
	public void showTable()
	{
		Node current;
		for(int i=0;i<sizeOfTable;i++)
		{
			current = hash_List[i].next;
			System.out.print(i+ "인덱스 데이터 : ");
			
			while(current!= null)
			{
				System.out.print(">> " + current.key);
				current = current.next;
			}
			
			System.out.println("");
		}
	}
	
	
	public int hashFun(int key_in)
	{
		return key_in%sizeOfTable;
	}
	
	public class Node<Data>
	{
		int key;
		Data data;
		Node<Data> next;
	
		public Node()
		{
			next = null;
		}
		
		public Node(int key_in,Data data_in)
		{
			key = key_in;
			data =data_in;
			next = null;
		}
		
	}
}


/*		HashTable_Chaining<String> ht = new HashTable_Chaining<String>();

ht.insert(1, "1");
ht.insert(2, "2");
ht.insert(17, "17");
ht.insert(18, "18");

ht.insert(16, "16");
ht.insert(5, "5");
ht.delete(16);
ht.showTable();
*/
