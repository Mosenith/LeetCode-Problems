import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};

        System.out.println("len = " + nums.length);
        System.out.println(findShortestSubArray(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init 3 maps, cnt to count all elements in nums and their frequency
    // Another map(left) with key as nums[i] and value is nums[i]'s position from the left
    // Last map(right) with key as nums[i] and value is nums[i]'s position from the right
    // Loop through nums to fill all maps while keeping max degree
    // Loop through nums again and get key that has freq=maxDegree from cnt map
    // Get its distance by using right.get(v) - left.get(v) + 1, also check to get max distance
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.16MB     -> + 72.08%
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>(); // nums[i] and its frequency
        Map<Integer, Integer> left = new HashMap<>(); // nums[i] and its earliest position
        Map<Integer, Integer> right = new HashMap<>(); // nums[i] and its latest position
        int degree = 0;
        for (int i = 0; i < nums.length; ++i) {
            int v = nums[i];
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            degree = Math.max(degree, cnt.get(v));
            if (!left.containsKey(v)) {
                left.put(v, i);
            }
            right.put(v, i);
        }

        int ans = 1000000; // max nums.len = 50000
        for (int v : nums) {
            if (cnt.get(v) == degree) {
                int t = right.get(v) - left.get(v) + 1;
                if (ans > t) {
                    ans = t;
                }
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************
}
