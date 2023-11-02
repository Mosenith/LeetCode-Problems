import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        //
        char[][] board = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'},
                {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        System.out.println(board.length);
        System.out.println(board[0].length);

        System.out.println("=== Matrix ===");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
     }

    public List<String> findWords(char[][] board, String[] words) {


        return null;
    }
}
