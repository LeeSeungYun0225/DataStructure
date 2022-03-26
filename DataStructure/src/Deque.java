
public class Deque<T> extends Doubly_linked_list<T>{ // 덱, 양방향 입출력 자료구조, 양방향 연결 리스트를 상속받아 그대로 사용 

	
	public Deque() // 기본 생성자를 이용한 초기화 
	{
		head  = null;
		cur =  null;
		tail =  null;
		numOfData = 0;
	}	
	
	public boolean dequeIsEmpty() // 덱이 비었는지 true or false 반환 
	{
		return list_IsEmpty();
	}
	
	public void dequeAddFirst(Object data_in) // 덱의 앞에 데이터 입력 
	{
		list_InsertFirst(data_in);
	}
	
	public void dequeAddLast(Object data_in) // 덱의 마지막에 데이터 입력 
	{
		list_InsertLast(data_in);
	}
	
	public Object dequeRemoveFirst() // 덱의 첫 데이터 삭제 후 반환 
	{
		return list_deleteFirst();
	}
	public Object dequeRemoveLast() // 덱의 마지막 데이터 삭제 후 반환 
	{
		return list_deleteLast();
	}
	
	
	public Object dequeGetFirst() // 덱의 첫 데이터 반환하고 삭제는 일어나지 않음 
	{
		return  list_First();
	}
	
	public Object dequeGetLast() // 덱의 마지막 데이터를 반환하고 삭제는 일어나지 않음 
	{
		return list_Last();
	}

}
