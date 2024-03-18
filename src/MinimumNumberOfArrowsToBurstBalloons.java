import java.util.Arrays;

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

    // Sort 2D array based on the arr[][1]
    // Cur end=arr[i][0], then check if arr[i][1] is within the arr[i+1][0],
    // if so end=arr[i+1][1], if not shot++.
    // [[1,6],[2,8],[7,12],[10,16]]
    public static int findMinArrowShots(int[][] points) {


        System.out.println(Arrays.deepToString(points));
        return 0;
    }
}
