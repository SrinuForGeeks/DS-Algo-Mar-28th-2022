class Solution {
    public int coinChange(int[] coins, int amount) {
        
       int max = amount+1;
        
        int[] dp = new int[amount+1];
         dp[0] = 0; // For capacity : 0 the possible min Coins. = 0
        
        for(int c = 1 ; c <= amount ; c++)
        {
            dp[c] = max; // To hanlde -ve results
        }
        
        for(int c = 1 ; c <= amount ; c++)
        {
                for(int index = 0 ; index < coins.length ; index++)
                {
                        if(coins[index] <= c)
                        {
                            dp[c] = Math.min(1+dp[c-coins[index]] , dp[c]);
                        }
                }
        }
        
        
        
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}

public class CoinChangeTabulationEx
{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {1,2,5};
        System.out.println(" For {1,2,5} amount:11 --> "+s.coinChange(arr1,11));

        int[] arr2 = {2,5};
        System.out.println(" For {2,5} amount:3 --> "+s.coinChange(arr2,3));
    }
}