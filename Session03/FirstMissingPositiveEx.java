class FirstMissingPositive {
     /* Time Complexity = 4 O(n) ~ O(n)
       Space Complexity = O(n)
    */    
    public int outplace(int[] nums) {
        
        int n = nums.length;
        boolean[] arr = new boolean[n];
        
        boolean isOnePresent = false;
        
        for(int i = 0 ; i < n ; i++)
        {
            if( nums[i] == 1)
            {
                isOnePresent = true;
                break;
            }
        }
        
        if(isOnePresent == false)
        {
            return 1;
        }
        
        // Realve values with 1 if nums[i] > n || nums[i] <=0
        for(int i = 0 ; i < n ; i++)
        {
            if( nums[i] <= 0 || nums[i] > n)
            {
                nums[i] = 1;
            }
        }
        
        // Update the respected flags in boolean[]
        for(int i = 0 ; i < n ; i++)
        {
            int value = nums[i];
            if(value == n)
            {
                arr[0] = true;
            }else
            {
               arr[value] = true;  
            }
           
        }
        
        for(int i = 1;  i < n ; i++)
        {
            if(arr[i] == false)
            {
                return i;
            }
        }
        
        // Waht if n only missing
        
        if(arr[0] == false)
        {
            return n;
        }
        
        // what if all the [1,n] elements present 
        return n+1;
    }

     /* Time Complexity = 4 O(n) ~ O(n)
       Space Complexity = O(1)
    */
    public int inplace(int[] nums) {
        
        int n = nums.length;
        
        boolean isOnePresent = false;
        
        // O(n)
        for(int i = 0 ; i < n ; i++)
        {
            if( nums[i] == 1)
            {
                isOnePresent = true;
                break;
            }
        }
        
        if(isOnePresent == false)
        {
            return 1;
        }
        
        // Realve values with 1 if nums[i] > n || nums[i] <=0
        // O(n)
        for(int i = 0 ; i < n ; i++)
        {
            if( nums[i] <= 0 || nums[i] > n)
            {
                nums[i] = 1;
            }
        }
        
    for(int i = 0 ; i < n ; i++)
        {
          int value = Math.abs(nums[i]);
        if(value == n)
            {
                nums[0] = - Math.abs(nums[0]); // What if n is repeated
            }else
                 {
           nums[value] = - Math.abs(nums[value]); 
                 }
        }
        
         for(int i = 1 ; i < n ; i++)
        {
                if(nums[i] > 0)
                {
                    return i;
                }
         }
        
        // What if n is missing 
        if(nums[0] > 0)
        {
            return n;
        }
        
        // What if all [1,n] presents
        return n+1; 
    }
}

public class FirstMissingPositiveEx
{
    public static void main(String[] args) {
        FirstMissingPositive fp = new FirstMissingPositive();

        int[] nums = {1,3,0};
        System.out.println("Outplace input {1,3,0} -> "+fp.outplace(nums));
       
        int[] nums2 = {1,3,2};
        System.out.println("Outplace input {1,3,2} -> "+fp.outplace(nums2));

         int[] nums3 = {-1,3,2};
        System.out.println("Outplace input {-1,3,2} -> "+fp.outplace(nums3));



        int[] nums4 = {1,3,0};
        System.out.println("Inplace input {1,3,0} -> "+fp.inplace(nums4));
       
        int[] nums5 = {1,3,2};
        System.out.println("Inplace input {1,3,2} -> "+fp.inplace(nums5));

         int[] nums6 = {-1,3,2};
        System.out.println("Inplace input {-1,3,2} -> "+fp.inplace(nums6));

    }
}





