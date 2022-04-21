class MinCostClimbingStairs {
    /*
    Time Complexity : O(n)
    Space Complexity : O(n)
    */
    public int solution1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1]; // State : As we need to reach top of the floor it should be n+1
        
        // Base Subproblem DP results
        dp[0] = 0;
        dp[1] = 0; // We can reach either the 1st or 2nd step from bottom so the cost is Zero.
        
        for(int i = 2 ; i <= n ; i++)
        {
            int byStep1Cost = cost[i-1] + dp[i-1];
            int byStep2Cost = cost[i-2] + dp[i-2];

            dp[i] = Math.min(byStep1Cost, byStep2Cost);
        }
        
        return dp[n];
    }

    /*
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public int solution2(int[] cost) {
        int n = cost.length;
        int prev = 0; // Step1Cost
        int latest = 0; // Step1Cost
        int minCost;
        
        for(int i = 2 ; i <= n ; i++)
        {
            int byStep1Cost = cost[i-1] + latest; 
            int byStep2Cost = cost[i-2] + prev;

            minCost = Math.min(byStep1Cost, byStep2Cost);
            prev = latest;
            latest = minCost ; // Just swap to maintain latest two SubProblem's
            
        }
        
        return latest;
    }
}

public class MinCostClimbingStairsTabulation
{
    public static void main(String[] args) {
        MinCostClimbingStairs s = new MinCostClimbingStairs();
        int[] cost = {10,15,20};
        System.out.println(" {10,15,20} SolutionOne  = "+s.solution1(cost));
        System.out.println(" {10,15,20} SolutionTwo  = "+s.solution2(cost));

    }
}