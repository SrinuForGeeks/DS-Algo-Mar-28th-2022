class ClimbStairsProblem {

    /*
     Time Complexity  : O(n)
     Space Complexity : O(n)
    */
    public int climbStairsSol1(int n) {
        
        if(n <= 2)
        {
            return n;
        }
        
        int[] dp = new int[n+1]; // size:n+1 is need to store nth step result.
        
        dp[1] = 1; // if n == 1 we can reach in 1 distinct way
        dp[2] = 2; // if n == 2 we can reach in 2 distinct way
        
        for(int i = 3 ; i <= n ; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
        
    }

     /*
     Time Complexity  : O(n)
     Space Complexity : O(1)
    */
    public int climbStairsSol2(int n) {
     
        if(n <= 2)
        {
            return n;
        }
        
        int n1 = 1;
        int n2 = 2;
        int currentNResult ;
        
        for(int i = 3 ; i <= n ; i++)
        {
            currentNResult = n1+n2;
            n1 = n2;
            n2 = currentNResult;
        }
        
        return n2;
    }
}

public class ClimbStairsEx
{
    public static void main(String[] args) {
        ClimbStairsProblem s = new ClimbStairsProblem();
        System.out.println(" n = 3 :: Solution1 Distinct Ways= "+s.climbStairsSol1(3));
        System.out.println(" n = 3 :: Solution2 Distinct Ways= "+s.climbStairsSol2(3));

    }
}