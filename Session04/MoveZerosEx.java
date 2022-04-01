class MoveZeros {
    public void moveZeroes(int[] nums) {
        
        int start = 0;
        int end = 0;
        int n = nums.length;
        
        while(end < n)
        {
            if(nums[end] != 0)
            {
                nums[start] = nums[end];
                start++;
            }
            
            end++;
        }
        
        // Replace remaing value with the zero from start index: 
        
        while(start < n )
        {
            nums[start] = 0;
            start++;
        }
    }
}

public class MoveZerosEx
{
    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] nums = {0,1,0,2,0,13,4,0};

        mz.moveZeroes(nums);

        for(int i = 0 ; i< nums.length ; i++)
        {
            System.out.print(nums[i]+" ");
        }
    }
}