import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
//        String t1 = "ezupkr", t2 = "ubmrapg";
        String t1 = "aggtab", t2 = "gxtxayb";

        System.out.println(longestCommonSubsequence(t1,t2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    System.out.println("Equal at i-" + i + ", j-" + j);
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }

            System.out.println(Arrays.deepToString(f));
        }
        return f[m][n];
    }

    // abgt
}
