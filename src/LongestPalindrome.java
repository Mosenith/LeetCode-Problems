import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "a";

        System.out.println(longestPalindrome(s));
    }
    // ***************** 1st Method ******************
    // Approach 1: Get map to store all the chars in s - k=char, v-#occurances
    // If value of char %2==0, add to len
    // Otherwise, add all when flag=1, then set flag to 0 and add map.get(c)-1 to len
    // At each iteration, remove(c) from char[] & finally return len
    // Runtime  : 8ms         -> + 30.36%
    // Memory   : 41.94MB     -> + 15.89%
    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();

        for(char c : sChar) {
            map.computeIfPresent(c,(k,v) -> v+1);
            map.computeIfAbsent(c,v -> 1);
        }

        int len = 0;
        int flag = 1;
        for(char c : sChar) {
            if(map.isEmpty()) {
                break;
            }
            if(!map.containsKey(c)) continue;
            if(map.get(c) % 2 == 0) {
                len += map.get(c);
            } else {
                if(flag == 1) {
                    len += map.get(c);
                    flag = 0;
                } else {
                    len += map.get(c)-1;
                }
            }
            map.remove(c);
        }
        return len;
    }
    //  ***************** End of 1st Method ******************

}
