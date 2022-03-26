import java.io.*;

public class LinkedList { // 연결 리스트 
	public static void main(String[] args) throws IOException
	{

		_linkedList<Integer> list = new _linkedList();
		list.list_Insert(1);
		list.list_Insert(2);
		list.list_Insert(3);
		list.list_Insert(4);
		System.out.println("" + list.list_Count());
		list.list_Search();
		list.list_Clear();
	}
	
	
}




class _linkedList<T>  // 제네릭 타입으로 코드 재사용성 높임 
{
	Node<T> head;
	Node<T> cur;
	Node<T> tail;
	int numOfData;
	_linkedList()
	{
		head = null;
		cur = null;

		tail = null;
		numOfData = 0;
	}

	public void list_Insert(Object data) // 리스트에 data 추가 
	{
		Node newnode = new Node();
		newnode.data = (T) data;
		newnode.next = null;
		
		if(head == null) // 빈 리스트일 경우 
		{
			head = newnode; // 헤드가 새 노드를 가리키도록 
		}
		else  // 리스트가 이미 존재할 경우 
		{
			tail.next = newnode; // 마지막 노드에 새 노드 연결 
		}
		tail = newnode; // 꼬리는 새 노드를 가리키도록 
		numOfData+=1;
	}

	
	public Object list_deleteFirst()
	{
		if(head == null)
		{
			System.out.println("데이터 존재하지 않음");
			return null;
		}
		else 
		{
			Node<T> temp;
			temp = head;
			head = head.next;
			numOfData-=1;
			return temp.data;
		}
		
	}
	
	public void list_Search() // 리스트를 조회하는 메소드 
	{
		if(head == null)
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
	
	public void list_Clear() // 리스트를 소멸시킴 
	{
		if(head ==null)
		{
			System.out.println("데이터 존재하지 않음");
		}
		else
		{
			Node delNode = head;
			Node delNext = head.next;
			
			System.out.println("데이터 "+ delNode.printData_simple() + " 삭제");
			
			while(delNext != null)
			{
				delNode = delNext;
				delNext = delNode.next;
				System.out.println("데이터 "+ delNode.printData_simple() + " 삭제");
			}
			numOfData = 0;
		}
	}
	
	public int list_Count() // 리스트에 데이터 수 반환
	{
		return numOfData;
	}
	
	
	public void list_Remove(Object data)// 데이터 검색하여 삭제 
	{
		if(head == null)
		{
			System.out.println("데이터 존재하지 않음");
		}
		else
		{
			Node delNode = head;
			Node temp;
			if(delNode.data == data) // 첫 데이터가 삭제 대상일 경우 
			{
				System.out.println("데이터 "+ delNode.printData_simple() + " 삭제");
				head = delNode.next;
			}
			temp = head;
			
			
			while(delNode !=null)
			{
				delNode = delNode.next;
				if(delNode.data == data)
				{
					if(head == delNode)
					{
						head = delNode.next;
						temp = head;
					}
					else
					{
						temp.next = delNode.next;
						temp = temp.next;
					}
				}
			}
		}
	}
	

}


/*
class Node{

	Node next;
	int data; // 데이터의 형태는 변수 혹은 객체의 형태 
	public Node(int i) {
		// TODO Auto-generated constructor stub
		data = i;
	}

	public Node() // 노드를 초기화한다 . default constructor 기본 생성자 
	{	
		data = 0;
		next=null;
	}
	
	public void printNode()// 노드의 전체를 출력한다 
	{
		if(this.nodeFirst())
		{
			Node temp = this.next;
			while(temp !=null)
			{
				System.out.print(temp.data + " ");
				temp =temp.next;
			}
		}
		
	}
	public boolean nodeFirst() // 노드에 데이터 존재하는지 확인, true or false 리턴 
	{
		return this.next == null ? false : true;
	}
	
	public void deleteNode(int data) // data 값을 추적하여 노드를 삭제
	{
		if(this.nodeFirst())
		{
			Node temp = this.next;
			Node temp2 = this;
			while(temp != null)
			{
				if(temp.data == data)
				{
					temp2.next =temp.next; 
					temp = temp.next;
				}
				else
				{
					temp2 = temp;
					temp = temp.next;
					
				}
				
			}
		}
	}
	
	public void addNode(int data) // 리스트의 끝에 데이터 추가 
	{
		Node temp = this;
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		
		Node newnode = new Node();
		newnode.data = data;
		newnode.next= null;
		temp.next = newnode;
	}
	
	public int nodeCount() // 리스트 노드 갯수 반환 int형 
	{
		if(this.nodeFirst() == false)
		{
			return 0;
		}
		int count = 0;
		Node temp = this;
		while(temp.next!=null)
		{
			count+=1;
			temp = temp.next;
		}
		return count;
	}

}
*/


