class JumpGameMemoization {

    /*
i:0 --> n-1 jumps 

i:1 --> n-2 jumps

i:2 --> n-3 jumps ... n(n-1)/2 = O(n^2)

        Time Complexity  : O(n^2)
        Space Complexity : O(n)
    */
     public boolean canJump(int[] nums) {
        
        int[] dp = new int[nums.length]; // -1 sub problem not solved
                                         // +1 --> true
                                         // 0  --> false
        
        for(int i = 0 ; i < nums.length; i++)
        {
            dp[i] = -1;
        }
        
        return canJump(0,nums,dp);
    }
    
    private boolean canJump(int index, int[] nums,int[] dp)
    {
        if(index == nums.length-1) // reached target
        {
            return true;
        }
        
        if(nums[index] == 0) 
        {
            return false;
        }
        
        if(dp[index] != -1)
        {
            return dp[index] == 1 ? true : false;
        }
        
        int nextPossibleJumps = index + nums[index];
        
        for(int currentJumpIndex = index+1 ; currentJumpIndex <= nextPossibleJumps ; currentJumpIndex++ )
        {
             if(canJump(currentJumpIndex, nums,dp) == true) // reached target
             {
                 dp[currentJumpIndex] = 1;
                 return true;
             }
        }
        
        dp[index] = 0;
        return false;
    }
}
public class JumpGameMemoizationEx
{
    public static void main(String[] args) {
        JumpGameRecursive s = new JumpGameRecursive();

        int[] nums1 = {2,0,2,0,4};
        int[] nums2 = {3,2,1,0,4};


        System.out.println(" {2,0,2,0,4}  -->"+s.canJump(nums1));
        System.out.println(" {3,2,1,0,4}  -->"+s.canJump(nums2));

    }
}