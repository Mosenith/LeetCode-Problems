package MostAsked100Q;

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        // 1
//        int[] nums = {2,2,1};

        // 4
        int[] nums = {4,1,2,1,2};

        System.out.println(singleNumber(nums));
    }

    // ***************** 1st Method : HashMap ******************
    // Approach : HashMap
    // Runtime  : 13ms           -> + 25.02%
    // Memory   : 43.9 MB      -> + 90.1%
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> store = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            if(!store.containsKey(cur)) {
                store.put(cur, cur);
            } else {
                store.remove(cur);
            }
        }
        int res = 0;
        Iterator<Integer> iterator = store.keySet().iterator();
        if (iterator.hasNext()) {
            res = iterator.next();
        }
        return res;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Bit manipulator - ^
    // Runtime  : 0ms           -> + 100%
    // Memory   : 45.04 MB      -> + 14.94%
    public static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            ans ^= v;
        }
        return ans;
    }
}
