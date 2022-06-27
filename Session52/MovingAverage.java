import java.util.Queue;
import java.util.LinkedList;

public class MovingAverage {
    
    Queue<Integer> queue = null;
    int capacity = 0;
    double sum = 0.0;
    
    
    public MovingAverage(int size) {
         queue = new LinkedList<>();
         this.capacity = size;
        
    }
    
    /*
    [1] sum:1 
    [1,2] sum:3 
    [1,2,3] sum:6 
    [1,2,3,4] sum:10 Capacity overloaded so remvoe the first element 
    queue.poll() -> 1
    [2,3,4] sum = sum-1 =10-1 = 9
    Time Complexity : O(1)
    */
    public double next(int val) {
        
         queue.add(val);    
         sum = sum + val;
        
        if(queue.size() > capacity)
        {
           int front = queue.poll();
           sum = sum-front;
        }
        
        return sum/queue.size();
    }
    public static void main(String[] args) {
         MovingAverage s = new MovingAverage(3);
         
         System.out.println(s.next(1));
          
         System.out.println(s.next(2));

         System.out.println(s.next(3));

         System.out.println(s.next(4));

         System.out.println(s.next(5));


    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */