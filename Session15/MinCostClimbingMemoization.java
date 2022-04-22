class MinCostClimbingStairs {
    
    /*
    Time  Complexity : O(n)
    Space Complexity : O(n)
    */
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        
        int[] dp = new int[n+1];
        
        for(int i = 0 ; i <= n ; i++)
        {
            dp[i] = -1;
        }
        
        dp[0] = 0;
        dp[1] = 0;
        
        return memoization(cost,dp,n);
    }
    
    private int memoization(int[] cost, int[] dp, int stepIndex)
    {
        if( stepIndex <= 1 )
        {
            return 0;
        }
        
        if(dp[stepIndex] != -1)
        {
            return dp[stepIndex];
        }
        
        int costByClimb1 = memoization(cost, dp, stepIndex-1);
        int costByClimb2 = memoization(cost, dp, stepIndex-2);
        
        dp[stepIndex] = Math.min(costByClimb1+cost[stepIndex-1],costByClimb2+cost[stepIndex-2]);
        
        return dp[stepIndex];
    }
}

public class MinCostClimbingMemoization
{
    public static void main(String[] args) {
        MinCostClimbingStairs s = new MinCostClimbingStairs();
        int[] cost = {10,15,20};
        System.out.println(" {10,15,20} Memoization  = "+s.minCostClimbingStairs(cost));
    }
}