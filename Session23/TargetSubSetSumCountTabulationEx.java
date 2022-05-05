class TargetSubSetSumCount {
    public int find(int[] nums, int target) {
        
        int[][] dp = new int[nums.length][target+1];
        
        // Empty Subset will always represets target : 0
        for(int index =  0 ; index < nums.length ; index++)
        {
            dp[index][0] = 1;
        }

        // Solving base problem with element 1
        for(int c = 1; c <= target ; c++)
        {
            if(nums[0] == c)
            {
                dp[0][c] = 1;
            }else
            {
                 dp[0][c] = 0;
            }
        }

        // Solving subs problems From 1 to n-1 index.

        for(int index = 1 ; index < nums.length ; index++)
        {
            for(int c = 1 ; c <= target ; c++)
            {
                    if(nums[index] <= c)
                    {                 // includeCount + exludeCount
                        dp[index][c] = dp[index-1][c-nums[index]] + dp[index-1][c];
                    }else
                    {
                     dp[index][c] =   dp[index-1][c]; // ExcludeCount
                    }
            }
        }

        return dp[nums.length-1][target];
    }
 
   
}
public class TargetSubSetSumCountTabulationEx 
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


