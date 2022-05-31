public class HashTable { // 이중 해시를 사용한 간단한 해시 테이블 예시 
	 // 오픈 어드레싱 방법으로는 
	// linear probing 선형 조사법 / 이차 조사법 quadratic probing / double hash 이중 해시 가 있다 . 
	// 데이터가 적을 때 효율적, 
	
	private int[] table;
	private int sizeOfTable = 100;
	private int secondHashFunPrimeNum= 53; 
	private int basicInt = -1;
	
	public HashTable()
	{
		table = new int[sizeOfTable];
		initTable();
	}
	
	public void insert(int in)
	{
		int temp = hashFun(in);
		
		if(table[temp] == basicInt)
		{
			table[temp] = in;
		}
		else
		{
			temp = hashFun2(in);
			if(table[temp] == basicInt)
			{
				table[temp] = in;
				
			}
			else
			{
				System.out.println("Collision!");
			}
		}
	}
	
	public int find(int in)
	{
		int temp = hashFun(in);
		if(table[temp] == in)
		{
			return temp;
		}
		else
		{
			temp = hashFun2(in);
			if(table[temp] == in)
			{
				return temp;
			}
		}
		
		System.out.println("데이터 없음");
		return -1;
	}
	
	public int hashFun(int in) // 1차 해쉬 함수 - 배열의 길이로 나눈 나머지를 반환 
	{
		return in%sizeOfTable;
	}
	
	public int hashFun2(int in) // 2차 해쉬 함수 - 배열의 길이보다 작은 소수로 결정 - 소수로 결정하는 이유는 클러스터가 비교적 적게 발생하기 때문이다 
	{
		return 1+(in%secondHashFunPrimeNum);
	}
	
	
	public void showTable()
	{
		for(int i=0;i<sizeOfTable;i++)
		{
			System.out.print(" " + table[i]);
		}
	}
	
	public void initTable()
	{
		for(int i=0;i<sizeOfTable;i++)
		{
			table[i] = basicInt;
		}
	}
	
	
	
}

/*HashTable ht = new HashTable();
		
		ht.insert(3);
		ht.insert(17);
		ht.insert(103);
		ht.insert(103);
		ht.showTable();*/
