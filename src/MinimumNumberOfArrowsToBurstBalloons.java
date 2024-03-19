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

        System.out.println(findMinArrowShots(points));
    }
// [[1,2],[2,3],[3,4],[4,5]]

    // Sort 2D array based on the arr[][1]
    // Cur end=arr[i][0], then check if arr[i][1] is within the arr[i+1][0],
    // if so end=arr[i+1][1], if not shot++.
    // [[1,6],[2,8],[7,12],[10,16]]
    public static int findMinArrowShots(int[][] points) {
        int shots = 0;
        // Sorting based on the second column (index 1)
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        System.out.println(Arrays.deepToString(points));

        int curEnd = points[0][1];
        for(int i=1; i<points.length; i++) {
            if(points[i][0] < curEnd) {

            }
        }

        return shots;
    }
}
