class QuickSort
{
    /*
            Time Complexity : O(nlogn)
            Space Complexity : O(logn) 
                     logn stack frames are active.
    */
    public int[] sortArray(int[] nums) {
        
        quickSort(nums, 0, nums.length-1);
        
        return nums;
    }
    
    public void quickSort(int[] nums, int left , int right)
    {
        if(nums.length <= 1)
        {
            return ;
        }
        
        int pivotIndex = partition(nums, left, right);
        
        if(left < pivotIndex - 1)
        {
             quickSort(nums, left , pivotIndex - 1);
        }
        
        if(pivotIndex < right)
        {
             quickSort(nums, pivotIndex, right);
        }
    }
    
    public int partition(int[] nums, int left , int right)
    {
        int pivot = nums[(left+right)/2];
        
        while(left <= right)
        {
                // move left till left > pivot
            
                while(nums[left] < pivot)
                {
                    left++;
                }
            
            
               // move right till riht < pivot
            
                while(nums[right] > pivot)
                {
                    right--;
                }
            
                if(left <= right)
                {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                    right--;
                }
        }
        
        return left;
    }
}

public class QuickSortEx
{
    public static void main(String[] args) {
        
        QuickSort m = new QuickSort();
        int[] nums1 = {5,1,1,2,0,0};
        int[] nums2 = {5,1,1,2,0,0,-1,9};
        int[] nums1Result =  m.sortArray(nums1);
        int[] nums2Result =  m.sortArray(nums2);
System.out.print(" For intput {5,1,1,2,0,0} ---> ");
 for(int i = 0 ; i < nums1Result.length ; i++){
            System.out.print(nums1Result[i]+" ");
    }

System.out.print(" \n For intput {5,1,1,2,0,0,-1,9} ---> ");
 for(int i = 0 ; i < nums2Result.length ; i++){
            System.out.print(nums2Result[i]+" ");
    }
System.out.println();
    }
}