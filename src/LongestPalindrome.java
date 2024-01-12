import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdde";

        System.out.println(longestPalindrome2(s));
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

    // ***************** 2nd Method ******************
    // Approach 2: The main idea is to count the odd occurrence of char in s
    // If oddCount > 1 => s.length() - oddCount + 1 cos we can have 1 odd char in the middle
    // Otherwise, return s.len
    // Runtime  : 2ms         -> + 85.20%
    // Memory   : 41.92MB     -> + 16.55%
    public static int longestPalindrome2(String s) {
        int oddCount = 0;
        int[] freq = new int[128];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
            if (freq[ch] % 2 == 1)
                oddCount++;
            else
                oddCount--;
        }

        System.out.println(oddCount);
        if (oddCount > 1)
            return s.length() - oddCount + 1;
        return s.length();
    }
    //  ***************** End of 2nd Method ******************
}
