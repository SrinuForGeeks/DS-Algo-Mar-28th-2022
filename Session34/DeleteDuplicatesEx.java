public class DeleteDuplicatesEx {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode current = head;
        
        while(current != null && current.next != null)
        {
            if(current.val == current.next.val)
            {
                current.next = current.next.next;
            }else
            {
                current = current.next;
            }
        }
        
        return head;
        
    }

    public static void main(String[] args) {
        
        DeleteDuplicatesEx s = new DeleteDuplicatesEx();
        LinkedList l = new LinkedList();

        ListNode head = l.construct(new int[]{1,1,2,3,3});

        System.out.print(" \n Before deleteDuplicates ---> ");
        l.print(head);

        ListNode swapHead = s.deleteDuplicates(head);
        System.out.print(" \n After deleteDuplicates ---> ");
        l.print(swapHead);
    }
}