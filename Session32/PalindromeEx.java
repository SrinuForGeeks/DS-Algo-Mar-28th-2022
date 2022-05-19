
import java.util.ArrayList;


class PalindromeEx {

    /*
    Time Complexity : O(n)
    Space Complexity: O(n)
    */
 public boolean isPalindrome1(ListNode head) {
        
        if(head.next == null )
        {
            return true;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        ListNode current = head;
        while(current != null)
        {
            list.add(current.val);
            current = current.next;
        }
        
        int startIndex = 0;
        int endIndex = list.size()-1;
        
        while(startIndex <= endIndex)
        {
            if(list.get(startIndex) != list.get(endIndex))
            {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        
        return true;
        
        
    }

    /*
    Time Complexity : O(n)
    Space Complexity: O(1)
    */
    public boolean isPalindrome2(ListNode head) {
        
        if(head.next == null)
        {
            return true;
        }
        
        // Find the midPoint
        ListNode midPoint = findMidPoint(head);
        
        // Revere midPoint.next
        ListNode midNextRevHead = reverse(midPoint.next);
        
        ListNode firstHalfCurrent = head;
        ListNode secondHalfCurrent = midNextRevHead;
        
        
        while(secondHalfCurrent != null)
        {
            if(firstHalfCurrent.val != secondHalfCurrent.val)
            {
                return false;
            }
            
            firstHalfCurrent = firstHalfCurrent.next;
            secondHalfCurrent = secondHalfCurrent.next;
            
        }
        
        
        // As we revered sendHalf, 
        midPoint.next = reverse(midNextRevHead);
        
        
        return true;
        
        
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head;
        ListNode tempNext ;
        
        while(current != null)
        {
            tempNext = current.next;
            current.next  = prev;
            prev = current;
            current = tempNext;
        }
        
        return prev;
        
    }
    
    
    private ListNode findMidPoint(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr1 = {1,2,3,2,1};
        ListNode head = list.construct(arr1);

        PalindromeEx p = new PalindromeEx();
        System.out.println(" \n LinkedList :: ");
        list.print(head);

System.out.println
("  Solution 1 : Time: O(n) Space:O(n) "+p.isPalindrome1(head));

System.out.println
("  Solution 2 : Time: O(n) Space:O(1) "+p.isPalindrome2(head));


        int[] arr2 = {1,2,3,4,2,1};

        System.out.println(" \n LinkedList :: ");
        head = list.construct(arr2);
        list.print(head);

System.out.println
("  Solution 1 : Time: O(n) Space:O(n) "+p.isPalindrome1(head));

System.out.println
("  Solution 2 : Time: O(n) Space:O(1) "+p.isPalindrome2(head));

 
   }
        
}