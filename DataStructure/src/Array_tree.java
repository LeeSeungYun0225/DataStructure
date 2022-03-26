
public class Array_tree<T> { // 완전 이진트리 , 왼쪽부터 채워나감 
	
	private static final int sizeof_tree = 20;
	T[] arr; //제네릭 타입 T에 따라서 출력 형태는 달라져야한다 (show_... 메소드)
	int cursor = 0;
	
	
	Array_tree()
	{
		arr = (T[]) new Object[sizeof_tree+1];
	}
	

	
	public void init_Tree()
	{
		for(int i=1;i<arr.length;i++)
		{
			arr[i] = null;
		}
	}
	
	
	public boolean isEmpty()
	{
		return arr[1] == null ? true : false;
	}
	
	public boolean isFull()
	{
		return cursor == sizeof_tree ? true : false;
	}
	
	
	public void add_Node(T in)
	{
		if(isFull())
		{
			return;
		}
		arr[++cursor] = in;
		
	}
	
	public Object delete_Node()// 마지막 노드 제거 
	{
		if(isEmpty())
		{
			return null;
		}
		return arr[cursor--];
	}
	
	public void show_Lchild(int position) // 입력받은 위치의 왼쪽 자식 출력 
	{
		if(position > cursor)
		{
			System.out.println("존재하지 않는 데이터 위치입니다.");
		}
		else if(position*2 > cursor)
		{	
			System.out.println("해당 위치의 왼쪽 자식은 존재하지 않습니다.");
		}
		else
		{
			System.out.println("왼쪽 자식은 " + arr[position*2] + "입니다");
		}
	}
	
	public void show_Rchild(int position) // 입력받은 위치의 오른쪽 자식 출력 	
	{
		if(position > cursor)
		{
			System.out.println("존재하지 않는 데이터 위치입니다.");
		}
		else if(position*2+1 > cursor)
		{	
			System.out.println("해당 위치의 왼쪽 자식은 존재하지 않습니다.");
		}
		else
		{
			System.out.println("오른쪽 자식은 " + arr[position*2+1] + "입니다");
		}
	}
	
	public void show_Parents(int position) // 입력받은 위치의 부모를 모두 출력 
	{
		if(position <=1 || position > cursor)
		{
			return;
		}

		
		System.out.println("부모노드 : " + arr[position/2]);
		show_Parents(position/2);
	}
}


/* main Statement
 *  	Array_tree<String> tree = new Array_tree<String>();
		
		tree.add_Node("A");
		tree.add_Node("B");
		tree.add_Node("C");
		tree.add_Node("D");
		tree.add_Node("E");
		tree.add_Node("F");
		tree.add_Node("G");
		tree.add_Node("H");
		
		tree.show_Lchild(1);
		tree.show_Rchild(2);
		tree.show_Parents(6);
		
		tree.delete_Node();
		
		tree.show_Parents(8);  */
