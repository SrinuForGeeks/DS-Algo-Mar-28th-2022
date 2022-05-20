public class AddTwoNumbersIIEx {
   
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode list1 = reverse(l1);
            ListNode list2 = reverse(l2);


         ListNode dummy = new ListNode(-1);
        ListNode dummyCurrent = dummy;
        int carry = 0;
        int currentSum;
        
        while(list1 != null || list2 != null)
        {
            if(list1 == null)
            {
                currentSum = list2.val+carry;
                dummyCurrent.next = new ListNode(currentSum%10);
                carry = currentSum/10;
                list2 = list2.next;
                
            }else if(list2 == null)
            {
                currentSum = list1.val+carry;
                dummyCurrent.next = new ListNode(currentSum%10);
                carry = currentSum/10;
                list1 = list1.next;
            }else
            {
                currentSum = list1.val + list2.val+carry;
                 dummyCurrent.next = new ListNode(currentSum%10);
                 carry = currentSum/10;
                list1 = list1.next;
                list2 = list2.next;
            }
            dummyCurrent = dummyCurrent.next;
            
        }
        
        if( carry != 0)
        {
            dummyCurrent.next = new ListNode(carry);
        }
        
        return reverse(dummy.next);
        
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head;
        ListNode tempNext ;
        
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
        AddTwoNumbersIIEx s = new AddTwoNumbersIIEx();
        LinkedList l = new LinkedList();

        ListNode head1 = l.construct(new int[]{7,2,4,3});
        ListNode head2 = l.construct(new int[]{5,6,4});

        System.out.print(" List1 ---> ");
        l.print(head1);
        System.out.print(" List2 ---> ");
        l.print(head2);
        ListNode current = s.addTwoNumbers(head1,head2);
        System.out.print(" After Add ---> ");
        l.print(current);
    }
}