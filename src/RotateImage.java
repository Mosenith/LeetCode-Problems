import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateImage {
    // ***************** 1st Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 42.7MB      -> + 17.75%
    //    private static int[] getIndex = {0,0};
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len == 1) return;

        boolean[][] check = new boolean[len][len];

        int i = 0, j = 0;
        int val = matrix[i][j]; // 1

        while(!checkAvailable(check,len) && j < len) {

            System.out.println("i = " + i + ", j = " + j);

            int nextI = j;
            int nextJ = len - i - 1;

            int nextVal = matrix[nextI][nextJ];
            matrix[nextI][nextJ] = val;
            // change value of check
            check[i][j] = true;

            while(check[nextI][nextJ]) {
                System.out.println("check = " + check[nextI][nextJ]);
                System.out.println("nextI = " + nextI + ", nextJ = " + nextJ + ", val = " + val);
                if(nextJ == len - 1) {
                    nextI++;
                    nextJ = 0;
                }
                nextJ++;
                nextVal = matrix[nextI][nextJ];
                System.out.println("++++++++++++++");
                if(checkAvailable(check,len))
                    break;
            }

            val = nextVal;

            i = nextI;
            j = nextJ;

            System.out.println("nextI = " + nextI + ", nextJ = " + nextJ + ", val = " + val);
            System.out.println(Arrays.deepToString(matrix));
            System.out.println(Arrays.deepToString(check));
            System.out.println("************************************");
        }
    }

    private static boolean checkAvailable(boolean[][] check, int len) {
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(!check[i][j])
                    return false;
            }
        }
        return true;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 42.7MB      -> + 17.75%
    // Similar approach as above but multiple element each iteration
    public static void rotate2(int[][] matrix) {
        int s = 0, n = matrix.length;
        while (s < (n >> 1)) {
            int e = n - s - 1;

            System.out.println("************ s = " + s + ", e = " + e + " ************");
            for (int i = s; i < e; ++i) {
                int t = matrix[i][e];
                System.out.println("i = " + i + ", n - i - 1 = " + (n - i - 1));
//                System.out.println("matrix[i][e] = " + matrix[i][e] + ", matrix[s][i] = " +  matrix[s][i]);
//                System.out.println("matrix[n - i - 1][s] = " + matrix[n - i - 1][s]);
//                System.out.println("matrix[e][n - i - 1] = " + matrix[e][n - i - 1]);
                matrix[i][e] = matrix[s][i];
                matrix[s][i] = matrix[n - i - 1][s];
                matrix[n - i - 1][s] = matrix[e][n - i - 1];
                matrix[e][n - i - 1] = t;
            }
            System.out.println("**************************************");
            ++s;
        }

    }
    //  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                         {4,5,6},
                        {7,8,9}};

//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

//        int[][] matrix = {{1,2},{3,4}};

//        int[][] matrix = {{1}};

        System.out.println(Arrays.deepToString(matrix));
        rotate2(matrix);
        System.out.println("Final Result :\n"+ Arrays.deepToString(matrix));
    }
}
