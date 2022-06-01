import java.util.Map;
import java.util.HashMap;

public class RomanToIntEx {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    
       int sum = map.get(s.charAt(0));
        int prev = sum;
        
        for(int index = 1 ; index < s.length() ; index++)
        {
            int current = map.get(s.charAt(index));
            
            if(current <= prev)
            {
                sum = sum + current;
            }else
            {
                sum = sum + current - 2 * prev;
            }
            prev = current;
        }
    
            return sum;

    }
    public static void main(String[] args) {
        RomanToIntEx s = new RomanToIntEx();
        int sum1 = s.romanToInt("MCM");
        System.out.println(" MCM = "+sum1);

         int sum2 = s.romanToInt("MCMXCIV");
        System.out.println(" MCMXCIV = "+sum2);
    }
}