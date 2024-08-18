import java.util.Arrays;

public class MaximumNumberOfPointsWithCost {
    public static void main(String[] args) {
        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};

        System.out.println(maxPoints(points));
        System.out.println(maxPoints2(points));
    }

    // ***************** 1st Method ******************
    // Approach 1: Loop through the points array and store the max value in a new array
    // Loop through the points array and store the max value in a new array
    // Runtime  : 7ms      -> + 75.42%
    // Memory   : 79.38MB  -> + 65.36%
    public static long maxPoints(int[][] points) {
        int n = points[0].length;
        long[] f = new long[n];
        final long inf = 1L << 60;

        for (int[] p : points) {
            long[] g = new long[n];
            long lmx = -inf, rmx = -inf;
            for (int j = 0; j < n; ++j) {
                lmx = Math.max(lmx, f[j] + j);
                g[j] = Math.max(g[j], p[j] + lmx - j);
            }
            for (int j = n - 1; j >= 0; --j) {
                rmx = Math.max(rmx, f[j] - j);
                g[j] = Math.max(g[j], p[j] + rmx + j);
            }
            f = g;
        }

        long ans = 0;
        for (long x : f) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar to 1st method but more detailed
    // Runtime  : 13ms     -> + 24.58%
    // Memory   : 84.80MB  -> + 29.05%
    public static long maxPoints2(int[][] points) {
        int col = points[0].length;
        int row = points.length;
        long[] dp = new long[col];

        int k=0;
        for(int num : points[0]) {
            dp[k++] = num;
        }

        for(int i=1; i<row; i++) {
            long[] temp = dp.clone();

            long leftMax = 0;
            for(int j=0; j<col; j++) {
                long max = Math.max(temp[j], leftMax-1);
                long res = max + points[i][j];
                leftMax = max;
                temp[j] = res;
            }

            long rightMax = 0;
            for(int j=col-1; j>=0; j--) {
                long max = Math.max(dp[j], rightMax-1);
                long res = max + points[i][j];
                rightMax = max;
                dp[j] = Math.max(res, temp[j]);
            }
        }

        long maxPoints = 0;
        for(long num : dp) {
            maxPoints = Math.max(maxPoints, num);
        }
        return maxPoints;
    }
    //  ***************** End of 1st Method ******************
}
