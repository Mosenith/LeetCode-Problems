import java.util.*;

public class MagicSquaresInGrid {
    public static void main(String[] args) {
        int[][] grid = {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}};

        System.out.println(numMagicSquaresInside(grid));
    }

    // ***************** 1st Method ******************
    // Approach 1: Loop through the grid and check if the current cell can form a magic square
    // Check if the current cell can form a 3x3 grid
    // Check if the current cell is unique and within the range of 1-9
    // Check if the current cell is unique in the row and column
    // Check if the sum of the row, column, and diagonal is the same
    // Store each diagonal in a list by using the current cell as the starting point
    // Runtime  : 1ms      -> + 41.36%
    // Memory   : 41.82MB  -> + 13.09%
    static int row;
    static int col;
    public static int numMagicSquaresInside(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                count += checkMagicSquares(grid,i,j);
            }
        }
        return count;
    }

    private static int checkMagicSquares(int[][] grid, int r, int c) {
        if(r+3 > row || c+3 > col) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> d1 = new ArrayList<>();
        int d11 = r, d12 = c; // 10, 21, 32
        List<Integer> d2 = new ArrayList<>();
        int d21 = r, d22 = c+3-1; // 12, 21, 30
        int sum = 0;

        for(int i=r; i<r+3; i++) {
            int curSum = 0;
            for(int j=c; j<c+3; j++) {
                if(!set.isEmpty() && set.contains(grid[i][j]) ||
                        grid[i][j] < 1 || grid[i][j] > 9) {
                    return 0;
                }
                if(i == d11 && j == d12) {
                    d1.add(grid[i][j]);
                    d11++;
                    d12++;
                }
                if(i == d21 && j == d22) {
                    d2.add(grid[i][j]);
                    d21++;
                    d22--;
                }
                set.add(grid[i][j]);
                curSum += grid[i][j];
            }
            if(sum == 0) {
                sum = curSum;
            } else if(curSum != sum){
                return 0;
            }
        }

        // check grid[j][i]
        for(int j=c; j<c+3; j++) {
            int curSum = 0;
            for(int i=r; i<r+3; i++) {
                curSum += grid[i][j];
            }
            if(curSum != sum) {
                return 0;
            }
        }

        int s1 = 0;
        int s2 = 0;
        for(int i=0; i<3; i++) {
            s1 += d1.get(i);
            s2 += d2.get(i);
        }

        if(s1 == s2 && s1 == sum) {
            return 1;
        }
        return 0;
    }
    //  ***************** End of 1st Method ******************
}
