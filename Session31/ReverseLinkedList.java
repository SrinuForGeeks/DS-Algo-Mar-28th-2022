public class ReverseLinkedList
{
	 public ListNode reverseList(ListNode head) {
        
        if(head == null)
        {
            return null;
        }
        
        ListNode prev = null;
        ListNode current = head;
        ListNode tempNext;
        
        while(current != null)
        {
            tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }
        
        return prev;
        
    }

    public static void main(String[] args) {
    	
    	LinkedList list = new LinkedList();
    	int[] arr = {1,2,3,4,5};
    	ListNode head = list.construct(arr);
    	System.out.println(" \n Before Reverse ");
    	list.print(head);

    	ReverseLinkedList obj = new ReverseLinkedList();
    	ListNode reverseHead = obj.reverseList(head);
    	
    	System.out.println(" \n After Reverse ");
    	   list.print(reverseHead);



    }
}