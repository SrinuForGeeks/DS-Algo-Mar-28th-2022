class RotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        if( n == 1)
        {
            return nums[0] == target ? 0 : -1;
        }
        int pivot = rotationIndex(nums,0,n-1);
        
        if(nums[pivot] == target)
            return pivot;
        
        if(pivot == 0)
        {
          return bserach(nums, 0, n-1, target);
        }
        
        if(target < nums[0])
             return bserach(nums, pivot+1, n-1, target);
        
        return bserach(nums, 0, pivot-1, target);
    }
    
    private int bserach(int[] nums, int left , int right,int target)
    {
        int mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            if(nums[mid] > target)
            {
                right = mid-1;
            }else if(nums[mid] < target)
            {
                left = mid+1;
            }else
            {
                return mid;
            }
        }
        return -1;
    }
    
    private int rotationIndex(int[] nums, int left, int right)
    {
        if(nums[left] < nums[right])
        {
            return 0;
        }
        
        int pivot ;
        
        while(left <= right)
        {
            pivot = left + (right-left)/2;
            if( nums[pivot] > nums[pivot+1])
            {
                return pivot+1;
            }else if(nums[pivot] < nums[left]) // Move Left to find smallest
            {
                right = pivot-1;
            }else //  Move Right to find smallest
            {
                left = pivot+1;
            }
        }
        
        return 0;
    }
}

public class RotatedSortedArrayEx
{
    public static void main(String[] args) {
        RotatedSortedArray s = new RotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(" arr:{4,5,6,7,0,1,2} :: target : 0 -->  Ouput  : "+s.search(nums,0));
        System.out.println(" arr:{4,5,6,7,0,1,2} :: target : 3 -->  Output : "+s.search(nums,3));

    }
}