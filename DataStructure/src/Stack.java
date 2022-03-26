
public class Stack<T> { // LIFO, 후입선출 , 배열 사용 
	private final int Array_Size = 10;
	T data[];
	int top;
	
	

	Stack()
	{
		data = (T[]) new Object[Array_Size];
		top = -1;
	}
	
	
	public void push(Object data_in) // 삽입 
	{
		
		data[++top] = (T) data_in;
	}
	
	public Object pop() // 꺼내기 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return data[top--];
		}
		
	}
	
	public Object peek() // 조회 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return (T) data[top];
		}
	}
	
	public boolean isEmpty() // 스택이 비었는가를 반환 
	{
		return top==-1 ? true : false;
	}
}

/* main testing 
 * 		Stack<Integer> stack = new Stack();
		
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(1);
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
 */


