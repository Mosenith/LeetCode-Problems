public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        System.out.println(minFallingPathSum(matrix));
    }

    // straight below row : i+1 & j, i<matrix.length
    // diagonally : i+1, j-1/j+1
    public static int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        var f = new int[len];

        for(var row : matrix) {
            System.out.println(row);
        }

        return 0;
    }
}
