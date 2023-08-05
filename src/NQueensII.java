import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
    // ***************** 1st Method ******************
    // Runtime  : 1ms        -> + 97.8%
    // Memory   : 39.9MB      -> + 36.28%

    static int res = 0;
    public static int totalNQueens(int n) {
        String[][] current = new String[n][n];

        for(int i=0; i<n; i++) {
            String[] temp  = new String[n];
            Arrays.fill(temp, ".");
            current[i] = temp;
        }

        System.out.println("~~~~~ Initial Stage :\n" + Arrays.deepToString(current) + " ~~~~~");

        boolean[] col = new boolean[n];
        boolean[] dg = new boolean[n*2];
        boolean[] udg = new boolean[n*2];

        backtrack(0, n, col, dg, udg, current);

        System.out.println(res);
        return res;
    }

    private static void backtrack(int row, int n, boolean[] col, boolean[] dg,
                                  boolean[] udg, String[][] current) {
        // basic condition
        if(row == n) {
            res += 1;
            System.out.println("****" + res + "****");
            return;
        }

        for(int i=0; i<n; i++) {
            if(!col[i] && !dg[row+i] && !udg[n-row+i]) {
                // set column to 'Q'
                current[row][i] = "Q";
                // set the validation arrays to true
                col[i] = dg[row+i] = udg[n-row+i] = true;
                System.out.println("row : " + row + ", i : " + i);
                System.out.println("col : " + Arrays.toString(col));
                System.out.println("dg : " + Arrays.toString(dg));
                System.out.println("udg : " + Arrays.toString(udg));
                System.out.println("++++++++++++++++++++++++++++\n");

                // backtrack
                backtrack(row + 1, n, col, dg, udg, current);

                // after backtrack remove the 'Q' from current
                current[row][i] = ".";
                // re-set the validation arrays to false
                col[i] = dg[row+i] = udg[n-row+i] = false;
            } else {
                System.out.println("row : " + row + ", i : " + i);
                System.out.println(col[i] + "-" + dg[row + i] + "-" + udg[n - row + i]);
                System.out.println("++++++++++++++++++++++++++++\n");
            }

            System.out.println("col : " + Arrays.toString(col));
            System.out.println("dg : " + Arrays.toString(dg));
            System.out.println("udg : " + Arrays.toString(udg));
            System.out.println("\n\n***********************************************************************");
        }

    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 6ms        -> + 98.9%
    // Memory   : 45.8MB      -> + 48.37%
    public static void main(String[] args) {
        int n = 4;

        System.out.println(totalNQueens(3));
    }
}
