class BoundedKnapsack
{
	public int recursive(int[] weights, int[] profits, int capacity)
	{
		return recursive(weights, profits,capacity,0,0);
	}

	public int recursive(int[] weights, int[] profits, 
		int capacity, int profit,int index)
	{

		if(index == weights.length || capacity-weights[index] < 0 )
		{
			return profit;
		}


		int includeProfit = recursive(weights,
			profits,
			capacity-weights[index],profit+profits[index],index+1);

		int exludeProfit = recursive(weights,profits,capacity,profit,index+1);

		return Math.max(includeProfit,exludeProfit);

	}


	public int memoization(int[] weights, int[] profits, int capacity)
	{
		int[][] dp = new int[weights.length][1+capacity];
		for(int i = 0 ; i < weights.length ; i++ )
		{
			for(int c = 0 ; c <= capacity ; c++)
			{
				dp[i][c] = -1;
			}
		}
		return memoization(weights, profits,capacity,0,0,dp);
	}

	public int memoization(int[] weights, int[] profits, 
		int capacity, int profit,int index,int[][] dp)
	{


		if(index == weights.length || capacity-weights[index] < 0 )
		{
			return profit;
		}

		if(dp[index][capacity] != -1)
		{
			return dp[index][capacity];
		}

		int includeProfit = memoization(weights,
			profits,
			capacity-weights[index],profit+profits[index],index+1,dp);

		int exludeProfit = memoization(weights,profits,capacity,profit,index+1,dp);

		dp[index][capacity] = Math.max(includeProfit,exludeProfit);

		return dp[index][capacity];
	}
}

public class BoundedKnapsackEx
{
	public static void main(String[] args) {
		BoundedKnapsack s = new BoundedKnapsack();
		int[] weights = {1,2,3};
		int[] profits = {5,2,4};

		int maxProfit = s.recursive(weights,profits,5);
		System.out.println(" Recursion :: "+maxProfit);

		int memoizationProfit = s.memoization(weights,profits,5);
		System.out.println(" Memoization :: "+memoizationProfit);
	}
}