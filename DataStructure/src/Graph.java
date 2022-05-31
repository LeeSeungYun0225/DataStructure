
public class Graph { // with linked list // 
	
	
	private int numberOfVertax;
	private GraphNode[] list;
	private Queue_List<Integer> queue; // bfs용 큐 선언 
	private boolean visited[];
	
	
	public Graph(int number)
	{
		list = new GraphNode[number];
		visited = new boolean[number];
		graphInit(number);
		numberOfVertax=number;
		queue = new Queue_List<Integer>();
		
		
	}
	
	
	public void bfs(int start)
	{
		visited[start] =true;
		GraphNode current = list[start].next;
		System.out.print(" " + list[start].vertaxName +" 방문 " );
		while(current!= null)
		{
			if(!visited[current.getVerNum()])
			{
				visited[current.getVerNum()] = true;
				queue.enQueue(current.getVerNum());
			}
			current = current.next;
		}
		
		if(queue.queueIsEmpty())
		{
			initVisited();
			return;
		}
		bfs(queue.deQueue());
	}
	
	
	public void dfs(int start) // 스택을 사용하는 방법도 있다. 다만 내부적으로 스택과 동일하게 작동하기에 기능상 동일함.
	{
		visited[start] = true;
		GraphNode current = list[start].next;
		System.out.print(" " + list[start].vertaxName +" 방문 " );
		while(current!= null)
		{
			if(!visited[current.getVerNum()])
			{
				dfs(current.getVerNum());		
			}
			current = current.next;
			
		}
	}
	
	public void initVisited()
	{
		for(int i=0;i<visited.length;i++)
		{
			visited[i] = false;
		}
	}
	
	public void addEdge(int from,int to)
	{
		insert(from,to);
		insert(to,from);
		
	}
	public void insert(int index,int target)
	{
		GraphNode newNode = new GraphNode(list[target].getVertaxName(),target);
		
		GraphNode current = list[index];
		while(current.next != null)
		{
			current = current.next;
		}
		
		current.next = newNode;
		
	}
	
	public void graphInit(int vertaxNum)
	{
		numberOfVertax = vertaxNum;
		String vertaxName = "";
		for(int i=0;i<vertaxNum;i++)
		{
			switch(i)
			{
			case 0:
				vertaxName = "A";
				break;
			case 1:
				vertaxName = "B";
				break;
			case 2:
				vertaxName = "C";
				break;
			case 3:
				vertaxName = "D";
				break;
			case 4: 
				vertaxName = "E";
				break;
			case 5:
				vertaxName = "F";
				break;
			case 6:
				vertaxName = "G";
				break;
			case 7:
				vertaxName = "H";
				break;
			case 8: 
				vertaxName = "I";
				break;
			case 9:
				vertaxName = "J";
				break;
			}
			list[i] = new GraphNode(vertaxName,i);
			visited[i] = false;	
		}
	}
	
	
	public void showGraph()
	{
		GraphNode current;
		for(int i=0;i<numberOfVertax;i++)
		{
			current = list[i];
			
			System.out.print("점 " +  current.getVertaxName() + " 연결 상태 : ");
			
			while(current.next!= null)
			{
				
				current = current.next;
				System.out.print(" >> " + current.getVertaxName());
			}
			
			System.out.println("");
		}
	}
	
	

	
	
	public class GraphNode{
		private GraphNode next;
		private String vertaxName;
		private int vertaxNum;
		
		public GraphNode()
		{
			next = null;
		}
		public GraphNode(String name,int verNum)
		{
			vertaxName = name;
			next = null;
			vertaxNum = verNum;
		}
		
		public String getVertaxName()
		{
			return vertaxName;
		}
		public int getVerNum()
		{
			return vertaxNum;
		}
	}
	
}

