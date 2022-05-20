public class MergeTwoSortedListEx {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
        
        if(list1 == null && list2 == null)
        {
            return null;
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode current  = dummyNode;
        
        while(list1 != null || list2 != null)
        {
            if(list1 == null )
            {
                current.next = list2;
                break;
            }
            
            if(list2 == null)
            {
                current.next = list1;
                break;
            }
            
            if(list1.val < list2.val)
            {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            }else
            {
                
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            
            current = current.next;
            
        }
        
        return dummyNode.next;
    }

    public static void main(String[] args) {
    	MergeTwoSortedListEx s = new MergeTwoSortedListEx();
    	LinkedList l = new LinkedList();

    	ListNode head1 = l.construct(new int[]{1,2,5});
    	ListNode head2 = l.construct(new int[]{3,7});

    	System.out.print(" List1 ---> ");
    	l.print(head1);
    	System.out.print(" List2 ---> ");
    	l.print(head2);
    	ListNode current = s.mergeTwoLists(head1,head2);
    	System.out.print(" After merge ---> ");
    	l.print(current);
    }
}