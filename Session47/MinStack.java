import java.util.Stack;

public class MinStack {

    Stack<Integer>  elementsStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        int minValue = val;
        if(!minStack.isEmpty()  && val > minStack.peek())
        {
            minValue = minStack.peek();
        }
        
        elementsStack.push(val);
        minStack.push(minValue);
        
    }
    
    public void pop() {
        
        elementsStack.pop();
        minStack.pop();
        
    }
    
    public int top() {
        
        return elementsStack.peek();
    }
    
    public int getMin() {
        
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(7);
        stack.push(6);
        stack.push(2);
        stack.push(3);
        System.out.println(" \nelementsStack = "+stack.elementsStack);
        System.out.println(" minStack = "+stack.minStack);
        System.out.println(" Min = "+stack.getMin());

                stack.push(1);
        System.out.println(" \nafter push(1) getMin = "+stack.getMin());

        System.out.println(" elementsStack = "+stack.elementsStack);
        System.out.println(" minStack = "+stack.minStack);

        stack.pop();
        System.out.println(" \nafter 1st pop() getMin = "+stack.getMin());

         stack.pop();
        System.out.println(" \nafter 2nd pop() getMin = "+stack.getMin());

         stack.pop();
        System.out.println(" \nafter 3rd pop() getMin = "+stack.getMin());
         System.out.println(" elementsStack = "+stack.elementsStack);
        System.out.println(" minStack = "+stack.minStack);



    }
}
