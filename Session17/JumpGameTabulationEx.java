class JumpGameTabulation {

    /*
i:0 --> n-1 jumps 

i:1 --> n-2 jumps

i:2 --> n-3 jumps ... n(n-1)/2 = O(n^2)

        Time Complexity  : O(n^2)
        Space Complexity : O(n)
    */
       public boolean canJump(int[] nums) {
        
        
        int n = nums.length;
        boolean[] dp = new boolean[n]; 
        // By default boolean[] values will be false
        
        dp[n-1] = true; // Start from n-1 to achive bottom up approch. 
                        // Solve the current Subproblem then reuse in next subproblems.
        
        for(int index = n-2; index >= 0 ; index--)
        {
            int nextPossibleJumps = Math.min(index + nums[index], n-1);
            
                for(int currentJump = index+1 ; currentJump <= nextPossibleJumps ; currentJump++)
                {
                     if(dp[currentJump] == true) // reached target
                     {
                         dp[index] = true;
                         break;
                     }
                }
            
               
        }
        
        return dp[0];
        
    }
}
public class JumpGameTabulationEx
{
    public static void main(String[] args) {
        JumpGameRecursive s = new JumpGameRecursive();

        int[] nums1 = {2,0,2,0,4};
        int[] nums2 = {3,2,1,0,4};


        System.out.println(" {2,0,2,0,4}  -->"+s.canJump(nums1));
        System.out.println(" {3,2,1,0,4}  -->"+s.canJump(nums2));

    }
}