class BuyAndSellStockII {
       /*
        Time Complexity : O(n)
        Space Complexity : O(1)
    */
    public int totalProfitSol1(int[] prices) {
        
        int vally = 0;
        int peak = 0;
        int totalProfit = 0;
        
        for(int i = 0 ; i < prices.length - 1; i++)
        {
                // Find out the vally ... Move till the current < next
                while( i < prices.length - 1 && prices[i] > prices[i+1])
                {
                    i++;
                }
                vally = prices[i];
                
            
                // Find Out the Peak ... Move till index where current > next
                while(i < prices.length-1  &&  prices[i] < prices[i+1] )
                {
                    i++;
                }
                peak = prices[i];
            
              totalProfit = totalProfit + (peak - vally);
        }
        
        return totalProfit;
        
    }

   /*
        Time Complexity : O(n)
        Space Complexity : O(1)
    */
    public int totalProfitSol2(int[] prices) {
        
         
        int totalProfit = 0;
        
        for(int i = 1 ; i < prices.length ; i++)
        {
              if(prices[i] > prices[i-1])
              {
                  totalProfit = totalProfit + ( prices[i] - prices[i-1] );
              }
        }
        
        return totalProfit;
        
    }
}
public class BuyAndSellStockIIDP
{
    public static void main(String[] args) {
        BuyAndSellStockII s = new BuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};

        System.out.println(" {7,1,5,3,6,4} Sol[One] = "+s.totalProfitSol1(prices));
        System.out.println(" {7,1,5,3,6,4} Sol[Two] = "+s.totalProfitSol2(prices));

    }
}