import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AnagramsEx {
    /*
        Time Complexity : O(nklogn)
        Space Complexity : O(n)--> By considering space occupied by output result

    */
    public List<List<String>> groupAnagramsBySort(String[] strs) {
        
        Map<String, List<String> > map  = new HashMap<>();
        
        for(int index = 0 ; index < strs.length ; index++)
        {
            String current = strs[index];
            
            char[] chArr = current.toCharArray();
            
            Arrays.sort(chArr); // Does the quick sort
            
            String key = String.valueOf(chArr);
            
            map.putIfAbsent(key , new ArrayList<>());
            
            map.get(key).add(current);
        }
        
        return new ArrayList<> ( map.values() );
        
    }

    /*
        Time Complexity : O(nk)
        Space Complexity : O(n)--> By considering space occupied by output result

    */
    public List<List<String>> groupAnagramsByHashKey(String[] strs) {
        
        
        Map<String, List<String> > map  = new HashMap<>();
        int[] arr = new int[26];
        
        for(int index = 0 ; index < strs.length ; index++)
        {
            String current = strs[index];
            Arrays.fill(arr,0);
            
           for(int j = 0 ; j < current.length() ; j++)
           {
               int chIndex = current.charAt(j) - 'a';
               arr[chIndex] = arr[chIndex]+1;
           }
            
            String hashKey = "";
            for(int chIndex = 0 ; chIndex < 26 ; chIndex++)
            {
                hashKey = hashKey+"#"+arr[chIndex];
            }
            
            map.putIfAbsent(hashKey, new ArrayList<>());
            
            map.get(hashKey).add(current);
        }
        
        return new ArrayList<> ( map.values() );
        
        
    }
    public static void main(String[] args) {
        AnagramsEx s = new AnagramsEx();
        String[] anagrams = {"eat","tea","tan","ate","nat","bat"};

        System.out.println("\n By Sort " + s.groupAnagramsBySort(anagrams));
        System.out.println("\n By HashKey " + s.groupAnagramsBySort(anagrams));

    }
}