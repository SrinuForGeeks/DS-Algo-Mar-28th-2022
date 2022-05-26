public class BrowserHistory {
    
    ListNode current ;

    public BrowserHistory(String homepage) {
        
        current = new ListNode(homepage);
        
    }
    /*
    Time Complexity : O(1)
    */
    public void visit(String url) {
        
        ListNode newPage = new ListNode(url);
        
        newPage.prev = current;
        current.next = newPage;
        
        current = newPage;
    }
    
      /*
        Time Complexity : O(n)
    */
    public String back(int steps) {
        
        while(current.prev != null && steps > 0)
        {
            current = current.prev;
            steps--;
        }
        
        return current.url;
        
    }
    
     /*
        Time Complexity : O(n)
    */
    public String forward(int steps) {
        
         while(current.next != null && steps > 0)
        {
            current = current.next;
            steps--;
        }
        
        return current.url;
        
    }

    public static void main(String[] args) {
        BrowserHistory s = new BrowserHistory("safary.com[homepage]");
       
        s.visit("google.com");

        s.visit("fb.com");

        System.out.println("back(1) --> "+s.back(1));
        
        System.out.println("back(1) --> "+s.back(1));

        System.out.println("back(3) --> "+s.back(1));

        System.out.println("forward(2) --> "+s.forward(2));

        System.out.println("forward(3) --> "+s.forward(3));

    }
}

class ListNode
{
    ListNode prev;
    ListNode next;
    String url;
    
    public ListNode(String url)
    {
        this.url = url;
        prev = null;
        next = null;
    }
}


