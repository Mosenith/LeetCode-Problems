import java.util.Arrays;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,1},
            {1,0,1,0},
            {1,1,0,0}
        };

        System.out.println(matrixScore2(grid));
    }

    // in each row, grid[0][i] = 0, flip row
    // in each col, if number of 0s > number of 1s, flip col

    // ***************** 1st Method ******************
    // Approach 1: Flip row if grid[i][0] = 0
    // Flip col if number of 0s > number of 1s
    // Calculate the sum of each row
    // Runtime  : 2ms     -> + 8.18%
    // Memory   : 41.34MB -> + 44.85%
    public static int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i<col; i++) {
            // for row
            if(grid[i][0] == 0) {
                grid[i][0] = 1;
                for(int j = 1; j<row; j++) {
                    grid[i][j] = (grid[i][j] == 0) ? 1 : 0;
                }
            }
        }

        for(int i=0; i<row; i++) {
            // check col
            int[] tmpCol = new int[col];
            int zero = 0;
            for(int j = 0; j< col; j++) {
                tmpCol[j] = (grid[j][i] == 0) ? 1 : 0;
                zero = (grid[j][i] == 0) ? zero+1 : zero;
            }
            if(zero > col /2) {
                for(int j = 0; j< col; j++) {
                    grid[j][i] = tmpCol[j];
                }
            }
        }

        int ans = 0;
        for(int i = 0; i< col; i++) {
            ans += binaryArrayToDecimal(grid[i]);
        }

        return ans;
    }

    private static int binaryArrayToDecimal(int[] binaryArray) {
        return Arrays.stream(binaryArray)
                .reduce(0, (acc, bit) -> acc * 2 + bit);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar to the above approach but more optimized
    // Runtime  : 0ms      -> + 100.00%
    // Memory   : 41.73MB  -> + 11.82%
    public static int matrixScore2(int[][] grid) {
        int col=grid.length;
        int row=grid[0].length;

        for(int i=0;i<col;i++){
            if(grid[i][0]==0){
                for(int j=0;j<row;j++){
                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }
            }
        }
        for(int j=1;j<row;j++){
            int nz=0;
            int no=0;
            for(int i=0;i<col;i++){
                if(grid[i][j]==0) nz++;
                else no++;
            }
            if(nz>no){
                //flip
                for(int i=0;i<col;i++){
                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }

            }
        }
        int sum=0;
        for(int i=0;i<col;i++){
            int x=1;
            for(int k=row-1;k>=0;k--){
                sum+=grid[i][k]*x;
                x=x*2; // convert from binary so 2^n
            }

        }
        return sum;
    }
    // ***************** End of 2nd Method ******************
}
