import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {
    /*
    Time  Complexity : O(n)
    Space Complexity : O(n)
    */
    public int[] solution(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int index = nums2.length-1 ; index >= 0; index--)
        {
           
        while(!stack.isEmpty())
                  {
                        if(stack.peek() > nums2[index])
                        {
                            map.put(nums2[index],stack.peek());
                            break;
                        }else
                        {
                            stack.pop();
                        }
                    }

           if( stack.isEmpty() )
            {
                map.put(nums2[index], -1);
            }
            
            
            stack.push(nums2[index]);


        }
        
        int[] arr = new int[nums1.length];
         for(int index = 0 ; index < nums1.length ; index++)
         {
             arr[index] = map.get(nums1[index]);
         }
        
        return arr;
    }
    public static void main(String[] args) {
        NextGreaterElement s = new NextGreaterElement();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = s.solution(nums1,nums2);

        System.out.println(" Output : "+Arrays.toString(result));
    }
}