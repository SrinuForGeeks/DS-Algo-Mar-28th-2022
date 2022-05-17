class Node
{
	int data;
	Node next;


	public Node(int value)
	{
		data = value;
		next = null;
	}
}

 class LinkedList
{
	Node head ;
	int size ;
	Node tail;

	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}

	public void addHead(int value)
	{
		Node current = new Node(value);

		if(size == 0)
		{
			head = current;
			tail = current;
		}else
		{
			current.next = head;
			head = current;
		}
		
		size++;
	}

	public void addTail(int value)
	{

		if(size == 0)
		{
			addHead(value);
			return;
		}
		
		Node current = new Node(value);
		tail.next = current;
		tail = current;
		size++;
	}

	public void add(int value)
	{
		addTail(value);
	}

	public void add(int index,int value)
	{
		if(index == 0)
		{
			addHead(value);
			return;
		}

		if(index == size-1)
		{
			addTail(value);
			return;
		}


		int counter = 0;
		Node prev = null;
		Node current = head;

		while(counter < index)
		{
			prev = current;
			current = current.next;
			counter++;
		}
		Node newNode = new Node(value);
		newNode.next = prev.next;
		prev.next = newNode;
		size++;
	}

	public void removeHead()
	{
		if(size == 0)
		{
			return;
		}

		head = head.next;
		size--;
	}

	public void removeTail()
	{
		if(size == 0)
		{
			return;
		}
		if(size == 1)
		{
			head = null;
			tail = null;
			size--;
			return;
		}

		Node prev = null;
		Node current = head;

		while(current.next != null)
		{
			prev = current;
			current = current.next;
		}

		prev.next = null;
		tail = prev;
		size--;


	}



	public void remove(int index)
	{
		if(index >= size)
		{
			return;
		}

		if(index == 0)
		{
			removeHead();
			return;
		}

		if(index == size-1)
		{
			removeTail();
			return;
		}

		int counter = 0;
		Node prev = null;
		Node current = head;

		while(counter < index)
		{
			prev = current;
			current = current.next;
			counter++;
		}
		prev.next = current.next;
		current.next = null; // Helps GC to remove currentIndex node
		size--;
	}

	public boolean search(int value)
	{
		Node current = head;
		while(current != null)
		{
			if(current.data == value)
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}
	public void print()
	{
		Node current = head;
		System.out.print("[ ");
		while(current != null)
		{
			System.out.print(current.data+"  ");
			current = current.next;
		}
		System.out.println("] \n");

	}

}

public class LinkedListEx
{
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.add(10);
		
		list.add(20);

		list.add(30);

		list.add(40);

System.out.println(" After adding 4 elements");
		list.print(); //[10,20,30,40]

		list.addHead(5);
System.out.println(" After adding Head:5 elements");
		list.print(); //[5,10,20,30,40]
System.out.println(" search(30) -- > "+list.search(30));



list.addTail(45);
System.out.println(" After adding Tail:45 elements");
list.print(); //[5,10,20,30,40,45]


list.removeHead();
list.removeTail();
System.out.println(" After removeHead & removeTail ");
list.print(); //[10,20,30,40]
System.out.println(" search(5) -- > "+list.search(5));


list.add(2,25);

System.out.println(" After add:25 , Index:2  ");
list.print(); //[10,20,25,30,40]

list.remove(3);

System.out.println(" After remove Index:3  ");
list.print(); //[10,20,25,40]

	}
}





