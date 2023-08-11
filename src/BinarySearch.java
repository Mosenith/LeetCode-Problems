import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.println(search(nums, target));
    }

    // ***************** 1st Method ******************
    // Approach : Use helper() with start = 0, end = arr.length
    // mid = (start+end-1)/2 vs target, if arr[mid] = target => return mid
    // arr[mid] < target, go right, otherwise go left
    // Runtime  : 0ms        -> + 100%
    // Memory   : 44.27 MB      -> + 95.25%
    public static int search(int[] nums, int target) {
        Arrays.sort(nums);

        return helper(nums, 0, nums.length, target);
    }

    private static int helper(int[] nums, int start, int end, int target) {
        if(start < 0 || start >= end) {
            return -1;
        }

        int mid = (start + end -1) / 2;

        if(nums[mid] == target) {
            // ans = mid;
            return mid;
        }

        if(nums[mid] > target) {
            // go left
            return helper(nums, start, mid, target);
        } else {
            // go right
            return helper(nums, mid+1, end, target);
        }
    }
    //  ***************** End of 1st Method ******************
}
