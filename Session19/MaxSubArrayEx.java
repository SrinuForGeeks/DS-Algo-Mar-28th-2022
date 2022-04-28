class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int globalMax = nums[0];
        int n = nums.length;
        
        for(int index = 1 ; index < n ; index++)
        {
            localMax = Math.max(nums[index], localMax+nums[index]);
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
}

public class MaxSubArrayEx
{
    public static void main(String[] args) {
        MaxSubArray s = new MaxSubArray();
         int[] nums1 = {-5,3,-1,7};
         int[] nums2 = {5,4,-1,7,8};

           System.out.println(" {2,3,1,1,4} MaxSubArraySum = -->"+s.maxSubArray(nums1));
        System.out.println(" {3,2,1,1,4,7} MaxSubArraySum = -->"+s.maxSubArray(nums2));

    }
}