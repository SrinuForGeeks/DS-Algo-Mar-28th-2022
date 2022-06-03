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

    public static void main(String[] args) {
        LongestSubstringEx s = new LongestSubstringEx();
        System.out.println(" BruteForce --> Count :: "+s.bruteForse("pwwkew"));
    }
}