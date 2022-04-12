class Median {
    /*
        Time Complexity : O(log(Math.min(n1,n2))
        Space Complexity : O(1)
    */
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
         if( n2 < n1)
         {
             return findMedianSortedArrays(nums2, nums1);
         }
        
        int n = n1+n2;
       
        int low = 0;
        int high = n1;
        double median = 0;
        
       
        
        while(low <= high)
        {
            int cut1 = (low+high)/2;
            int cut2 = (n/2) - cut1;
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            
            int l2  = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if( l1 <= r2 && l2 <= r1 )
            {
                if( n % 2 == 0)
                {
                    median = (Math.max(l1,l2) + Math.min(r1,r2) ) /2.0;
                }else
                {
                    median =  Math.min(r1,r2);
                }
                break;
            }else if(l1 > r2)
            {
                high = cut1 - 1;
            }else // it means l2 > r1
            {
                low = cut1+1;
            }
        }
        
        return median;
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