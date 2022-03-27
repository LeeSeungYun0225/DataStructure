
public class TreeNode {
	public int key;
	public Object data;
	public TreeNode prev;
	public TreeNode next;
	
	
	public TreeNode()
	{
		key = 0;
		data = null;
		prev = next = null;
	}
	public TreeNode(int in_key,Object in_data)
	{
		key = in_key;
		data = in_data;
		prev = next = null;
	}
}
