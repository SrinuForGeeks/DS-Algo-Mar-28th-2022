class HouseRobber {
    
    
     /*
    Time Complexity : O(n)
    Space Complexity : O(n)
    */
    public int tabulationSol1(int[] nums) {
        
        int n = nums.length;
        if(n == 1 )
        {
            return nums[0];
        }
        
        if(n == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2 ;i < n ; i++)
        {
            int includeCurrent = nums[i] + dp[i-2];
            int excludeCurrent = dp[i-1];
            
            dp[i] = Math.max(includeCurrent, excludeCurrent);
        }
        
        return dp[n-1];
    }

     /*
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public int tabulationSol2(int[] nums) {
        
        int n = nums.length;
        if(n == 1 )
        {
            return nums[0];
        }
        
        if(n == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        
         int prev = nums[0];
         int latest = Math.max(nums[0], nums[1]);
         int current;
        
        for(int i = 2 ;i < n ; i++)
        {
            current = Math.max(nums[i] + prev, latest);
            prev = latest;
            latest = current;
            
        }
        
        return latest;
    }

    /*
    Memoization
    Time  Complexity : O(n)
    Space Complexity : O(n)
    */
    public int memoization(int[] nums) {
        
        int n = nums.length;
        
        if(n == 1 )
        {
            return nums[0];
        }
        
        if(n == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        
       int[] dp = new int[n];
        
        for(int i = 0 ; i < n ; i++)
        {
            dp[i] = -1;
        }
      
       
       return memoization(dp, nums, n-1);
    }
    
    
    private int memoization(int[] dp, int[] nums, int currentHouseIndex)
    {
        if(currentHouseIndex == 0)
        {
            return nums[0];
        }
        
        if(currentHouseIndex == 1)
        {
            return Math.max(nums[0], nums[1]);
        }
        
        if(dp[currentHouseIndex] != -1)
        {
            return dp[currentHouseIndex];
        }
        
        int include = nums[currentHouseIndex] +  memoization(dp, nums, currentHouseIndex-2);
        int exclude =  memoization(dp, nums, currentHouseIndex-1);
        
         dp[currentHouseIndex] = Math.max(include, exclude);
        
        return  dp[currentHouseIndex];
        
        
    }
}

public class HouseRobberDP
{
public static void main(String[] args) {
    
    int[] nums = {2,7,9,3,1};
    HouseRobber s = new HouseRobber();

    System.out.println(" Tabulation Solution-One = "+s.tabulationSol1(nums));
    System.out.println(" Tabulation Solution-Two = "+s.tabulationSol2(nums));
    System.out.println(" Memoization = "+s.memoization(nums));


}
}