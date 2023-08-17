package MostAsked100Q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        // above 1,1 => row--
        // below 1,1 => row++
        // left  1,1 => 1,0 col--
        // right 1,1 => 1,2 col++

        // 0,0 : 0,3
        int[][] matrix2 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        setZeroes2(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    // ***************** 1st Method ******************
    // Approach :
    // Runtime  : 1ms        -> + 80.11%
    // Memory   : 44.89 MB    -> + 23.94%
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean[][] dp = new boolean[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == 0 && !dp[i][j]) {
                    helper(matrix, dp, i, j);
                    dp[i][j] = true;
                }
            }
        }

    }

    private static void helper(int[][] matrix, boolean[][] dp,int row, int col) {
        // set above 0
        for(int i=row-1; i>=0; i--) {
//            System.out.println("Above");
            if(matrix[i][col] != 0) {
                matrix[i][col] = 0;
                dp[i][col] = true;
            }
        }

        // set below 0
        for(int i=row+1; i<matrix.length; i++) {
//            System.out.println("Below");
            if(matrix[i][col] != 0) {
                matrix[i][col] = 0;
                dp[i][col] = true;
            }
        }

        // set left 0
        for(int i=col-1; i>=0; i--) {
//            System.out.println("Left");
            if(matrix[row][i] != 0) {
                matrix[row][i] = 0;
                dp[row][i] = true;
            }
        }

        // set right 0
        for(int i=col+1; i<matrix[row].length; i++) {
//            System.out.println("Right");
            if(matrix[row][i] != 0) {
                matrix[row][i] = 0;
                dp[row][i] = true;
            }
        }
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method : Best Method ******************
    // Approach : Use list to store all 0's rows & columns in pair
    // apply the following logic to the arr[row][col]
    // up => [row-1,col], down => [row+1,col]
    // left => [row,col-1], down => [row,col+1]
    // Runtime  : 1ms         -> + 80.11%
    // Memory   : 44.50 MB    -> + 72.44%
    public static void setZeroes2(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == 0) {
                    ls.add(i);
                    ls.add(j);
                }
            }
        }

        for(int i=0; i<ls.size(); i+=2) {
            adjustZeros(matrix, ls.get(i), ls.get(i+1));
        }

    }
    private static void adjustZeros(int[][] matrix, Integer row, Integer col) {
        // set above 0
        for(int i=row-1; i>=0; i--) {
           matrix[i][col] = 0;
        }

        // set below 0
        for(int i=row+1; i<matrix.length; i++) {
            matrix[i][col] = 0;
        }

        // set left 0
        for(int i=col-1; i>=0; i--) {
            matrix[row][i] = 0;
        }

        // set right 0
        for(int i=col+1; i<matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
    // ***************** End of 2nd Method ******************
}
