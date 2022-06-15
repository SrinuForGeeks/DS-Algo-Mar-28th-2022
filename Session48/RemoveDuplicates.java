
import java.util.Stack;

public class RemoveDuplicates {
    /*
    Time  Complexity : O(n)
    Space Complexity : O(n) ~ Avg O(1)
    */
     public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        
        for(int index = 0 ; index < s.length() ; index++)
        {
            if(stack.isEmpty() || stack.peek() != s.charAt(index))
            {
                stack.push(s.charAt(index));
            }else
            {
                stack.pop();
            }
        }
        while(!stack.isEmpty())
        {
           result = stack.pop() + result;  
        }
        
        return result;
    }
    public static void main(String[] args) {
        RemoveDuplicates s = new RemoveDuplicates();
       
        String result = s.solution("abbaca");

        System.out.println("Input : abbaca --> Output : "+result);
    }
}