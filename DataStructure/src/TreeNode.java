
public class TreeNode {
	public int key;
	public Object data;
	public TreeNode prev;
	public TreeNode next;
	
	public TreeNode()
	{
	}

	
	public TreeNode(int in_key,Object in_data)
	{
		key = in_key;
		data = in_data;
		prev = next = null;
	}
	
	
	
	public Object getData() // 데이터 반환 
	{
		return data;
	}
	
	public int getKey() // 키 반환 
	{
		return key;
	}
	
	
	public void chainLeftSubTree(TreeNode subnode) // 왼쪽 서브트리 연결 
	{
		prev = subnode;
	}

	public void chainRightSubTree(TreeNode subnode) // 오른쪽 서브트리 연결 
	{
		next = subnode;
	}
	public TreeNode getLeftSubTree() // 왼쪽 서브트리 반환
	{		
		return prev;
	}
	
	public TreeNode getRightSubTree() // 오른쪽 서브트리 반환
	{
		return next;
	}
	
	public void setData(Object in) // 데이터 저장
	{
		data = in;
	}
	public void setKey(int in_key)
	{
		key = in_key;
	}
	
	
}
