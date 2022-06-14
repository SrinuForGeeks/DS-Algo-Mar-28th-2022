
class Node
{
	int val;
	Node prev;
	Node next;

	public Node(int val)
	{
		this.val = val;
		prev = null;
		next = null;
	}
}

class Stack
{
	Node head;
	Node tail;
	int size;

	public Stack()
	{
		head = null;
		tail = null;
		size = 0;
	}

	/*
		Time Complexity : O(1)
	*/
	public void push(int element)
	{
		Node node = new Node(element);
		if(head == null)
		{
		head = tail = node;
		return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		size++;
	}

	/*
		Time Complexity : O(1)
	*/
	public int pop()
	{
		if(tail == null)
		{
			return -1; // -1 indicates Stack is Empty in our usecase
		}
		int val = tail.val;

		if(tail == head )
		{
			tail = head = null;
		}else if(tail.prev == head)
		{
		head.next = null;
		tail = head;
		}else
		{
		Node prev = tail.prev;
		prev.next = null;
		tail.prev = null; // Helping GC
		tail = prev;
		}
		size--;
		return val;

	}

	/*
		Time Complexity : O(1)
	*/
	public int top()
	{
		return tail == null ? -1 : tail.val;
	}

	/*
		Time Complexity : O(1)
	*/
	public int size()
	{
		return size;
	}

	public void print()
	{
		String s = "Stack[ ";
		Node current = head;
		while(current != null)
		{
			s = s + ","+current.val;
			current = current.next;
		}

		s = s+ "]";
		System.out.println(s);
	}

}

public class StackEx
{
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		System.out.println(" Top --> "+s.top()); // 20
		s.push(30);
		s.print();

		System.out.println(" Top --> "+s.top()); // 30
		
	    s.pop();
		System.out.println(" After 1st pop() ~  --> "+s.top());// 20

		s.pop();
		System.out.println(" After 2nd pop() ~  --> "+s.top()); // 10

		s.pop();
		System.out.println(" After 3rd pop() ~  --> "+s.top()); // -1

	}
}