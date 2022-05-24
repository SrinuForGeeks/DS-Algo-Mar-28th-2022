public class SwapPairsEx {
    public ListNode swapPairs(ListNode head) {
        
        
        ListNode dummy  = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(head != null && head.next != null)
        {
            ListNode first = head;
            ListNode second = head.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
            head = first.next;
        }
        
        return dummy.next;
        
    
    }
    public static void main(String[] args) {
        
        SwapPairsEx s = new SwapPairsEx();
        LinkedList l = new LinkedList();

        ListNode head = l.construct(new int[]{1,2,3,4});

        System.out.print(" \n Before Swap ---> ");
        l.print(head);

        ListNode swapHead = s.swapPairs(head);
        System.out.print(" \n After Swap ---> ");
        l.print(swapHead);
    }
}