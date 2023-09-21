package MostAsked100Q;

import java.io.PrintStream;
import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "SEE";

        char[][] board = {{'a','a','b','a','a','b'},{'a','a','b','b','b','a'}
                ,{'a','a','a','a','b','a'},{'b','a','b','b','a','b'}
                ,{'a','b','b','a','b','a'},{'b','a','a','a','a','b'}};
        String word = "bbbaabbbbbab";

        printBoard(board);
        System.out.println(exist(board, word));
//        System.out.println(board.length + " : " + board[0].length);
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Dept-First Search Approach
    // Initialize a flag variable to keep track of whether the word has been found.
    // Create a boolean array to keep track of which cells have already been visited.
    // Iterate over the board, checking each cell to see if it is the first letter of the word.
    // If it is, call the helper function to recursively search for the rest of the word, starting at that cell.
    // If the flag variable is set to true, the word has been found and the function can return true.
    // If the word has not been found after iterating over the entire board, return false.
    // Runtime  : 136ms           -> + 82.12%
    // Memory   : 39.99 MB      -> + 99.52%
    static boolean flag;
    public static boolean exist(char[][] board, String word) {
       flag = false;
       boolean[][] check = new boolean[board.length][board[0].length];

       for(int i=0; i<board.length; i++) {
           for(int j=0; j<board[i].length; j++) {
               helper(board, word, check,i,j,0);
               if(flag) return true;
           }
       }
       return false;
    }
    private static void helper(char[][] board, String word, boolean[][] check, int col, int row, int wordPos) {
        if(row < 0 || row >= board[0].length || col < 0 || col >= board.length) {
            return;
        }

        if(board[col][row] != word.charAt(wordPos) || check[col][row]) {
            return;
        }

        // marked as visited
        check[col][row] = true;

        if (wordPos == word.length() - 1) {
            flag = true;
            return;
        }

        helper(board,word,check, col,row-1,wordPos+1); // left
        helper(board,word,check, col,row+1,wordPos+1); // right
        helper(board,word,check, col-1,row,wordPos+1); // up
        helper(board,word,check, col+1,row,wordPos+1); // down

        // backtrack
        check[col][row] = false;
    }
    // ***************** End of 1st Method ******************

    // Print Array in Matrix Form
    private static void printBoard(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
