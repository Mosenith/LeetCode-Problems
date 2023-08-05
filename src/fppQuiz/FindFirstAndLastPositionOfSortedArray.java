package fppQuiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 34. Find First and Last Position of Element in Sorted Array
public class FindFirstAndLastPositionOfSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        // ***************** 1st Method ******************
        // Runtime  : 1ms        -> + 25.14%
        // Memory   : 45.2 MB      -> + 97.31%
        //check conditions
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length-1])
            return new int[]{-1, -1};

        List<Integer> outList = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid - 1;
                right = mid + 1;
                outList.add(mid);
                // check Left
                while(left >= 0 && nums[left] == target) {
                    left--;
                }
                // check Right
                while(right <= nums.length-1 && nums[right] == target) {
                    outList.add(right++);
                }
                break;
            }
        }

        // target = nums[left]
        if(outList.isEmpty())
            return new int[]{-1, -1};

        Collections.sort(outList);
        return new int[]{outList.get(0), outList.get(outList.size()-1)};
    }
    //  ***************** End of 1st Method ******************


    // ***************** 2nd Method ******************
    //    In this implementation, we use binary search to find the first position of the target element
    //    and the last position of the target element. We initialize the result array to [-1, -1],
    //    which represents that the target element is not found in the array. If the input array is empty or null,
    //    we immediately return this result.

    //    We use binary search twice to find the first and last position of the target element.
    //    The first binary search finds the first position, and the second binary search finds the last position.
    //    In each binary search, we use a different calculation for the midpoint of the search interval
    //    to ensure that we find the first position or the last position.

    // Runtime  : 0ms        -> + 100%
    // Memory   : 45.9MB      -> + 29.68%
    public static int[] searchRange2(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println("Left = " + left);

        if (nums[left] != target) {
            return result;
        }
        result[0] = left;

        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            System.out.println("mid" + mid);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        result[1] = right;

        return result;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 45.4 MB      -> + 84.99%
    public static int[] searchRange3(int[] nums, int target) {
        int l = search(nums, target);
        System.out.println("*********");
        int r = search(nums, target + 1);
        return l == r ? new int[] {-1, -1} : new int[] {l, r - 1};
    }

    private static int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            // By using the unsigned shift, it avoids overflows which result in a negative number.
            System.out.println("Previous -> right = " + right + ", left = " + left);
            int mid = (left + right) >>> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
            System.out.println("right = " + right + ", left = " + left);
        }
        return left;
    }
    //  ***************** End of 3rd Method ******************

    public static void main(String[] args) {
//        int[] nums = {5,7,7,7,8,8,10};
//        int target = 7;

        int[] nums = {3,3,3};
        int target = 3;

        int[] ans = searchRange3(nums,target);
        System.out.println("Final: " + Arrays.toString(ans));

    }
}
