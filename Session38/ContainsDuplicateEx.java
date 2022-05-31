import java.util.Set;
import java.util.HashSet;
public class ContainsDuplicateEx {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int index = 0 ; index < nums.length ; index++)
        {
            if(set.contains(nums[index]))
            {
                return true;
            }
            
            set.add(nums[index]);
        }
        
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateEx s = new ContainsDuplicateEx();
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3};
       System.out.println(" {1,2,3,1} Contains duplicates = "+s.containsDuplicate(nums1));
       System.out.println(" {1,2,3} Contains duplicates = "+s.containsDuplicate(nums2));

    }
}