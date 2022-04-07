class MergeSort {
    public int[] sortArray(int[] nums) {
        
        return divide(nums, 0, nums.length); 
    }
    
    
    private int[] divide(int[] arr, int start, int end)
    {
        if( arr.length <= 1)
        {
            return arr;
        }
        
        int mid = (start+end)/2;  
        int[] leftCopyArr = copy(arr,0,mid);  
        int[] rightCopyArr = copy(arr,mid, end);
        
        int[] leftArr = divide(leftCopyArr, 0, leftCopyArr.length);
        int[] rightArr = divide(rightCopyArr, 0, rightCopyArr.length);

            
        return compareAndMerge(leftArr, rightArr);

    }
    
    
    private int[] compareAndMerge(int[] leftArr, int[] rightArr)
    {
        int n = leftArr.length;
        int m = rightArr.length;
        int[] output = new int[m+n];
        
        int left = 0;
        int right =0;
        int curr = 0;
        
        while(left < n && right < m)
        {
            if(leftArr[left] <= rightArr[right])
            {
                output[curr] = leftArr[left] ;
                left++;
            }else
            {
                output[curr] = rightArr[right];
                right++;
            }
            curr++;
        }
        
        while(left < n)
        {
            output[curr] = leftArr[left];
            curr++;
            left++;
        }
        
         while(right < m)
        {
            output[curr] = rightArr[right];
            curr++;
            right++;
        }
        
        return output;
    }
    
    private int[] copy(int[] nums, int start, int end)
    {
        int n = end-start;
        int[] output = new int[n];
        int curr = 0;
        
        while(start < end)
        {
            output[curr++] = nums[start++];
        }
        
        return output;
    }
}

public class MergeSortEx
{
    public static void main(String[] args) {
        
        MergeSort m = new MergeSort();
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