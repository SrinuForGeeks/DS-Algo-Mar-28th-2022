class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 1;
        
        while(end < n)
        {
            if(nums[end] > nums[start])
            {
                start++;
                nums[start] = nums[end];
            }
            end++;
        }
        
        return start+1;
    }
}

public class RemoveDuplicatesEx
{
    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
       int k = rd.removeDuplicates(nums);
       for(int i = 0 ; i< k ; i++)
        {
            System.out.print(nums[i]+" ");
        }
    }
}