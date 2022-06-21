import java.util.Stack;
import java.util.Arrays;
public class FindOceanView {
    public int[] solution(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        stack.push(n-1);
        for(int index = n-2 ; index >= 0 ; index--)
        {
            if(heights[index] > heights[stack.peek()] )
            {
                stack.push(index);
            }
        }
        
        int size = stack.size();
    
        int[] arr = new int[size];
        
        for(int index = 0 ; index < size ; index++)
        {
            arr[index] = stack.pop();
        }
        
        return arr;
    }

    public static void main(String[] args) {
        FindOceanView s = new FindOceanView();
        int[] input = {4,2,3,1};
        int[] result = s.solution(input);
        System.out.println(" {4,2,3,1} -OceanView--> "+Arrays.toString(result));
    }
}