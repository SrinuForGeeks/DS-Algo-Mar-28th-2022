import java.util.Stack;

class MinAddToMakeValid {


/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
 public int approch1(String s) {
       
        Stack<Character> openStack = new Stack<>();
        Stack<Character> closedStack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '(')
            {
               openStack.push(ch);
            }else 
            {
               if(!openStack.isEmpty() && openStack.peek() == '(')
               {
                   openStack.pop();
               }else
               {
                   closedStack.push(ch);
               }
            }
        }
        
        return openStack.size() + closedStack.size();
    }

/*
    Time Complexity : O(n)
    Space Complexity : O(1)
*/
    public int approch2(String s) {
       
      
        int openCount = 0;
        int closedCount = 0;

        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '(')
            {
               openCount++;
            }else 
            {
               if(openCount > 0)
               {
                   openCount--;
               }else
               {
                   closedCount++;
               }
            }
        }
        
        return  openCount + closedCount;
    }

    public static void main(String[] args) {
        MinAddToMakeValid s = new MinAddToMakeValid();
        System.out.println(" ()))(( -> Approch One --> "+s.approch1("()))(("));
        System.out.println(" ()))(( -> Approch Two --> "+s.approch2("()))(("));

    }
}