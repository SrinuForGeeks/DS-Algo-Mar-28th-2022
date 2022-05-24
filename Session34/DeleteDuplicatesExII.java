public class DeleteDuplicatesExII {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pred = dummy;
        
        while(head != null && head.next != null)
        {
            if(head.val == head.next.val) // current node is duplicate
            {
                while(head != null && head.next != null && head.val == head.next.val)
                {
                    head = head.next;
                }
                
                pred.next = head.next;
                
            }else // current node is not duplicate
            {
                pred = pred.next; 
            }
            
            head= head.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        
        DeleteDuplicatesExII s = new DeleteDuplicatesExII();
        LinkedList l = new LinkedList();

        ListNode head = l.construct(new int[]{1,1,1,2,3});

        System.out.print(" \n Before deleteDuplicate nodes ---> ");
        l.print(head);

         head = s.deleteDuplicates(head);
        System.out.print(" \n After deleteDuplicate nodes  ---> ");
        l.print(head);
    }
}