import java.util.Map;
import java.util.HashMap;

public class LongestSubstringEx {
    /*
        Time Complexity : O(n^2)
        Space Complexity : O(1)
    */
    public int bruteForse(String s) {
        
        int left = 0 ;
        int right = 0;
        int max = 0;
        
        while(right < s.length())
        {
            int tempLeft = left;
            while(tempLeft < right)
            {
                if( s.charAt(tempLeft) == s.charAt(right) )
                {
                    left = tempLeft+1;
                    break;
                }
                tempLeft++;
            }
            
            max = Math.max(max, right-left+1);
            right++;
        }
        
        return max;
    }

/*
        Time Complexity : O(n)
        Space Complexity : O(1)
    */
    public int hashWithArray(String s) {
        
        int left = 0 ;
        int right = 0;
        int max = 0;
        int[] arr = new int[128];
        
        while(right < s.length())
        {
           char rch = s.charAt(right);
            arr[rch] = arr[rch]+1;
            
            while(arr[rch] > 1)
            {
                char lch = s.charAt(left);
                arr[lch] = arr[lch]-1;
                left++;
            }
            
            max = Math.max(max, right-left+1);
            right++;
        }
        
        return max;
    }

    /*
        Time Complexity : O(n)
        Space Complexity : Math.min(map.size(),s.length())
    */
    public int hashWithMap(String s) {
         int left = 0 ;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(right < s.length())
        {
           char rch = s.charAt(right);
           if(map.containsKey(rch))
           {
               left = Math.max(left,map.get(rch)+1);
           }
            
        max = Math.max(max, right-left+1);
        map.put(rch,right);
            
            right++;
        }
        
        return max;
    }
    public static void main(String[] args) {
        LongestSubstringEx s = new LongestSubstringEx();
        System.out.println("pwwkew --> BruteForce --> Count :: "+s.bruteForse("pwwkew"));

        System.out.println("pwwkew -->  hashWithArray --> Count :: "+s.hashWithArray("pwwkew"));
;
        System.out.println("pwwkew --> hashWithMap --> Count :: "+s.hashWithMap("pwwkew"));

    }
}