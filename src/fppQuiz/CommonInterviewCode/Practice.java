package fppQuiz.CommonInterviewCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        // 3 -> (3,..), 2 ->

        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // k = target - nums[k], v = position
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i], i);
        }

        return new int[]{};
    }
}
