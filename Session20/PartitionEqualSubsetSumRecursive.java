class  PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i = 0 ; i< nums.length ; i++)
        {
            sum = sum + nums[i];
        }
        
        if(sum % 2 != 0)
        {
            return false;
        }
        
        return canPartition(nums, 0, sum/2);
    }
    
    private boolean canPartition(int[] nums, int index, int subSetSum)
    {
        if(subSetSum == 0)
        {
            return true;
        }
        
        if(index == nums.length || subSetSum < 0)
        {
            return false;
        }
        
        boolean include = canPartition(nums,index+1, subSetSum - nums[index]);
        boolean exclude = canPartition(nums, index+1, subSetSum);
        
        return include || exclude;
    }
}

public class PartitionEqualSubsetSumRecursive
{
	public static void main(String[] args) {
		    int[] nums1 = {1,5,11,5};
		    int[] nums2 = {3,3,5,3};

	PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
    System.out.println("{1,5,11,5}  = "+s.canPartition(nums1));
    System.out.println("{3,3,5,3}   = "+s.canPartition(nums2));
    
	}
}