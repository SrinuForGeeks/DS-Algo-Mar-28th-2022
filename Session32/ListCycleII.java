public class ListCycleII
{

 /*
        Time Complexity  : O(n)
        Space Complexity : O(1)
    */
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        boolean isLoopPresent = false;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                isLoopPresent = true;
                break;
            }
        }
        
        if(isLoopPresent == false)
        {
            return null;
        }
        
        slow = head;
        
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

    public static void main(String[] args) {
    	
    	LinkedList list = new LinkedList();
    	int[] arr = {1,2,3,4,5};
    	ListNode head = list.construct(arr);
       
        ListCycleII obj = new ListCycleII();

        System.out.println(" Without cycle --> IntercetionPoint Node: "+obj.detectCycle(head));

         list.tail.next = list.get(2); // Making tail.next = Node(3); i.e --> index:2
        System.out.println(" With cycle --> IntercetionPoint Node: "+obj.detectCycle(head).val);

    }

}