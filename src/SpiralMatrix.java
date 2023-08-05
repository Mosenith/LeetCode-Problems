import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrix {
    // ***************** 1st Method ******************
    // Brutal Force
    // Worked but Takes too long
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length <= 1) {
            return Arrays.stream(matrix)
                    .flatMapToInt(Arrays::stream)
                    .boxed()
                    .collect(Collectors.toList());
        }

        List<Integer> result = new ArrayList<>();
        int totalElements = matrix.length * matrix[0].length;
        int col = 0, row = 0;

        while(result.size() < totalElements) {

            if(row == matrix[col].length-1 && col != matrix.length-1) {
                for(int i=col; i<matrix.length; i++) {
                    result.add(matrix[i][row]);
                }
                System.out.println("1st If : \n" + result);
                col = matrix.length-1;
            }

            if(row == matrix[col].length-1 && col == matrix.length-1) {
                for(int i=matrix[col].length-2; i>=0; i--) {
                    result.add(matrix[col][i]);
                }
                System.out.println("2nd If : \n" + result);
                col--;
                row = 0;
            }

            if(row == 0 && col != matrix.length-1) {
                for(int i=0; i<matrix[col].length-1; i++) {
                    if(!result.contains(matrix[col][i]))
                        result.add(matrix[col][i]);
                }
                System.out.println("3rd If : \n" + result);

                if(col != 0) {
                    row = matrix[col].length-2;
                    col--;
                } else {
                    row = matrix[col].length-1;
                }
            }

            System.out.println("************************************");
        }

        return result;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 2ms        -> + 100%
    // Memory   : 41.1MB      -> + 10.45%
    public static List<Integer> spiralOrder2(int[][] matrix) {
        if(matrix.length <= 1) {
            return Arrays.stream(matrix)
                    .flatMapToInt(Arrays::stream)
                    .boxed()
                    .collect(Collectors.toList());
        }

        List<Integer> result = new ArrayList<>();
        int maxRow = matrix[0].length; // 4
        int maxCol = matrix.length; // 3
        int col = 0, row = 0;

        for(int i=0; i<maxRow * maxCol; i++) {
            System.out.println(matrix[col][row]);
            if(!result.contains(matrix[col][row])) {
                result.add(matrix[col][row]);
            }

            if(row < maxRow-1 && col != maxCol-1) {
                row++;
            } else if(row == maxRow-1 && col < maxCol-1) {
                col++;
            } else if(row != 0 && col == maxCol-1) {
                row--;
            } else { //if(row == 0 && col == maxCol-1) {
                col--;
            }
            System.out.println("Current Result: " + result);
            System.out.println("************************************");
        }

        return result;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // short version of the 2nd Method
    // Runtime  : 2ms        -> + 100%
    // Memory   : 41.1MB      -> + 10.45%
    public List<Integer> spiralOrder3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        int i = 0, j = 0, k = 0;
        List<Integer> ans = new ArrayList<>();
        boolean[][] vis = new boolean[m][n];

        for (int h = m * n; h > 0; --h) {
            ans.add(matrix[i][j]);
            vis[i][j] = true;
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) {
                k = (k + 1) % 4;
            }
            i += dirs[k];
            j += dirs[k + 1];
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

//        int[][] matrix2 = {{1,2},{3,4}};

        for(int i=0; i<matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("************************************");

        System.out.println(spiralOrder2(matrix));

    }
}
