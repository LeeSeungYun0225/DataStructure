
public class Queue_List<T> extends _linkedList<T>{ // 연결 리스트 큐 
	
	Node<T> front;
	Node<T> rear;
	
	public Queue_List()
	{
		front = null;
		rear = null;
		
	}
	
	
	public void enQueue(Object data_in)
	{
		
		list_Insert(data_in);
		
		if(queueIsEmpty())
		{
			front = this.head;
			rear = this.head;
		}
		else
		{
			rear = tail;
		}
	}
	
	public Object deQueue()
	{
		if(queueIsEmpty())
		{
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		
		Node<T> temp;
		temp = front;
		front = front.next;
		list_deleteFirst();
		return temp.data;
	}
	public Object qPeek()
	{
		if(queueIsEmpty())
		{
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		
		return front.data;
	}
	
	public boolean queueIsEmpty()
	{
		return front == null ? true : false;	
	}
	
	
}

/* main 
 * 		Queue_List<Integer> queue = new Queue_List<Integer>();
		
		queue.enQueue(1);
		
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		
		queue.list_Search();
		
		System.out.println(queue.deQueue());
		queue.list_Search();
		System.out.println(queue.qPeek());
		
		queue.enQueue(2);
		queue.enQueue(1);
		
		queue.list_Search();
		*/
