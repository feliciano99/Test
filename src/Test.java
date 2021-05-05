import java.util.HashSet;
import java.util.Set;

public class Test {

    public static final int CHAR_RANGE = 128;
 
    public static String findLongestSubstring(String str, int k)
    {
        int end = 0, begin = 0;
 
        
        Set<Character> window = new HashSet<>();
 
        int[] freq = new int[CHAR_RANGE];
 
        for (int low = 0, high = 0; high < str.length(); high++)
        {
            window.add(str.charAt(high));
            freq[str.charAt(high)]++;
 
            while (window.size() > k)
            {
                if (--freq[str.charAt(low)] == 0) {
                    window.remove(str.charAt(low));
                }
 
                low++;       
            }
 
            if (end - begin < high - low)
            {
                end = high;
                begin = low;
            }
        }
 
        return str.substring(begin, end + 1);
    }
 
    public static void main(String[] args)
    {
        String str = "3aabbcbbbadef";
        int k = Integer.parseInt(str.substring(0, 1));
        
        System.out.println("adfasdf" + k);
 
        System.out.print(findLongestSubstring(str, k));
 
    }

}
