class Node<T> // 연결 리스트용 노드 
{
	T data;
	Node<T> next;
	
	Node()
	{
		data = null;
		next = null;
	}
	
	public void printData() // 데이터 출력 테스트를 위한 함수, data의 형태에 따라 수정이 필요함   ,, 제네릭 형태를 유지하면서 출력형태를 통일하는 방법이 없을까..
	{
		System.out.println("Data : " + data);
	}
	
	public String printData_simple() // 데이터 출력 테스트를 위한 함수, data의 형태에 따라 수정이 필요함 
	{
		return ""+data;
	}
}