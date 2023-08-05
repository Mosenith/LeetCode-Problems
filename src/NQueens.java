import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    // ***************** 2nd Method ******************
    // Runtime  : 3ms        -> + 77.15%
    // Memory   : 42.8MB      -> + 73.2%
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] current = new String[n][n];

        for(int i=0; i<n; i++) {
            String[] tmp = new String[n];
            Arrays.fill(tmp, ".");
            current[i] = tmp;
        }

        System.out.println("Initial State\n" + Arrays.deepToString(current));
//        backtrack(n, current, res);
        System.out.println("*******************************************");

        // Check if the column already have a value
        boolean[] col = new boolean[n];

        // Check if the diagonal already have a value
        boolean[] dg = new boolean[2 * n];

        // Check if the uni-diagonal already have a value
        boolean[] udg = new boolean[2 * n];

        // start searching from the first line
        backtrack(0, n, col, dg, udg, current, res);

        return res;
    }

    private static void backtrack(int column, int n, boolean[] col,
                                  boolean[] dg, boolean[] udg,
                                  String[][] current, List<List<String>> res) {
        if(column == n) {
            List<String> t = new ArrayList<>();
            for (String[] e : current) {
                t.add(String.join("", e));
            }
            res.add(t);
            System.out.println("Added to Res : " + res);
            return;
        }

        for(int i=0; i<n; i++) {
            if (!col[i] && !dg[column + i] && !udg[n - column + i]) {
                current[column][i] = "Q";
                col[i] = dg[column + i] = udg[n - column + i] = true;
                System.out.println("row : " + column + ", i : " + i);
                System.out.println("col : " + Arrays.toString(col));
                System.out.println("dg : " + Arrays.toString(dg));
                System.out.println("udg : " + Arrays.toString(udg));
                System.out.println("++++++++++++++++++++++++++++\n");
                backtrack(column + 1, n, col, dg, udg, current, res);

                current[column][i] = ".";
                col[i] = dg[column + i] = udg[n - column + i] = false;
            } else {
                System.out.println("row : " + column + ", i : " + i);
                System.out.println(col[i] + "-" + dg[column + i] + "-" + udg[n - column + i]);
                System.out.println("++++++++++++++++++++++++++++\n");
            }
        }
        System.out.println("current : " + Arrays.deepToString(current));
        System.out.println("col : " + Arrays.toString(col));
        System.out.println("dg : " + Arrays.toString(dg));
        System.out.println("udg : " + Arrays.toString(udg));
        System.out.println("\n\n***********************************************************************");
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 3ms        -> + 77.15%
    // Memory   : 43MB      -> + 56.33%
    public static List<List<String>> solveNQueensSol2(int n) {
        char board[][] = new char[n][n];
        for(char i[] : board) {
            Arrays.fill(i, '.');
        }

        System.out.println("Initial board :\n" + Arrays.deepToString(board));
        System.out.println("*******************************************\n");

        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }
    public static void dfs(int col, char board[][], List<List<String>> res){
        if(col == board.length){
            res.add(counter(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }
    public static boolean isSafe(char board[][], int row, int col){
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(col >= 0 && row < board.length){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    public static List<String> counter(char board[][]){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;

//        System.out.println("Final Result:\n" + solveNQueens(n));
        System.out.println("\nFinal Result:\n" + solveNQueensSol2(n));
    }
}
