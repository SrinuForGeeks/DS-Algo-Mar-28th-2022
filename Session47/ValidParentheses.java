import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int index = 0 ; index < s.length() ; index++)
        {
            char currentCh = s.charAt(index);
            
            if(currentCh == ')')
            {
                if(stack.isEmpty() || stack.pop() != '(')
                {
                    return false;
                }
            }else  if(currentCh == '}')
            {
                if(stack.isEmpty() || stack.pop() != '{')
                {
                    return false;
                }
            }else if(currentCh == ']')
            {
                if(stack.isEmpty() || stack.pop() != '[')
                {
                    return false;
                }
            }else
            {
                stack.push(currentCh);
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses s = new ValidParentheses();
        System.out.println(" ()[]{} --> "+s.isValid("()[]{}"));
        System.out.println(" ()][{} --> "+s.isValid("()][{}"));

    }
}