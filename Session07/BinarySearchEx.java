class BinarySearch
{
	 /*
        Time Complexity : O(logn)
        Space Complexity : O(1)
    */
        
	 public int search(int[] nums, int target) {
        
        return binarySearch(nums, target, 0, nums.length-1);
    }
    
    private int binarySearch(int[] nums, int target , int start, int end)
    {
        if( start > end)
        {
            return -1;
        }
        
        int mid = start + (end-start)/2;
        
        if(nums[mid] == target )
        {
            return mid;
        }
        else if(nums[mid] < target )
        {
            return binarySearch(nums, target, mid+1, end);
        }else // nums[mid] > target
        {
            return binarySearch(nums, target, start, mid-1);
        }
    }
}
 public class BinarySearchEx
{
    public static void main(String[] args) {
        BinarySearch s = new BinarySearch();
        int[] input1 = {-1,0,3,5,9,12};
        System.out.println(" For input {-1,0,3,5,9,12} , target 9 -> index : "+s.search(input1,9));
    
        System.out.println(" For input {-1,0,3,5,9,12} , target 2 -> index : "+s.search(input1,2));
    
    }
}