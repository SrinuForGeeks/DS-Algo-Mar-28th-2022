class MissingNumber {
    public int find(int[] nums) {
        
        int n = nums.length;
        
        int actualSum = (n * (n+1))/2;
        int elementSum = 0;
        
        for(int index = 0 ; index < n ; index++)
        {
            elementSum = elementSum+ nums[index];
        }
        
        return actualSum - elementSum;
        
    }
}

public class MissingNumberEx
{
    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] arr = {3,0,2};
        int value = m.find(arr);
        System.out.println(" Missing Number :: "+value);
    }
}




