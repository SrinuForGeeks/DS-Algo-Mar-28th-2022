import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
public class MinRemoveToMakeValid {
    /*
     Time Complexity : O(n)
     Space Complexity: O(n)
    */
    public String solution(String s) {
        
        Set<Integer> invalidSet = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        
        // Loaing invalid ')' indexes to the Set.
        for(int index = 0 ; index < s.length() ; index++)
        {
            char ch = s.charAt(index);
            
            if(ch == '(')
            {
                stack.push(index);
            }else if(ch == ')')
            {
                if(stack.isEmpty())
                {
                    invalidSet.add(index);
                }else
                {
                  stack.pop();  
                }
            }
        }
        
        // Loaing invalid '(' indexes to the Set. 
       while(!stack.isEmpty())
        {
            invalidSet.add(stack.pop());
        }
        
        // Framing a String with valid Parentheses
        
        StringBuilder sb = new StringBuilder();
        for(int index = 0 ; index < s.length() ; index++)
        {
            if(!invalidSet.contains(index))
            {
                sb.append(s.charAt(index));
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        MinRemoveToMakeValid s = new MinRemoveToMakeValid();
        String result = s.solution("lee(t(c)o)de)");
        System.out.println(" lee(t(c)o)de) -->  "+result);
    }
    
}