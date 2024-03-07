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
}
