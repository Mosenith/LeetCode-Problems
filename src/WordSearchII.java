import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        //
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(board.length);
        System.out.println(board[0].length);
//        Arrays.sort(words);
//        System.out.println(Arrays.toString(words));
        System.out.println("======== Matrix ========");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========================");

        System.out.println(findWords(board, words));
    }

    // ***************** 1st Method ******************
    // Approach 1: Work but Exceed Time Limit
    static boolean flag;
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            flag = false;
            boolean[][] check = new boolean[board.length][board[0].length];
            System.out.println(words[i]);
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[j].length; k++) {
                    search(words[i], board, check, j, k, 0);
                }
            }
            if(flag)
                foundWords.add(words[i]);
        }

        return foundWords;
    }

    private static void search(String word, char[][] board, boolean[][] check, int col, int row, int wordPos) {
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

        search(word,board,check,col,row-1,wordPos+1); // left
        search(word,board,check,col,row+1,wordPos+1); // right
        search(word,board,check,col-1,row,wordPos+1); // up
        search(word,board,check,col+1,row,wordPos+1); // down

        // backtrack
        check[col][row] = false;
    }
    // ***************** End of 1st Method ******************

}
