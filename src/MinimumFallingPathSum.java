public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
    }

    // straight below row : i+1 & j, i<matrix.length
    // diagonally : i+1, j-1/j+1
    public int minFallingPathSum(int[][] matrix) {
        int curSum = Integer.MAX_VALUE;

        for(int i=0; i<matrix[0].length; i++) {
            for(int j=i+1; )
        }
    }
}
