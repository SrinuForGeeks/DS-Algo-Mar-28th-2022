import java.util.List;
import java.util.ArrayList;

class Solution {
    /*
        Time Complexity : O(n*c)
        Space Complexity : O(c)
    */
    public int coinChange(int[] coins, int amount) {
        
        int max = 1+amount;
        CoinData[] dp = new CoinData[1+amount];
        dp[0] = new CoinData(0,max);
        
        for(int c = 1 ; c <= amount ; c++)
        {
            dp[c] = new CoinData(max,max);
        }
        
        for(int c = 1 ; c <= amount ; c++)
        {
            for(int coinIndex = 0 ; coinIndex < coins.length ; coinIndex++)
            {
                if(coins[coinIndex] <= c)
                {
                    
                 CoinData dataObject =   dp[c-coins[coinIndex]];
        
                  int includeCount = 1 + dataObject.minCount;
                  int exludeCount = dp[c].minCount;
                    
                  if(exludeCount > includeCount )
                  {
                      dp[c] = new CoinData(includeCount,coinIndex);
                  }
                    
                   
                }
            }
        }
        
        // Back Tracking ::::
        if(dp[amount].minCount < amount) 
        {
        List<Integer> includedCoins = new ArrayList<>();
         int capacity = amount;
         while(capacity > 0)
         {
             int coin = coins[dp[capacity].coinIndex];
             includedCoins.add(coin);
             capacity = capacity-coin;
         }
        System.out.println(" Coins used ~~ For Target Amount "+amount+" are = "+includedCoins);
        }
       
        
        
        return dp[amount].minCount > amount ? -1 : dp[amount].minCount;
    }
    
    class CoinData
    {
        int minCount;
        int coinIndex;
        
        public CoinData(int minCount, int coinIndex)
        {
            this.minCount= minCount;
            this.coinIndex = coinIndex;
        }
    }
   
}

public class CoinChangeBackTrackingEx
{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {1,2,5};
        System.out.println(" For {1,2,5} amount:11 --> "+s.coinChange(arr1,11));

        int[] arr2 = {2,5};
        System.out.println(" \n For {2,5} amount:3 --> "+s.coinChange(arr2,3));
    }
}