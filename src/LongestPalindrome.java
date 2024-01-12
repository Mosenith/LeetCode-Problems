import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "a";

        System.out.println(longestPalindrome(s));
    }

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
}
