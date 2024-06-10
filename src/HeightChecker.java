import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};

        System.out.println(heightChecker(heights));
    }

    // ***************** 1st Method ******************
    // Approach 1: Copy the array and sort it
    // Compare the sorted array with the original array
    // Increment cnt if the element is not equal
    // Runtime  : 2ms     -> + 88.93%
    // Memory   : 41.03MB -> + 80.38%
    public static int heightChecker(int[] heights) {
        int cnt = 0;
        int[] expected = Arrays.copyOf(heights,heights.length);
        Arrays.sort(expected);

        for(int i=0; i<heights.length; i++) {
            if(heights[i] != expected[i]) {
                cnt++;
            }
        }
        return cnt;
    }
    // ***************** End of 1st Method ******************

}
