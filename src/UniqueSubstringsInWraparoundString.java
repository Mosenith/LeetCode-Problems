import java.util.Arrays;

public class UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        String s = "abaab";

        System.out.println(findSubstringInWraproundString(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use an array size of 26 keep track of the maximum length of
    // substring ending at each character. Init k=,
    // which represents the length of the current increasing substring
    // If i > 0 and the difference between the ASCII values of c
    // and the previous character (s.charAt(i - 1)) is 1 (modulo 26),
    // it means c is the next character in the wraparound string, so k is incremented.
    // Otherwise, k is reset to 1.
    // The length of the substring ending at character c is updated in the dp array.
    // Runtime  : 8ms           -> + 89.07%
    // Memory   : 43.07MB       -> + 93.99%
    public static int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i > 0 && (c - s.charAt(i - 1) + 26) % 26 == 1) {
                ++k;
            } else {
                k = 1;
            }
            dp[c - 'a'] = Math.max(dp[c - 'a'], k);
        }

        int ans = 0;
        for (int v : dp) {
            ans += v;
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Init prev='`' (backtick) to represent the character
    // before the first character of the input string. This is used to
    // compare whether the current character c` is the next character in the wraparound string.
    // Init len = 0 the length of the current increasing substring
    // If c is the next character in the wraparound string
    // (i.e., it follows prev in alphabetical order, considering wraparound),
    // len is incremented. Otherwise, len is reset to 1.
    // The length of the substring ending at character c is updated in the maxLen array
    // Runtime  : 4ms           -> + 99.45%
    // Memory   : 44.30MB       -> + 31.69%
    public static int findSubstringInWraproundString2(String s) {
        int[] maxLen = new int[26];
        char prev = '`';
        int len = 0;

        for(char c: s.toCharArray()){
            if((char)(prev + 1) == c || (prev == 'z' && c == 'a')){
                len++;
            }else{
                len = 1;
            }
            maxLen[c - 'a'] = Math.max(len, maxLen[c - 'a']);
            prev = c;
        }

        int ans = 0;
        for(int i: maxLen) ans += i;

        return ans;
    }
    //  ***************** End of 2nd Method ******************
}
