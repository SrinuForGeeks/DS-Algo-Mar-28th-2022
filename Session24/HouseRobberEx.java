class HouseRobber
{

	/* 
		Time Complexity : O(2^n)
		Space Complexity : O(n)
	*/
	public int recursive(int[] nums){

		return recursive(nums, nums.length-1);
	}
 	public int recursive(int[] nums,int index)
	{

		if(index == 0)
		{
			return nums[0];
		}

		if(index == 1)
		{
			return Math.max(nums[0],nums[1]);
		}

		int include = nums[index] + recursive(nums,index-2);
		int exclude = recursive(nums,index-1);

		return Math.max(include, exclude);
	}


		/* 
		Time Complexity : O(n)
		Space Complexity : O(n)
		*/
	public int memoization(int[] nums)
	{
		
		int n = nums.length;

		if(n == 0)
		{
			return nums[0];
		}

		if(n == 1)
		{
			return Math.max(nums[0],nums[1]);
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0],nums[1]);

		for(int i = 2 ; i < n  ; i++)
		{
			dp[i] = -1;
		}

		return memoization(nums, n-1, dp);

	}

	public int memoization(int[] nums,int index,int[] dp)
	{
		if(dp[index] != -1)
		{
			return dp[index];
		}

		int include = nums[index] + memoization(nums,index-2,dp);
		int exclude = memoization(nums,index-1,dp);

		dp[index] = Math.max(include, exclude);
		return dp[index];
	}

		/* 
		Time Complexity : O(n)
		Space Complexity : O(n)
		*/
	public int tabulation(int[] nums)
	{
		int n = nums.length;

		if(n == 0)
		{
			return nums[0];
		}

		if(n == 1)
		{
			return Math.max(nums[0],nums[1]);
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0],nums[1]);
		for(int index = 2 ; index < n ; index++)
		{
			dp[index] = Math.max(nums[index]+dp[index-2] , dp[index-1]);
		}

		return dp[n-1];
	}

			/* 
		Time Complexity : O(n)
		Space Complexity : O(1)
		*/
	public int tabulation2(int[] nums)
	{
		int n = nums.length;

		if(n == 0)
		{
			return nums[0];
		}

		if(n == 1)
		{
			return Math.max(nums[0],nums[1]);
		}

		
		int prev = nums[0]; // represents i-2
		int latest = Math.max(nums[0],nums[1]); // represents i-1
		int current = latest;
		for(int index = 2 ; index < n ; index++)
		{
			current = Math.max(nums[index]+prev , latest);
			prev = latest;
			latest = current;
		}

		return latest;
	}

}

public class HouseRobberEx
{
	public static void main(String[] args) {
		
		HouseRobber s = new HouseRobber();
		int[] nums = {2,7,9,3,1};

		System.out.println(" Recursive --> "+s.recursive(nums));
		
		System.out.println(" Memoization --> "+s.memoization(nums));

		System.out.println(" Tabulation --> "+s.tabulation(nums));

		System.out.println(" Tabulation2 --> "+s.tabulation2(nums));


	}
}