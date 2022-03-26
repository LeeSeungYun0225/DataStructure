
public class Queue<T> { // 원형 큐 개념으로 구현 
	
	T data[];
	int front,rear;
	private final int queueSize = 10;
	public Queue() {
		data = (T[]) new Object[queueSize];
		front = 0;
		rear = 0;
	}
	
	public boolean queueIsFull()
	{
		return (rear==queueSize-1 &&  front == 0) || rear == front-1 ? true : false;
	}
	
	public void queueInit()
	{
		data = (T[]) new Object[queueSize];
		front = 0;
		rear = 0;
	}
	
	public boolean queueIsEmpty()
	{
		return front == rear ? true : false;
	}
	
	public void enQueue(T data_in)
	{
		if(queueIsFull())
		{
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		else
		{
			if(rear == queueSize -1)
			{
				rear = 0;
				data[rear] = data_in;
			}
			else
			{
				data[++rear] =  data_in;
			}
			
		}
	}
	
	public Object deQueue() 
	{
		if(queueIsEmpty())
		{
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		
		if(front == queueSize-1)
		{
			front = 0;
			return (T) data[front];
		}
		else
		{
			return (T) data[++front];
		}

	}
	
	public Object qPeek()
	{
		if(queueIsEmpty())
		{
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		if(front == queueSize-1)
		{
			return (T) data[0];
		}
		else
		{
			return (T) data[front+1];
		}
	}
	
	
}

/* main
Queue<Integer> queue = new Queue<Integer>();

queue.enQueue(1);
queue.enQueue(2);
queue.enQueue(3);
queue.enQueue(4);

System.out.println("peek : " + queue.qPeek());

queue.enQueue(5);
queue.enQueue(6);
queue.enQueue(7);
queue.enQueue(8);
queue.enQueue(9);
queue.enQueue(10);
queue.enQueue(11);
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
queue.enQueue(10);
queue.enQueue(11);
queue.enQueue(12);
System.out.println("peak : " + queue.qPeek());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
queue.enQueue(5);
queue.enQueue(6);
queue.enQueue(7);
queue.enQueue(8);
queue.enQueue(9);
queue.enQueue(10);
queue.enQueue(11);
queue.enQueue(5);
queue.enQueue(6);
queue.enQueue(7);
queue.enQueue(8);
queue.enQueue(9);
queue.enQueue(10);
queue.enQueue(11);
System.out.println("peak : " + queue.qPeek());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("peak : " + queue.qPeek());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("peak : " + queue.qPeek());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
System.out.println("dequeue : " + queue.deQueue());
*/