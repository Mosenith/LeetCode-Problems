package MostAsked100Q;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 2;

        System.out.println(uniquePaths(10,10));
        System.out.println(uniquePaths4(10,10));

    }

    // ***************** 1st Method ******************
    // Approach : grid[0][j] & grid[i][0] are all 1 -
    // cos there's only 1 path to get there, either straight right or down
    // KEY==> grid[i][j] = grid[i][j-1] + grid[i-1][j] (start from index 1)
    // Runtime  : 0ms        -> + 100.00%
    // Memory   : 39.14 MB    -> + 75.67%
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        // make column grid[0][j] = 1;
        for(int i=0; i<n; i++) {
            grid[0][i] = 1;
        }

        // make row grid[i][0] = 1;
        for(int i=0; i<m; i++) {
            grid[i][0] = 1;
        }

        // cal grid[i][j] = grid[i][j-1] + grid[i-1][j]
        // start from i=1
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }

        return grid[m-1][n-1];
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method : Best Method ******************
    // Approach : Recursive - BruteForce
    // Runtime  : Time Limit Exceeded
    // Memory   : ---
    public static int uniquePaths2(int m, int n) {
        return helper(m,n,0,0);
    }

    private static int helper(int m, int n, int i, int j) {
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;

        return helper(m, n, i+1, j) + helper(m, n, i, j+1);
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method : DP-Memoization ******************
    // Approach : Using DP - Time & Space Complexity = O(m*n)
    // Runtime  : Time Limit Exceeded
    // Memory   : ---
    static int[][] dp;
    public static int uniquePaths3(int m, int n) {
        dp = new int[m][n];

        System.out.println(Arrays.deepToString(dp));

        dpHelper(m,n,0,0);
        return dp[m-1][n-1];
    }

    private static void dpHelper(int m, int n, int i, int j) {
        if(i >= m || j >= n) return;
        if(i == m-1 && j == n-1) {
            dp[i][j] += 1;
            return;
        }

//        System.out.println(i + " : "  + j);
        if(dp[i][j] != 0) {
            return;
        }
        dpHelper(m,n,i+1,j);
        dpHelper(m,n,i,j+1);

//        System.out.println("Final: " + Arrays.deepToString(dp));
    }
    // ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    // Approach : Use math combinatorics formula
    // We need to choose m-1 down moves and n-1 right moves out of (m+n-2) total moves
    // (m+n-2)C(m-1) = (m+n-2)C(n-1)
    // Runtime  : 0ms        -> + 100.00%
    // Memory   : 39.78 MB    -> + 14.02%
    public static int uniquePaths4(int m, int n) {
        long ans = 1;

        for(int i = m+n-2, j = 1; i >= Math.max(m, n); i--, j++) {
            ans = (ans * i) / j;
        }

        return (int) ans;
    }
}
