class SubSetSum {
    /*
        Time Complexity : O(n*c)
        Space Complexity: O(n*c)
    */
    public boolean canPartitionSolution1(int[] nums) {
        
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
    
        Boolean[][] dp = new Boolean[n+1][subSetSum+1];
        
    // Solve Base SubProblem :: for empty arry {}
        
        dp[0][0] = true;
        for(int c = 1 ; c <= subSetSum; c++)
        {
            dp[0][c] = false;
        }
        
    // Solve all the subproblems from bottom up
        
        for(int index = 1; index <= n ; index++)
        {
            int curr = nums[index-1];
            for(int c = 0 ; c <= subSetSum ; c++)
            {
                    if(curr <= c)
                    {
                        dp[index][c] = dp[index-1][c-curr] || dp[index-1][c];
                    }else
                    {
                        dp[index][c] =  dp[index-1][c];
                    }
            }
            
        }
        
        return dp[n][subSetSum];
     
             }

    /*
        Time Complexity : O(n*c)
        Space Complexity: O(c)
    */

public boolean canPartitionSolution2(int[] nums) {
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
    
        Boolean[] dp = new Boolean[subSetSum+1];
        // Solve For Base SubProblem which is {} empty Array:
        
        dp[0] = true;
        for(int c = 1 ; c <= subSetSum ; c++)
        {
            dp[c] = false;
        }
        
        for(int index = 1 ; index <= n ; index++)
        {
            int curr = nums[index-1];
            for(int c = subSetSum ; curr <= c ; c--  )
                {
                    dp[c] = dp[c-curr] || dp[c];
                }
        }
        
        return dp[subSetSum];
        
    }
}

public class SubSetSumTabulation
{
    public static void main(String args[])
    {
        int[] nums = {1,5,11,5};
        SubSetSum s = new SubSetSum();
        System.out.println("  {1,5,11,5} Solution 1 --> "+s.canPartitionSolution1(nums));
        System.out.println("  {1,5,11,5} Solution 2 --> "+s.canPartitionSolution2(nums));

    }
}