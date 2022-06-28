import java.util.Stack;
public class QueueWithStack {

    Stack<Integer> enqueStack = new Stack<>();
    Stack<Integer> dequeStack = new Stack<>();


    public QueueWithStack() {
        
    }
    
    public void push(int x) {
        enqueStack.push(x);
    }
    
    public int pop() {
        
        if( dequeStack.isEmpty() )
        {
            while( !enqueStack.isEmpty() )
            {
                dequeStack.push(enqueStack.pop());
            }
        }
        
        return dequeStack.pop();
    }
    
    public int peek() {
        
         if( dequeStack.isEmpty() )
        {
            while( !enqueStack.isEmpty() )
            {
                dequeStack.push(enqueStack.pop());
            }
        }
        
        return dequeStack.peek();
        
    }
    
    public boolean empty() {
        
        return enqueStack.isEmpty() && dequeStack.isEmpty();
    }



    public static void main(String[] args) {
        QueueWithStack queue = new QueueWithStack();

        queue.push(10);
        
        queue.push(20);

        queue.push(30);

        System.out.println(" \n After Add 10 <- 20 <- 30");
        System.out.println(" peek() -> "+queue.peek());
        System.out.println(" pop() -> "+queue.pop());
        System.out.println(" After pop peek() -> "+queue.peek());
     
	}
}
