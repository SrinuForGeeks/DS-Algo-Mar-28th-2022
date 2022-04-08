import java.util.Arrays;

class Majority {

        /*
        Time Complexity : O(nlogn)
        Space Complexity : O(n)
        */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }
    /*
        Time Complexity : O(n)
        Space Complexity : O(1)
    */
    public int majorityElement2(int[] nums) {
        
        int vote = 1;
        int element = nums[0];
        int index = 1;
        
        while(index < nums.length)
        {
            if(vote == 0)
            {
               element = nums[index]; 
            }
            
            if(nums[index] == element)
            {
                vote++;
            }else
            {
                vote--;
            }
            index++;
        }
        
        return element;
    }
    
}

public class MajorityElementEx
{
    public static void main(String[] args) {
        Majority m = new Majority();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(" Solution-1 :: {2,2,1,1,1,2,2} ---> "+ m.majorityElement1(nums));
        System.out.println(" Solution-2 :: {2,2,1,1,1,2,2} ---> "+ m.majorityElement2(nums));

    }
}