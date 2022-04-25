class BuyAndSellStock
{
	 public int maxProfit(int[] prices) {
        
        int currentStock = prices[0];
        
        int maxProfit = 0;
        
        for(int i = 1 ; i < prices.length ; i++)
        {
            if(currentStock > prices[i])
            {
                currentStock = prices[i];
            }else
            {
                int currentWindowProfit = prices[i] - currentStock;
                maxProfit = Math.max(maxProfit, currentWindowProfit);
            }
        }
        
        return maxProfit;
    }
}

public class BuyAndSellStockDP
{
	public static void main(String[] args) {
		BuyAndSellStock s = new BuyAndSellStock();
	    int[] prices = {7,1,5,3,6,4};

	    System.out.println(" {7,1,5,3,6,4} MaxProfit --> "+s.maxProfit(prices));
	}
}

