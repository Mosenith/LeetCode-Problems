import java.util.*;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
//        String s = "rabbbit", t = "rabbit";

//        System.out.println(t.substring(3));
//        System.out.println(t.substring(3).length());
        System.out.println(numDistinct2(s,t));
    }

    // ***************** 1st Method ******************
    // Approach : Correct Approach but exceed time limit on LeetCode
    // Runtime  : 8ms        -> + 31.49%
    // Memory   : 39.28 MB    -> + 46.58%
    // Time Complexity: O(nlogn), worst-case=O(n^2), Space Complexity: O(n)
    static int numDis;
    public static int numDistinct(String s, String t) {
        numDis = 0;
        helper(s,t,0,0);

        return numDis;
    }

    private static void helper(String s, String t, int sIndex, int tIndex) {
        if(sIndex > s.length() - t.length() && tIndex == 0) {
            return;
        }
//        System.out.println(sIndex + " -> " + s.charAt(sIndex));
//        System.out.println(tIndex + " -> " + t.charAt(tIndex));


        for(int i=sIndex, j=tIndex; i<s.length() && j<t.length(); i++) {
            System.out.println(i + " : " + j);
            if(s.charAt(i) == t.charAt(j) && tIndex == t.length() -1) {
                System.out.println("Match!!!");
//                tIndex = 0;
                numDis++;
            }
            if(s.charAt(i) == t.charAt(tIndex) && j < t.length()-1) {
                helper(s,t,i+1,j+1);
            }
            System.out.println("~~~~");
        }
        System.out.println("****************");
    }
    // ***************** End of 1st Method ******************

    // ***************** 1st Method ******************
    // Approach : Optimized above method using DP
    // Use 2D array -> col = t.len+1, row = s.len+1
    // Nest Loop start with i,j=1, then compare each char with i-1 & j-1
    // Runtime  : 16ms        -> + 59.19%
    // Memory   : 46.92 MB    -> + 56.95%
    public static int numDistinct2(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // Initialize the first row with 1's
        // because an empty string is a subsequence of any string.
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    // include both s & t to dp => dp[i - 1][j - 1]
                    // and exclude the current character from s
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    // don't match -> exclude
                    dp[i][j] = dp[i][j - 1];
                }
            }
            System.out.println(Arrays.deepToString(dp));
            System.out.println("****************");
        }

        return dp[t.length()][s.length()];
    }
}
