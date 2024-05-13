public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,1},
            {1,0,1,0},
            {1,1,0,0}
        };

        System.out.println(matrixScore(grid));
    }

    // in each row, grid[0][i] = 0, flip row
    // in each col, if number of 0s > number of 1s, flip col

    public static int matrixScore(int[][] grid) {

        for(int i=0; i<grid.length; i++) {
            // for row
            int rowZero = countRowZero(grid, i, 0);
            int colZero = countColZero(grid, 0, i);

            System.out.println(rowZero + " " + colZero);
            System.out.println("*****\n");
        }

        return 0;
    }

    private static int countColZero(int[][] grid, int start, int col) {
        int count = 0;
        for(int i=start; i<grid.length; i++) {
            if(grid[i][col] == 0) {
                count++;
            }
        }
        return count;
    }

    private static int countRowZero(int[][] grid, int row, int start) {
        int count = 0;
        for(int i=start; i<grid[row].length; i++) {
            if(grid[row][i] == 0) {
                count++;
            }
        }
        return count;
    }
}
