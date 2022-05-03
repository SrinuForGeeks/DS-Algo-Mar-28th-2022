class TargetSum {
    /*
        Time Complexity : O(2^n)
        Space Complexity: O(n)
    */
    public int findTargetSumWays(int[] nums, int target) {
        
        return count(nums, 0,target,0);
    }
    
    private int count(int[] nums , int sum, int target, int index)
    {
        if(index == nums.length)
        {
            if(sum == target)
            {
                return 1;
            }else
            {
               return 0; 
            } 
        }
        
        return count(nums, sum+nums[index], target , index+1) 
                    +
               count(nums, sum-nums[index], target, index+1);
    }
}

public class TargetSumRecursive
{
    public static void main(String args[])
    {
        int[] nums = {1,1,1};
        TargetSum s = new TargetSum();
        System.out.println(" {1,1,1} target 1 --> No.Of Ways --> "+s.findTargetSumWays(nums,1));
    }
}