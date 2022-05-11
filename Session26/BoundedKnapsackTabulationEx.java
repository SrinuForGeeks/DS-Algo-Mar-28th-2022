class BoundedKnapsack
{
	public int tabulation(int[] weights, int[] profits, int capacity)
	{
		int[][] dp = new int[weights.length][capacity+1];

		// Solve the Base SubProblem:  
		// If you have only one element, 
		// you can cosider the profit if the weight is <= capacity
		for(int c = 0 ; c <= capacity ; c++)
		{
			if(weights[0] <= c)
			{
				dp[0][c] = profits[0];
			}else
			{
				dp[0][c] = 0;
			}
		}

		for(int i  = 1 ; i < weights.length ; i++)
		{
			for(int c = 0 ; c <= capacity ; c++)
			{
				if(weights[i] <= c)
				{
					int includeProfit = profits[i] + dp[i-1][c-weights[i]];
					int excludeProfit = dp[i-1][c];

					dp[i][c] = Math.max(includeProfit,excludeProfit);
				}else
				{
					dp[i][c] = dp[i-1][c];
				}
			}
		}

		return dp[weights.length-1][capacity];
	}

	
}

public class BoundedKnapsackTabulationEx
{
	public static void main(String[] args) {
		BoundedKnapsack s = new BoundedKnapsack();
		int[] weights = {1,2,3};
		int[] profits = {5,2,4};

		int maxProfit = s.tabulation(weights,profits,3);
		System.out.println(" tabulation :: "+maxProfit);

	}
}