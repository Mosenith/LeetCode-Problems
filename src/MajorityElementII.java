import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {3,2,3}; // 3

        System.out.println(majorityElement2(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use map to store nums[] elements as key, #occurance as value
    // Then loop through map, if value > nums.len/3, add to ansList
    // Runtime  : 11ms         -> + 45.83%
    // Memory   : 47.70MB      -> + 64.19%
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int majorLen = nums.length/3;

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) > majorLen) {
                ans.add(key);
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use map to store nums[] elements as key, #occurance as value
    // Then loop through map, if value > nums.len/3, add to ansList
    // Runtime  : 4ms         -> + 59.79%
    // Memory   : 48.44MB     -> + 6.96%
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int majorLen = nums.length/3;
        // sort array and loop through each element while counting its occurrence
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            int count = 0;
            int prevI = i;
            while(prevI < nums.length && nums[prevI] == nums[i]) {
                prevI++;
                count++;
            }

            if(count > majorLen) {
                ans.add(nums[i]);
            }
            i = prevI-1;
        }

        return ans;
    }
    //  ***************** End of 2nd Method ******************

}
