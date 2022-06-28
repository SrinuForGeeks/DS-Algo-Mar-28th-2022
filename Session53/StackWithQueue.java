import java.util.Queue;
import java.util.LinkedList;

public class StackWithQueue {

    Queue<Integer> queue = new LinkedList<>();
    public StackWithQueue() {
        
    }
    
    public void push(int x) {
        queue.add(x);
        
    }
    
    public int pop() {
        
        int size = queue.size();
        int counter = 1;
        while(counter < size)
        {
           queue.add(queue.poll());
            counter++;
        }
        return queue.poll();
    }
    
    public int top() {
        
        int size = queue.size();
        int counter = 1;
        int lastElement = -1;
        while(counter <= size)
        {
          lastElement = queue.poll();
           queue.add(lastElement);
            counter++;
        }
        return lastElement;        
    }
    
    public boolean empty() {
        
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();

        stack.push(10);
        
        stack.push(20);

        stack.push(30);

        System.out.println(" \n After Add 10 -> 20 -> 30");
        System.out.println(" top() -> "+stack.top());
        System.out.println(" pop() -> "+stack.pop());
        System.out.println(" After pop top() -> "+stack.top());
     
    }
}

