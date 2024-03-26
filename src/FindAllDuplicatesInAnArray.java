import java.util.*;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1}; // 2,3

        System.out.println(findDuplicates3(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Set to store elements when encounter element that exist in set
    // Add that element to list, return list
    // Runtime  : 16ms        -> + 35.73%
    // Memory   : 54.94MB     -> + 28.26%
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            if(set.contains(n)) {
                ans.add(n);
            } else {
                set.add(n);
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Sort array first then if prevElement = curElement, add to list
    // Runtime  : 17ms        -> + 34.40%
    // Memory   : 53.30MB     -> + 82.53%
    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);
        int prev = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == prev) {
                ans.add(prev);
            } else {
                prev = nums[i];
            }
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Init array of nums.len+1 (freq[]), each n element in nums[] -> increment freq[n]
    // Check each element of freq[i], if >1 => add to list
    // Runtime  : 3ms        -> + 99.82%
    // Memory   : 54.47MB    -> + 37.27%
    public static List<Integer> findDuplicates3(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[nums.length+1];

        for(int n : nums) {
            freq[n]++;
        }
        for(int i=0; i<freq.length; i++) {
            if(freq[i] > 1) {
                ans.add(i);
            }
        }

        return ans;
    }
    //  ***************** End of 3rd Method ******************
}
