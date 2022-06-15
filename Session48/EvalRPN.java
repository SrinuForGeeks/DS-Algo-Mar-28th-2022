import java.util.Stack;
import java.util.Set;
import java.util.HashSet;


public class EvalRPN {
    /*
    Time  Complexity : O(n)
    Space Complexity : O(n)
    */
    public int solution(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        
        for(int index = 0 ; index < tokens.length ; index++)
        {
            String value = tokens[index]; 
            
            if(set.contains(value))
            {
                int b = stack.pop();
                int a = stack.pop();
                
                if(value.equals("+"))
                {
                    stack.push(a+b);
                }else if(value.equals("-"))
                {
                    stack.push(a-b);
                }
                else if(value.equals("*"))
                {
                    stack.push(a*b);
                }else
                {
                     stack.push(a/b);
                }
                
                
            }else
            {
               stack.push(Integer.parseInt(value)); 
            }
            
            
        }

return stack.pop();
        
    }
    public static void main(String[] args) {
        EvalRPN s = new EvalRPN();
      
        String[] tokens = {"2","1","+","3","*"};
        int result = s.solution(tokens);
        System.out.println(" Output : "+result);
    }
}