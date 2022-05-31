import java.io.*;


public class mainClass {
	public static void main(String[] args) throws IOException
	{
		Graph grp = new Graph(7);
		grp.addEdge(0, 1);
		grp.addEdge(0, 3);
		grp.addEdge(1,2);
		grp.addEdge(3, 2);
		grp.addEdge(3, 4);
		grp.addEdge(4, 5);
		grp.addEdge(4, 6);
		grp.showGraph();
		grp.bfs(2);
	}


	
	
	

}
