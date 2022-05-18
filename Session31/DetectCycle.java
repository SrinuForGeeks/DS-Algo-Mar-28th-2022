public class DetectCycle
{
	  public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null )
        {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next; // slow pointer takes one move
            fast = fast.next.next; // fast pointer takes two moves
            if(slow == fast)
            {
                return true;
            }
        } 
        
        return false;
        
    }
        
    

    public static void main(String[] args) {
    	
    	LinkedList list = new LinkedList();
    	int[] arr = {1,2,3,4,5};
    	ListNode head = list.construct(arr);
       
        DetectCycle obj = new DetectCycle();

        System.out.println(" Without cycle --> Has Cycle : "+obj.hasCycle(head));

         list.tail.next = list.get(2); // Making tail.next = Node(3); i.e --> index:2
        System.out.println(" With cycle --> Has Cycle : "+obj.hasCycle(head));

    }
}