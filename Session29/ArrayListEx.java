class ArrayList
{
	private int capacity = 5;
	private int[] arr = null;
	private int size = 0;

	public ArrayList()
	{
	  arr = new int[capacity];
	}

	/* index nums starts from  0  to n-1 
	   arr.length can act as a nth index can be used for new element
	 */
	public void add(int element)
	{
		if(size >= capacity/2) // reached 50% of capacity
		{
			copy();
		}
		arr[size] = element;
		size++;
	}

	public void add(int index, int element)
	{
		if(index == size)
		{
			add(element);
			return;
		}

		if(size >= capacity/2) // reached 50% of capacity
		{
			copy();
		}

	
		/* 
		{10[0],20[1],30[2]} --> add(1,15)
		 	current = 20;
		 	temp = 15;
		 	arr[1] = temp ; 15
		 	temp = current; //20

		{10[0],15[1],30[2]}
			current = 30;
		 	temp = 20;
		 	arr[2] = temp ;// 20

		 	temp = current;
********************** {10,15,20}
		 	current = 30;
		 	temp = 30
		 		arr[size] = temp ;
		 			{10,15,20,30};
		 			size++

		*/
		 			int temp = element;
		for(int currentIndex = index ; currentIndex < size; currentIndex++ )
		{
				int current = arr[currentIndex];
				arr[currentIndex] = temp;
				temp = current;

		}

			arr[size] = temp;
			size++;

	}

	public int get(int index)
	{
		if(index >= size())
		{
			return -1;
		}

		return arr[index];
	}

	public void remove(int index)
	{

		if(index >= size)
		{
			return;
		}
			// {10,20[1],30,40} --> {10,30,40,40(X)}
		for(int current = index ; current+1 < size ; current++)
		{
			arr[current]= arr[current+1];
		}

		size--; // add(50) -> arr[size] -> {10,30,40,50}
	}

	public void setOrReplace(int index, int element)
	{
		if(index >= size)
		{
			return;
		}

		arr[index] = element;
	}


	public int size()
	{
		return size;
	}

	public void copy()
	{
		capacity = 2 * capacity;
		int[] newArr = new int[capacity];
		for(int i = 0 ; i < arr.length ; i++)
		{
			newArr[i] = arr[i];
		}

		arr = newArr;
	}

	public boolean search(int element)
	{
		for(int index = 0 ; index < size ; index++)
		{
				if(element == arr[index])
				{
					return true;
				}
		}

		return false;
	}

	public void print()
	{
					System.out.print("[ ");

		for(int index = 0 ; index < size ; index++)
		{

				System.out.print(arr[index]+"   ");

		}
				System.out.print("] \n");
	}
}

public class ArrayListEx
{
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(90);
		list.add(100);
		list.add(110);

		list.print(); // {10,20,30,40,50,60}
		System.out.println(" Searc(30) --> "+list.search(30)); // true

		list.remove(2) ; 
		System.out.println(" After removing element at index:2");

		list.print(); // {10,20,40,50,60};
		System.out.println(" Searc(30) --> "+list.search(30)); // False


		list.add(2,25);
		System.out.println(" After Adding  element(25) at index:2");
		list.print(); // {10,20,25,40,50,60};


		list.setOrReplace(3,30);
		System.out.println(" After Relplace 30   at index:3");
		list.print(); // {10,20,25,30,50,60};


	}
}
