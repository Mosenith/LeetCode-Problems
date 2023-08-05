import java.util.ArrayList;
import java.util.List;

public class SudokuSolver3 {
    // ***************** 3rd Method ******************
    // Runtime  : 8ms        -> + 75.51%
    // Memory   : 39.4MB      -> + 98.50%
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


        System.out.println("****************After****************");

        // after
        solveSudoku(board);
    }

    // print board
    private static void printBoard(char[][] board) {
        for(int i=0; i<9; i++) {
            if(i%3==0 && i!=0)
                System.out.println("-----------");
            for(int j=0; j<9; j++) {
                if(j%3==0 && j!=0)
                    System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    private static boolean isSafe(char[][] board,int i,int j,int c){
        // check if value to insert c existed in row or column
        for (int p = 0; p < 9; p++) {
            if(board[p][j]==c)
                return false;
            if(board[i][p]==c)
                return false;
        }

        // check if value to insert c existed in 3x3 sub
        int row = i-i%3;
        int col = j-j%3;
        for(int p = row;p<row+3;p++){
            for(int q = col;q<col+3;q++){
                if(board[p][q] == c){
                    return false;
                }
            }
        }

        // if rows, columns, 3x3 sub, don't have c, return true
        return true;
    }
    public static boolean dfs(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isSafe(board,i,j,k)){
                            board[i][j] = k;
                            if(dfs(board))
                                return true;
                            else
                                board[i][j]='.';
                        }

                    }
                    // this is bcoz we are unable to generate a valid sudoko with all the possible explorations.
                    return false;
                }
            }
        }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        if(board.length==0) {
            return;
        }
        dfs(board);
        printBoard(board);
    }
}
