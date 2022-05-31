import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class FindAllDuplicatesEx {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        Set<Integer> set = new HashSet<>();
        
        for(int index = 0 ; index < nums.length ; index++)
        {
            if(set.contains(nums[index]))
            {
                list.add(nums[index]);
            }else
            {
                set.add(nums[index]);
            }
            
        }
        
        return list;
        
    }

    public static void main(String[] args) {
        FindAllDuplicatesEx s = new FindAllDuplicatesEx();
        int[] nums = {1,2,3,1,7,3,11};

        List<Integer> list = s.findDuplicates(nums);
        System.out.println(" Duplicates are :: "+list);
    }
}