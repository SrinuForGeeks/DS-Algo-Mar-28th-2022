public class AddTwoNumbersEx {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        
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
        
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersEx s = new AddTwoNumbersEx();
        LinkedList l = new LinkedList();

        ListNode head1 = l.construct(new int[]{9,9});
        ListNode head2 = l.construct(new int[]{1});

        System.out.print(" List1 ---> ");
        l.print(head1);
        System.out.print(" List2 ---> ");
        l.print(head2);
        ListNode current = s.addTwoNumbers(head1,head2);
        System.out.print(" After Add ---> ");
        l.print(current);
    }
}