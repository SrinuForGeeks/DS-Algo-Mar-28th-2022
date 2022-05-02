class PartitionEqualSubsetSum {
    /*
    Time Complexity  : O(mn)
    Space Complexity : O(n)
    */
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++)
        {
            sum = sum+nums[i];
        }
        if(sum%2 == 1)
        {
            return false;
        }
        
        int subSetSum = sum/2;
    
        Boolean[][] dp = new Boolean[n][subSetSum+1];
        
        return canPartition(nums, 0, subSetSum, dp);
    
    			 }
    
public boolean canPartition(int[] nums, int index, 
	int capacity,Boolean[][] dp)
			 {

			 	if(capacity == 0) return true;

				 if(index == nums.length || capacity < 0) return false;


				 if(dp[index][capacity] != null)
				 {
				 	return dp[index][capacity];
				 }

            //dp[index][capacity] = include || exclude

dp[index][capacity] =	canPartition(nums, index+1, capacity-nums[index],dp) 
                            || 
                        canPartition(nums, index+1, capacity,dp);
		return dp[index][capacity];

			 }

}


public class PartitionEqualSubsetSumMemoization
{
    public static void main(String[] args) {
            int[] nums1 = {1,5,11,5};
            int[] nums2 = {3,3,5,3};

    PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
    System.out.println("{1,5,11,5}  = "+s.canPartition(nums1));
    System.out.println("{3,3,5,3}   = "+s.canPartition(nums2));
    
    }
}