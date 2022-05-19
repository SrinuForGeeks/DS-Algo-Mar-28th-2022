class ListNode
{
	int val;
	ListNode next;


	public ListNode(int value)
	{
		val = value;
		next = null;
	}
}

public class LinkedList
{
	ListNode head ;
	ListNode tail;
	int size;

	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}

   public ListNode construct(int[] arr)
   {
   		if(arr.length == 0)
   		{
   			return head;
   		}

   		ListNode current = new ListNode(arr[0]);
   		head = current;
   		tail = current;

   		for(int i = 1 ; i < arr.length; i++)
   		{
   			current = new ListNode(arr[i]);
   			tail.next = current;
   			tail = current;
   		}

   		size = size+arr.length;

   		return head;
   }

   public ListNode get(int index)
	{
		if(index >= size)
		{
			return null;
		}

		int counter = 0;
		ListNode current = head;

		while(counter < index)
		{
			current = current.next;
			counter++;
		}
		return current;
	}


   public void print(ListNode head)
   {
   	 ListNode current = head;
   	 System.out.print("[ ");
   	 while(current !=  null)
   	 {
   	 	System.out.print(current.val+" --> ");
   	 	current = current.next;
   	 }
   	 System.out.print(" null ]\n");

   }
}