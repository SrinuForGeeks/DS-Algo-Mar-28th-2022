import java.util.LinkedList;

class Pair
{
	int key;
	int value;

	public Pair(int k , int v)
	{
		key = k;
		value =v;
	}
}
public class HashMap
{
	private LinkedList<Pair>[] map = null;
	private int MAX_LEN = 5;

	public HashMap()
	{
		map =  new LinkedList[MAX_LEN];
	}

	public int hash(int key)
	{
		return key % MAX_LEN;
	}

	public void put(int key, int value)
	{
		int bucket = hash(key);

		if(map[bucket] == null)
		{
			map[bucket] = new LinkedList<Pair>();
		}
		LinkedList<Pair> list = map[bucket];
		
		Pair p = get(key);
		if(p != null)
		{
			p.value = value;
		}else
		{
			p = new Pair(key,value);
			list.add(p);
		}
		
	}


	

	public void remove(int key)
	{
		int bucket = hash(key);
		LinkedList<Pair> list = map[bucket];

		if(list != null)
		{
			for(int i = 0 ; i < list.size(); i++)
			{
				Pair p = list.get(i);
				if(p.key == key)
				{
					list.remove(i);
					return;
				}
			}
		}
			
	}

	public boolean containsKey(int key)
	{
		return get(key) != null;
	}


	public Pair get(int key)
	{
		int bucket = hash(key);
		LinkedList<Pair> list = map[bucket];

		if(list != null)
		{
		for(int i = 0 ; i < list.size() ; i++)
			{
			Pair p = list.get(i);
			if(p.key == key)
			{
				return p;
			}

			}	
		}

		return null;
		
	}

	public void print()
	{
		for(int i = 0 ; i < map.length; i++ )
		{

			LinkedList<Pair> list  = map[i];
			System.out.print("Bucket["+i+"] = ");
			if(list != null)
			{
				for(int j = 0 ; j < list.size() ; j++)
				{
					Pair p = list.get(j);
					System.out.print("[K :"+p.key+" = V:"+p.value+"]-->");
				}
			}

			System.out.print(" null \n");
		}
	}

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(2,3);
		
		map.put(16,11);

		map.put(12,4);

		map.put(2,8);

		map.print();

		/*
		Bucket[0] =   null
		Bucket[1] = [k:16,v:11] -> null
		Bucket[2] = [k:2,v:8] -> [k:12,v:4] ->null
		Bucket[3] =  null
		Bucket[4] =  null
		*/

		System.out.println("containsKey(2) --> "+map.containsKey(2));

		map.remove(2);
		System.out.println("\n After removing key(2)");
		map.print();
		System.out.println("containsKey(2) --> "+map.containsKey(2));

		/*
Bucket[0] =  null 
Bucket[1] = [K :16 = V:11]--> null 
Bucket[2] = [K :12 = V:4]--> null 
Bucket[3] =  null 
Bucket[4] =  null 
		*/

	}

}
