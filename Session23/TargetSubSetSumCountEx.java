class TargetSubSetSumCount {
    public int find(int[] nums, int target) {
        
       return count(nums, target, 0, 0);
    }
 
    private int count(int[] nums, int target, int sum, int index )
    {
        
        if( sum == target) 
        {
            return 1;
        }
        
        if(index == nums.length || sum > target)
        {
            return 0;
        }
        
        return count(nums, target, sum+nums[index], index+1)
                    +
                count(nums, target, sum, index+1);
    }
}
public class TargetSubSetSumCountEx 
{
    public static void main(String[] args) {
        TargetSubSetSumCount s = new TargetSubSetSumCount();
        int[] nums1 = {1,2,1}; // {1,1} {2} = result : 2

        System.out.println("{1,2,1} target 2 ::  No.Of Ways = "
            +s.find(nums1, 2));

     int[] nums2 = {1,3,7,6,2,9}; // {1,6,2}  {3,6} {7,2} {9}  = 4
    System.out.println("{1,3,7,6,2,9} target 9 ::  No.Of Ways = "
            +s.find(nums2, 9));

    }
}


