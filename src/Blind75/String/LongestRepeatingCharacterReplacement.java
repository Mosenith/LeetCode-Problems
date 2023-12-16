package Blind75.String;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Using Sliding window technique, while checking
    // curWindowLen - count[charC] > k or not, if so left+1
    // Runtime  : 29ms        -> + 22.64%
    // Memory   : 43.16MB     -> + 34.40%
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;

        int left = 0, right = 0;
        int maxFreq = 0;
        for(; right<s.length(); right++) {
            map.computeIfPresent(s.charAt(right), (key,val) -> val+1);
            map.computeIfAbsent(s.charAt(right), val -> 1);

            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));
            int curLen = right-left+1;

            if(curLen - maxFreq > k) {
                map.computeIfPresent(s.charAt(left), (key,val) -> val-1);
                left += 1;
            }
            res = Math.max(res,  right-left+1);
        }

        return res;
    }
    // ***************** End of 1st Method ******************

}
