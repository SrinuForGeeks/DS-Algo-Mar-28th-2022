class JumpGameRecursive {

    /*
        Time Complexity :  Average Case --> O(2^n)
        Space Complexity : O(n)
    */
    public boolean canJump(int[] nums) {
        
        
        return canJump(0,nums);
    }
    
    private boolean canJump(int index, int[] nums)
    {
        if(index == nums.length-1)
        {
            return true;
        }
        
        if(nums[index] == 0)
        {
            return false;
        }
        
        int nextPossibleJumps = index + nums[index];
        
        for(int currentJumpIndex = index+1 ; currentJumpIndex <= nextPossibleJumps ; currentJumpIndex++ )
        {
             if(canJump(currentJumpIndex, nums) == true)
             {
                 return true;
             }
        }
        
        return false;
    }
}
public class JumpGameRecursiveEx
{
    public static void main(String[] args) {
        JumpGameRecursive s = new JumpGameRecursive();

        int[] nums1 = {2,0,2,0,4};
        int[] nums2 = {3,2,1,0,4};


        System.out.println(" {2,0,2,0,4}  -->"+s.canJump(nums1));
        System.out.println(" {3,2,1,0,4}  -->"+s.canJump(nums2));

    }
}