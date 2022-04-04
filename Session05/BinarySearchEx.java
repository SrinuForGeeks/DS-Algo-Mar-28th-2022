class BinarySearch {
    /*
        Time Complexity : O(logn)
        Space Complexity : O(1)
    */
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;
        
        int mid;
        
        while(left <= right)
        {
            mid = (left+right)/2;
            
            if( nums[mid] < target)
            {
                left = mid+1;
            }else if( nums[mid] > target)
            {
                right = mid-1;
            }else // it means nums[mid] == target
            {
                return mid;
            }
        }
        
        return -1;
        
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