
public class ArrayList { // 배열 기반의 리스트 , 
	public static void main(String args[])
	{
		List<XY> list = new List();
		
		XY fir = new XY(4,7);
		XY sec = new XY(7,2);
		XY thr = new XY(10,64);
		
		XY temp = new XY();
		
		temp.printxy();
		list.list_Insert(fir);
		list.list_Insert(sec);
		list.list_Insert(thr);
		temp = list.list_First();
		
		temp.printxy();
		
		temp = list.list_Next();
		temp.printxy();
		temp = list.list_Next();
		temp.printxy();
		
		temp = list.list_Remove();
		temp.printxy();
		temp = list.list_Remove();
		temp.printxy();
	}


}

class XY // 리스트 테스트용 클래스 
{
	int x;
	int y;
	
	XY()
	{
		x=y=0;
	}
	
	XY(int x_,int y_)
	{
		x =x_;
		y = y_;
	}
	public void printxy() {
		System.out.println("x : " + x + "\ny : " + y );
	}
}

class List<T>{ // 제네릭을 활용하여 재사용성을 높일 수 있다 
	private final int array_length = 10;
	private int numOfData;
	private int cursor;
	private Object[] arr = new Object[array_length];
	List() // 기본 생성자 
	{
		numOfData = 0;
		cursor = -1;
	}
	
	public void list_Insert(Object data) // 데이터를 추가한다 . 
	{
		if(numOfData>=array_length)
		{
			return;
		}
		arr[numOfData] = data;
		numOfData ++;
	}
	
	public T list_First() // 커서를 0인덱스로 초기화 하고 첫 번째 데이터 리턴 
	{
		if(numOfData == 0)
		{
			return null;
		}
		
		cursor =0;
		return (T) arr[cursor];
	}
	
	public T list_Next() // 커서를 한칸 다음으로 이동 시키고 해당 위치의 데이터 리턴 
	{
		if(cursor >= numOfData-1)
		{
			return null;
		}
		
		cursor ++;
		return (T) arr[cursor];
	}
	
	public T list_Remove()
	{
		int cursortemp = cursor;
		int num = numOfData;
		
		T temp = (T) arr[cursor];
		
		for(int i=cursortemp;i<num-1;i++)
		{
			arr[i] = arr[i+1];
		}
		numOfData --;
		cursor--;
		
		return temp;
	}
}