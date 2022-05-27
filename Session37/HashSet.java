import java.util.LinkedList;

public class HashSet
{
	private LinkedList<Integer>[] set = null;
	private int MAX_LEN = 5;
	private int size ;

	public HashSet()
	{
		set =  new LinkedList[MAX_LEN];
		size = 0;
	}

	public int hash(int key)
	{
		return key % MAX_LEN;
	}

	public void add(int element)
	{
		int bucket = hash(element);

		if(set[bucket] == null)
		{
			set[bucket] = new LinkedList<>();
		}

		LinkedList<Integer> list = set[bucket];

		if(list.contains(element) == false )
		{	
			list.add(element);
			size++;
		}

	}

	public void remove(int element)
	{
		int bucket = hash(element);

		LinkedList<Integer> list = set[bucket];

		if(list != null)
		{
			int index = list.indexOf(element);
			if(index != -1)
			{
				list.remove(index);
				size--;
			}
			/*
			for(int i = 0 ; i < list.size() ; i++)
			{
				if(list.get(i) == element)
				{
					list.remove(i);
					size--;
					return;
				}
			}
			*/
		}
		
	}

	public boolean search(int element)
	{
		int bucket = hash(element);

		LinkedList<Integer> list = set[bucket];

		return list != null && list.contains(element);
	}

	public int getSize()
	{
		return size;
	}

	public void print()
	{
		for(int i = 0 ; i < set.length; i++ )
		{

			LinkedList<Integer> list  = set[i];
			System.out.print("Bucket["+i+"] = ");
			if(list != null)
			{
				for(int j = 0 ; j < list.size() ; j++)
				{
					System.out.print(list.get(j)+" --> ");
				}
			}

			System.out.print(" null \n");
		}
	}

	public static void main(String[] args) {
		
		HashSet set = new HashSet();

		set.add(11); 
		
		set.add(2); 

		set.add(16); 

		set.add(20); 

		System.out.println("\n After adding 11,2,16,20");
		set.print(); 
		System.out.println(" Search(16) --> "+set.search(16)); // true

		/*
		Bucket[0] = 20 -> null
		Bucket[1] = 11 -> 16 -> null
		Bucket[2] = 2 -> null
		Bucket[3] = null
		Bucket[4] = null
		*/

		set.remove(16);
		System.out.println("\n After remove 16");
		set.print();
		System.out.println(" Search(16) --> "+set.search(16)); // false

		/*
		Bucket[0] = 20 -> null
		Bucket[1] = 11  -> null
		Bucket[2] = 2 -> null
		Bucket[3] = null
		Bucket[4] = null
		*/

		System.out.println("\n After Adding  2");
		set.add(2);
		set.print();
		/*
		Bucket[0] = 20 -> null
		Bucket[1] = 11  -> null
		Bucket[2] = 2 -> null
		Bucket[3] = null
		Bucket[4] = null
		*/


		set.add(23);
		set.add(24);

		set.add(3);
		set.add(1);
		set.add(0);
		set.add(144);
		System.out.println("\n After adding couple of elements");
		set.print();

		/*
		Bucket[0] = 20 -> 0 -> null
		Bucket[1] = 11 -> 1 -> null
		Bucket[2] = 2 -> null
		Bucket[3] = 23 -> 3 -> null
		Bucket[4] = 24 -> 144 -> null
		*/

	}

}
