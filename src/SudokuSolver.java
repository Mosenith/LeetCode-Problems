//import jdk.dynalink.linker.GuardedInvocation;

import java.util.Arrays;

public class SudokuSolver {
    // ***************** 1st Method ******************
    // Runtime  : 10ms        -> + 65.8%%
    // Memory   : 39.3MB      -> + 98.52%
    private static final int GRID_SIZE = 9;
    public static void main(String[] args) {
                char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        // before
        printBoard(board);

        // after
        System.out.println("****************After****************");

        solveSudoku(board);
    }

    private static void printBoard(char[][] board) {
        for(int i=0; i<GRID_SIZE; i++) {
            if(i%3==0 && i!=0)
                System.out.println("-----------");
            for(int j=0; j<GRID_SIZE; j++) {
                if(j%3==0 && j!=0)
                    System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // check in row
    private static boolean isCharacterInRow(char[][] board, char c, int row) {
        for(int i=0; i<GRID_SIZE; i++) {
            if(board[row][i] == c)
                return true;
        }
        return false;
    }

    // check in column
    private static boolean isCharacterInColumn(char[][] board, char c, int col) {
        for(int i=0; i<GRID_SIZE; i++) {
            if(board[i][col] == c)
                return true;
        }
        return false;
    }

    // check in 3x3 sub
    private static boolean isCharacterInBox(char[][] board, char c, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        for(int i=localBoxRow; i<localBoxRow+3; i++) {
            for(int j=localBoxCol; j<localBoxCol+3; j++) {
                if(board[i][j] == c)
                    return true;
            }
        }
        return false;
    }

    // combine all the check
    private static boolean isValidPlacement(char[][] board, char c, int row, int col) {
        return !isCharacterInRow(board,c,row) &&
                !isCharacterInColumn(board,c,col) &&
                !isCharacterInBox(board,c,row,col);
    }
    public static boolean solveBoard(char[][] board) {
        for(int row=0; row<GRID_SIZE; row++) {
            for(int col=0; col<GRID_SIZE; col++){
                if(board[row][col] == '.') {
                    for(char numberToTry='1'; numberToTry<='9'; numberToTry++) {
                        if(isValidPlacement(board, numberToTry, row, col)) {
                             board[row][col] = numberToTry;

                             if(solveBoard(board))
                                 return true;
                             else
                                 board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveSudoku(char[][] board) {
        if(solveBoard(board))
            board = board;

        printBoard(board);
    }
}
