import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
//        String t1 = "ezupkr", t2 = "ubmrapg";
        String t1 = "aggtab", t2 = "gxtxayb";

        System.out.println(longestCommonSubsequence(t1,t2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use DP storing memoize in f[t1.len+1][t2.len+1]
    // If characters match, take the value from the diagonal cell and increment by 1
    // f[i][j] = f[i - 1][j - 1] + 1;
    // If characters do not match, take the maximum of the cell above and the cell to the left
    // f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
    // Runtime  : 20ms         -> + 82.44%
    // Memory   : 50.92MB      -> + 26.88%
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // If characters match, take the value from the diagonal cell and increment by 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    // If characters do not match, take the maximum of the cell above and the cell to the left
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        // The value in the bottom-right cell represents the length of the longest common subsequence
        return f[m][n];
    }
    //  ***************** End of 1st Method ******************

}
