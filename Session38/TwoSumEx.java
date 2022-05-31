import java.util.Map;
import java.util.HashMap;

public class TwoSumEx {
    public int[] twoSum(int[] nums, int target) {
        
        int[] arr = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int index = 0 ; index < nums.length ; index++)
        {
            int current = nums[index];
            int prev = target-current;
            
            if(map.containsKey(prev))
            {
                arr[0] = map.get(prev);
                arr[1] = index;
                break;
            }else
            {
                map.put(current, index);
            }
        }
        
        return arr;
    }

    public static void main(String[] args) {
        TwoSumEx s = new TwoSumEx();
        int[] nums = {2,7,11,5};
        int targetSum = 9;

        int[] arr = s.twoSum(nums,targetSum);
        System.out.println("index's = { "+arr[0]+","+arr[1]+"}");
    }
}