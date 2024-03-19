import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };

        int[][] points2 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };

        System.out.println(findMinArrowShots(points));
    }
    // [[1,2],[2,3],[3,4],[4,5]]
    // [[1,6],[2,8],[7,12],[10,16]]


    // ***************** 1st Method ******************
    // Approach 1: Sort 2D array based on the arr[][1]
    // Init curEnd=arr[0][1], then check if arr[i][0]>curEnd, update curEnd=arr[i][1]
    // Then increment shot++
    // Runtime  : 57ms         -> + 34.97%
    // Memory   : 68.67MB      -> + 77.08%
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // Sorting based on the second column (index 1)
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int curEnd = points[0][1];
        int shots = 1;
        for(int i=1; i<points.length; i++) {
            if (points[i][0] > curEnd) {
                shots++;
                curEnd = points[i][1];
            }
        }
        return shots;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar approach to the 1st
    // Runtime  : 57ms         -> + 34.97%
    // Memory   : 68.67MB      -> + 77.08%
    public static int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        long last = -(1L << 60); // As small as possible
        for (var p : points) {
            int a = p[0], b = p[1];
            if (a > last) {
                ++ans;
                last = b;
            }
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************

}
