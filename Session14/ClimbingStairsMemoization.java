class ClimbingStairs {


    /*
    Time Complexity : O(2^n)
    Space Complexity : O(n) 
    :: N StackFrames would be active at any point in time
    */
 public int recursive(int n) {
       
        return climb(n);
    }
        
 private int climb(int n)
    {
        if( n <= 2 )
        {
            return n;
        }
        
        return climb(n-1) + climb(n-2);
    }


    /*
    Time Complexity : O(n)
    Space Complexity : O(n) 
    :: N StackFrames would be active at any point in time.
    */
    public int memoization(int n) {
       int[] dp = new int[n+1];
        return climb(n,dp);
    }
        
    private int climb(int n, int[] dp)
    {
       if(n <= 2)
       {
           return n;
       }
        
        if(dp[n] != 0)
        {
            return dp[n];
        }
        
        dp[n] = climb(n-1,dp) + climb(n-2,dp);
        
        return dp[n];
    }
}

public class ClimbingStairsMemoization
{
    public static void main(String[] args) {
        ClimbingStairs s = new ClimbingStairs();
        System.out.println(" n=3 Recurvive Solution = "+s.recursive(3));
        System.out.println(" n=3 memoization Solution = "+s.memoization(3));
    }
}