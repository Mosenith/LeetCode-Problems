import java.util.Map;

public class SearchInsertPosition {

    // ***************** 1st Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.8 MB      -> + 75.81%
    public static int searchInsert(int[] nums, int target) {
        if(target < nums[0])
            return 0;
        else if(target > nums[nums.length-1])
            return nums.length;

        int left = 0;
        int right = nums.length;

        while(left < right) {
            int mid = (left+right) >>> 1;
            System.out.println("Left = " + left + ", Right = " + right);
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

            System.out.println("Left = " + left + ", Right = " + right);
            System.out.println("******************");
            if(Math.abs(right-left) == 1 && nums[left] < target && nums[right] > target) {
                left = left + 1;
                break;
            }
        }
        return left;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    //    This implementation uses binary search to find the position of the target element in the array nums.
    //    If the target element is found in the array, the index of that element is returned.
    //    If the target element is not found in the array, the value of left is returned,
    //    which is the index where the target element should be inserted in order to maintain the sorted order of the array.

    // Runtime  : 0ms        -> + 100%
    // Memory   : 42.2 MB      -> + 24.94%
    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method (Optimize 2nd Method) ******************
    //  In this optimized solution, we have changed the condition in the while loop to left < right instead of left <= right.
    //  This is because we want to find the rightmost index right such that nums[right] < target.
    //  The final step is to return left + 1 if nums[left] < target or left otherwise,
    //  depending on whether the target should be inserted at the end of the array or not.

    // Runtime  : 0ms        -> + 100%
    // Memory   : 42 MB      -> + 44.20%
    public static int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("Left = " + left + ", Right = " + right);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("Left = " + left + ", Right = " + right);
            System.out.println("******************");
        }
        // left + 1 : when target > nums[len-1]
        return (nums[left] < target) ? left + 1 : left;
    }
    //  ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    public static int searchInsert4(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    //  ***************** End of 4th Method ******************

    public static void main(String[] args) {
        int[] nums = {5,7,8,10,14};
        int target = 11;

        System.out.println(searchInsert3(nums,16));
    }
}
