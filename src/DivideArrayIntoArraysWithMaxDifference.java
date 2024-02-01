import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        // [[1,1,3],[3,4,5],[7,8,9]]
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;

        System.out.println(divideArray(nums,k));
    }
    public static int[][] divideArray(int[] nums, int k) {
        int[][] ans = new int[4][3];

        System.out.println(Arrays.deepToString(ans));

        return ans;
    }
}
