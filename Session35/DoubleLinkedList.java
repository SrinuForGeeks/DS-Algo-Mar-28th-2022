class Node
{
	Node next;
	Node prev;
	int val;

	public Node(int data)
	{
		val = data;
		next = null;
		prev = null;
	}

}

public class DoubleLinkedList
{
	int size;
	Node head;
	Node tail;
	public DoubleLinkedList()
	{
		size = 0;
		head = null;
		tail = null;
	}

	public void addHead(int val)
	{
		Node current = new Node(val);

		if(size == 0)
		{
			head = current;
			tail = current;
		}else
		{
			current.next = head;
			head.prev = current;
			head = current;
		}

		size++;
	}

	public void addTail(int val)
	{
		add(val);
	}

	public void add(int val)
	{
		Node current = new Node(val);

		if(size == 0)
		{
			head = current;
			tail = current;
		}else
		{
			tail.next = current;
			current.prev = tail;
			tail = current;
		}

		size++;
	}

	public void removeHead()
	{
		if(size == 1)
		{
			head = null;
			tail = null;
		}else
		{
			Node headNext = head.next;
			head.next = null;
			headNext.prev = null;
			head = headNext;
		}

		size--;
	}

	public void removeTail()
	{
		if(size == 1)
		{
			head = null;
			tail = null;
		}else
		{
			Node tailPrev = tail.prev;
			tailPrev.next = null;
			tail.prev = null;
			tail = tailPrev;
		}

		size--;
	}

	public void remove(int index)
	{

		if(index >= size)
		{
			return;
		}

	int counter = 0;
	Node current = head;
	while(counter < index)
	{
	current = current.next;
	counter++;
	}
	current.prev.next = current.next;
	current.next.prev = current.prev;

	current.prev = null;
	current.next = null;

	size--;
	}

	public void add(int index,int val)
	{

		if(index == size)
		{
			add(val);
			return;
		}

			
	int counter = 0;
	Node current = head;
	while(counter < index)
	{
	current = current.next;
	counter++;
	}
	Node newNode = new Node(val);
	newNode.next = current;
	newNode.prev = current.prev;

	current.prev.next = newNode;
	current.prev = newNode;

	size++;
	}


public Node get(int index)
	{

	if(index >= size)
		{
			return null;
		}

			
	int counter = 0;
	Node current = head;
	while(counter < index)
	{
	current = current.next;
	counter++;
	}
	return current;
	}

/*
	Time complexity : O(n)
*/
public boolean search(int val)
	{


	Node current = head;

	while(current != null)
	{
		if(current.val == val)
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

	while(current != null)
	{
		System.out.print(current.val+" --> ");
		current = current.next;
	}
	System.out.print("null\n");

	}

public void printReverse()
	{
	Node current = tail;

	while(current != null)
	{
		System.out.print(current.val+" --> ");
		current = current.prev;
	}
	System.out.print("null");

	}

public static void main(String[] args) {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.add(10);
		
		dll.add(20);

		dll.add(30);

		dll.add(40);

		System.out.println("\n After Adding 4 elemetns ");
		dll.print(); // 10->20->30->40

		System.out.println("\n Search(30) --> "+dll.search(30));
		dll.remove(2); // remove index:2 i.e element 30


		System.out.println("\n After remove index:2 i.e element 30");
		dll.print(); // 10->20->40
		System.out.println(" Search(30) --> "+dll.search(30));


		dll.add(2,25);

		System.out.println("\n After add element 25 @ index:2 i.e");
		dll.print(); // 10->20->25->40

		dll.addHead(5);
		dll.addTail(45);

		System.out.println("\n After addHead(5), addTail(45) ");
		dll.print(); // 5->10->20->25->40->45

		dll.removeHead();
		dll.removeTail();

		System.out.println("\n After remove Head & Tail");
		dll.print(); // 10->20->25->40

		System.out.println(" \n  PrintReverse --> ");
		dll.printReverse();

	}
}










