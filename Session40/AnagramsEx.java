import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AnagramsEx {
    public List<List<String>> groupAnagrams(String[] strs) {
        
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
    public static void main(String[] args) {
        AnagramsEx s = new AnagramsEx();
        String[] anagrams = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(s.groupAnagrams(anagrams));
    }
}