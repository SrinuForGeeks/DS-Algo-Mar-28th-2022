class JumpGameGreedy {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        if( n == 1)
        {
            return true;
        }
        
        if(nums[0] == 0 )
        {
            return false;
        }
        
        int lastGoodPosition = n-1;
        
        for(int index = n-2 ; index >= 0; index--)
        {
                int maxJumpOfCurrentIndex = index+ nums[index];
            
                if(maxJumpOfCurrentIndex >= lastGoodPosition )
                {
                    lastGoodPosition = index;
                }
        }
        
        return lastGoodPosition == 0 ;
    }
}

public class JumpGameGreedyEx
{
    public static void main(String[] args) {
        JumpGameGreedy s = new JumpGameGreedy();
         int[] nums1 = {2,0,2,0,4};
        int[] nums2 = {3,2,1,0,4};


        System.out.println(" {2,0,2,0,4}  -->"+s.canJump(nums1));
        System.out.println(" {3,2,1,0,4}  -->"+s.canJump(nums2));
    }
}