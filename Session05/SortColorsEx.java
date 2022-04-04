class SortColors {
    /*
    Time Complexity : O(n)
    Space Complexity: O(1)
    */
    public void sortColorsAlgo(int[] nums) {
        
        int left = 0;
        int right = nums.length-1;
        int curr = 0;
        
        while(curr <= right)
        {
            if(nums[curr] == 2)
            {
                int temp = nums[right];
                nums[right] = nums[curr];
                nums[curr] = temp;
                right--;
            }else if (nums[curr] == 0)
            {
                int temp = nums[left];
                nums[left] = nums[curr];
                nums[curr] = temp;
                left++;
                curr++; 
            }else // nums[curr] == 1
            {
                 curr++;
            }
            
           
        }
        
    }
}

public class SortColorsEx
{
    public static void main(String[] args) {
        int[] input1 = {1,2,0};
        int[] input2 = {2,0,2,1,1,0};

        SortColors s = new SortColors();
        s.sortColorsAlgo(input1);
        s.sortColorsAlgo(input2);

        System.out.print("\n Result for {1,2,0}  --> {");
        for(int i = 0 ; i < input1.length ; i++)
        {
            System.out.print(input1[i]+" ");
        }

        System.out.print("}\n Result for {2,0,2,1,1,0}  --> {");
        for(int i = 0 ; i < input2.length ; i++)
        {
            System.out.print(input2[i]+" ");
        }
        System.out.print("}\n");
    }
}