package MostAsked100Q;

import java.util.Arrays;

public class UniquePathII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

//        int[][] obstacleGrid = {
//                {0,0},
//                {1,1},
//                {0,0}
//        };

        System.out.println(Arrays.deepToString(obstacleGrid));
//        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));

    }
    // ***************** 1st Method ******************
    // Approach : grid[0][j] & grid[i][0] are all 1 -
    // cos there's only 1 path to get there, either straight right or down
    // KEY==> grid[i][j] = grid[i][j-1] + grid[i-1][j] (start from index 1)
    // Only need to consider if there's obstacle.
    // Runtime  : 1ms        -> + 16.89%
    // Memory   : 40.13 MB    -> + 97.87%
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if(obstacleGrid[row-1][col-1] == 1 || obstacleGrid[0][0] == 1)
            return 0;

        // replace obstacle:1 with -1
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        // set 0th row to 1
        for(int i=0; i<col; i++) {
            if(obstacleGrid[0][i] != -1) {
                obstacleGrid[0][i] = 1;
            }
        }

        // set 0th col to 1
        for(int i=0; i<row; i++) {
            if(obstacleGrid[i][0] != -1) {
                obstacleGrid[i][0] = 1;
            } else {
                break;
            }
        }

        // cal every other matrix
        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if(obstacleGrid[i][j] != -1) {
                    int a = (obstacleGrid[i-1][j] != -1) ? obstacleGrid[i-1][j] : 0;
                    int b = (obstacleGrid[i][j-1] != -1) ? obstacleGrid[i][j-1] : 0;
                    obstacleGrid[i][j] = a + b;
                }
            }
        }

        return obstacleGrid[row-1][col-1];
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method : Best Method ******************
    // Approach : Optimized of the first method - copy original arr to another one
    // Runtime  : 1ms        -> + 16.89%
    // Memory   : 40.13 MB    -> + 97.87%
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    // ***************** End of 2nd Method ******************
}
