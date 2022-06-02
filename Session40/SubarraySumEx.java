import java.util.Map;
import java.util.HashMap;

public class SubarraySumEx {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        int sum = 0;
        int counter = 0;
        
        for(int index = 0 ; index < nums.length ; index++)
        {
            sum = sum + nums[index];
            
            if(prefixSumMap.containsKey(sum-k))
            {
                counter = counter + prefixSumMap.get(sum-k);
            }
             
            prefixSumMap.put(sum , prefixSumMap.getOrDefault(sum,0)+1);
        }
        
        return counter;
    }
    public static void main(String[] args) {
        SubarraySumEx s = new SubarraySumEx();
        int[] arr = {1,1,-1,1,1};
        int k = 2;

        System.out.println(" {1,1,-1,1,1} k=2 Count = "+s.subarraySum(arr,k));
    }
    
    
}