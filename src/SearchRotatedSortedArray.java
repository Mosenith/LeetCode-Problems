import java.util.Arrays;
import java.util.stream.Stream;

public class SearchRotatedSortedArray {
    // ***************** 1st Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.7MB      -> + 80.81%%
    // Use Binary Search Algorithms
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length-1;

        // get the index 0 of normal sorted array
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int start = low;
        if(nums[start] == target)
            return start;

        // Start Binary Search
        low = 0;
        high = nums.length - 1;
        if(target >= nums[start] && target <= nums[high]) {
            low = start;
        } else {
            high = start - 1;
        }
        while(low < high) {
            int midPoint = low + (high - low) / 2;
            if(target > nums[midPoint]) {
                low = midPoint + 1;
            } else {
                high = midPoint;
            }
        }

        return (nums[low] == target) ? low : -1;
    }
//  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.7MB      -> + 80.81%%
    public static int search2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
//  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {1,2,4,5,6,7,0};
        int target = 3;

        System.out.println(search(nums,target));

    }
}
