import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class MaxSlidingWindow {
    public int[] solution(int[] nums, int k) {
        
        Deque<Integer> deque = new LinkedList<>(); // deque has index numbers


        int n = nums.length;
        int[] result = new int[n-k+1];
        int resultIndex = 0;
        
        
        // Solve it for first window
        for(int index = 0 ; index < k ; index++)
        {
            while(!deque.isEmpty() && nums[index] >= nums[deque.getLast()] )
            {
                deque.removeLast();
            }
            
            deque.add(index);
        }
        
        result[resultIndex] = nums[deque.getFirst()];
        resultIndex++;
        
        for(int right = k ; right < n ; right++)
        {
            if( right - deque.getFirst() == k) 
                //  Verify is the firstElement is within the windo bound.
            {
                deque.removeFirst();
            }
            
            //  Remove if the current >= top of deque.
             while(!deque.isEmpty() && nums[right] >= nums[deque.getLast()] )
            {
                deque.removeLast();
            }
            
            deque.add(right);
            
            result[resultIndex] = nums[deque.getFirst()];
            resultIndex++;
        }
        
        return result;
        
    }

    public static void main(String[] args) {
        MaxSlidingWindow s = new MaxSlidingWindow();
        int[] result = s.solution(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(" input : {1,3,-1,-3,5,3,6,7}, k=3  --> Output :"+Arrays.toString(result));
    }
}