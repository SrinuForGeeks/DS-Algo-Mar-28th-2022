public class TwoSumIIEx {
    public int[] twoSum(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;
        
        int[] arr = new int[2];
        int currentSum;
        
        while(left < right)
        {
             currentSum = nums[left] + nums[right];
            
            if(currentSum == target)
            {
                arr[0] = left+1;
                arr[1] = right+1;
                break;
            }else if(currentSum < target)
            {
                left++;
            }else
            {
                right--;
            }
        }
        
        return arr;
        
    }

    public static void main(String[] args) {
        TwoSumIIEx s = new TwoSumIIEx();
        int[] arr = {2,7,11,15};
        int targetSum = 18;

        int[] result = s.twoSum(arr, targetSum);

        System.out.println("{2,7,11,15} target:18 :: [output will have index+1] = ["+result[0]+
            ","+result[1]+"]");
    }
}