import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(5,6, 1,4)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Loop through the matrix and fill the ans[][] with condition curRow < total(rows*cols)
    // Use direction[]{0,1,0,-1,0} to track the movement of the matrix
    // Use curRow to track the row to fill in ans[][], d to track the direction
    // len to track the steps that can be moved -> 1,1,2,2,3,3,...
    // Update len when d=0 or d=2, then loop from 0 to len and update rStart and cStart
    // rStart increment by direction[d] and cStart increment by direction[d+1]
    // Check if rStart and cStart is within the matrix, if so fill in ans[][]
    // Out of inner loop, update d to d+1 and mod 4 since d is from 0 to 3
    // Runtime  : 5ms      -> + 45.96%
    // Memory   : 45.20MB  -> + 37.67%
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows * cols;
        int[][] ans = new int[total][2];
        ans[0] = new int[] {rStart,cStart};

        if(total == 1) {
            return ans;
        }

        int len = 0;
        int curRow = 1; // track col to fill in ans[][]
        int d = 0; // track direction from 0 to 3
        int[] direction = new int[] {0,1,0,-1,0};
        while(curRow < total) {
            if(d == 0 || d == 2) {
                // when moving to left or right
                len++;
            }
            for(int k=0; k<len; k++) {
                rStart += direction[d];
                cStart += direction[d+1];
                if(rStart < rows && rStart >= 0 && cStart < cols && cStart >= 0) {
                    ans[curRow++] = new int[] {rStart, cStart};
                }
            }
            d = ++d % 4;
        }

        return ans;
    }
    //  ***************** End of 1st Method ******************
}
