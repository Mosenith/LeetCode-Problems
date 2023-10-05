package MostAsked100Q;

import java.util.*;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] b = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        solve2(b);
        System.out.println(Arrays.deepToString(b));
//        System.out.println("Col = " + board.length);
//        System.out.println("Row = " + board[0].length);
    }
    // ***************** 1st Method ******************
    // Approach 1: 3 Main steps to consider
    // 1. Capture un-surrounded region : O -> T
    // 2. Capture surrounded region : O -> X
    // 3. Un-capture un-surrounded region : T -> O
    // Runtime  : 2ms           -> + 79.60%
    // Memory   : 43.7 MB      -> + 84.81%
    public static void solve2(char[][] board) {
        int row = board.length, col = board[0].length;

        // Step 1
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j] == 'O'
                        && (i == 0 || i == row-1)
                        || (j == 0 || j == col-1) ) {
                    helper(i, j, board);    // Step 1
                }
            }
        }

        System.out.println("Current Board");
        System.out.println(Arrays.deepToString(board));
        System.out.println("******************");

        // Step 2
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        System.out.println("Current Board");
        System.out.println(Arrays.deepToString(board));
        System.out.println("******************");

        // Step 3
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }

        System.out.println("Current Board");
        System.out.println(Arrays.deepToString(board));
        System.out.println("******************");
    }

    private static void helper(int row, int col, char[][] board) {
        if(row < 0 || col < 0 || row == board.length || col == board[0].length
                || board[row][col] != 'O')
            return;

        // Change O to T
        board[row][col] = 'T';

        helper(row+1, col, board);  // check upper
        helper(row-1, col, board);  // check lower
        helper(row, col+1, board);  // check righty
        helper(row, col-1, board);  // check lefty
    }
    // ***************** End of 1st Method ******************
}
