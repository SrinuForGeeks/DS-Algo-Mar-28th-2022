class Median {
    /*
        Time Complexity : O(m+n)
        Space Complexity : O(m+n)
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] arr = compareAndMerge(nums1, nums2);
        
        int n = arr.length;
        int mid = n/2;
        
        if(n%2 == 0)
        {
         return (arr[mid] + arr[mid-1])/2.0;
        }
        
        return arr[mid];
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
    
}

public class MedianEx
{
    public static void main(String[] args) {
        
        Median m = new Median();
        int[] num1 = {1,3};
        int[] num2 = {2};
        System.out.println(" Median Of {1,3}::{2}   = "
            +m.findMedianSortedArrays(num1,num2));

        int[] num3 = {1,4};
        int[] num4 = {2,3};
        System.out.println(" Median Of {1,4}::{2,3}  = "
            +m.findMedianSortedArrays(num3,num4));
    }
}