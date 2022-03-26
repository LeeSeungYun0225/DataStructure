
public class Doubly_node<T> {
	
	T data;
	Doubly_node<T> next;
	Doubly_node<T> prev;
	public Doubly_node()
	{
		data = null;
		prev = null;
		next = null;
	}
	
	public void printData() // 데이터 출력 테스트를 위한 함수, data의 형태에 따라 수정이 필요함 
	{
		System.out.println("Data : " + data);
	}
	
	public String printData_simple() // 데이터 출력 테스트를 위한 함수, data의 형태에 따라 수정이 필요함 
	{
		return ""+data;
	}
}
