class TargetSubSetSumCount {
    public int find(int[] nums, int target) {
        
        int[][] dp = new int[nums.length][target+1];
        for(int index = 0; index < nums.length ; index++)
        {
            for(int c = 0; c <= target; c++)
            {
                dp[index][c] = -1;
            }
        }
       return count(nums, target, 0, 0,dp);
    }
 
    private int count(int[] nums, int target, int sum, int index , int[][] dp)
    {
        
        if( sum == target) 
        {
            return 1;
        }
        
        if(index == nums.length || sum > target)
        {
            return 0;
        }
        if(dp[index][sum] != -1)
        {
            return dp[index][sum];
        }
        
        dp[index][sum] = count(nums, target, sum+nums[index], index+1,dp)
                                        +
                                count(nums, target, sum, index+1,dp);

        return dp[index][sum];                        
    }
}
public class TargetSubSetSumCountMemoisationEx 
{
    public static void main(String[] args) {
        TargetSubSetSumCount s = new TargetSubSetSumCount();
        int[] nums1 = {1,2,1}; // {1,1} {2} = result : 2

        System.out.println("{1,2,1} target 2 ::  No.Of Ways = "
            +s.find(nums1, 2));

     int[] nums2 = {1,3,7,6,2,9}; // {1,6,2}  {3,6} {7,2} {9}  = 4
    System.out.println("{1,3,7,6,2,9} target 9 ::  No.Of Ways = "
            +s.find(nums2, 9));
    }
}


