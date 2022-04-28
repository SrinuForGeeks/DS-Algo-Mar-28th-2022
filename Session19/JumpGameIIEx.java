class JumpGameII {
    public int jump(int[] nums) {
        
        int windowLength = 0;
        int currentPosition = 0;
        int farthestFromWindow = 0;
        int n = nums.length;
        int minJumps =0;
        
        while(windowLength < n-1)
        {
            farthestFromWindow = Math.max(farthestFromWindow, currentPosition+nums[currentPosition]);
            
            if( currentPosition == windowLength)
            {
                minJumps++;
                windowLength = farthestFromWindow;
            }
            
            currentPosition++;
        }
        
        return minJumps;
    }
}

public class JumpGameIIEx
{
    public static void main(String[] args) {
        JumpGameII s = new JumpGameII();
         int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,1,4,7};


        System.out.println(" {2,3,1,1,4} minJumps = -->"+s.jump(nums1));
        System.out.println(" {3,2,1,1,4,7} minJumps = -->"+s.jump(nums2));
    }
}