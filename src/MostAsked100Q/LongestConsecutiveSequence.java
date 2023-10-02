package MostAsked100Q;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {1,2,0,1};

        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Using TreeMap to store all nums in the array
    // Since treemap sorted all the elements, use iterator and evaluate
    // Record the prev element during itr.hasNext() loop to cal with prev
    // if cur - prev == 1, continue counting the curLen++
    // if not set curLen back to 1;
    // Runtime  : 100ms           -> + 32.64%
    // Memory   : 59.24 MB      -> + 39.39%
    public static int longestConsecutive(int[] nums) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for(int n : nums) {
            treeMap.computeIfPresent(n, (k,v) -> v+1);
            treeMap.computeIfAbsent(n, v -> 1);
        }

        Iterator<Integer> itr = treeMap.keySet().iterator();
        int maxLen = 0, curLen = 0;
        int prev = 0;

        while (itr.hasNext()) {
            int cur = itr.next();
            if(curLen == 0 || cur-prev == 1) {
                curLen++;
            } else {
                curLen = 1;
            }
            if(maxLen < curLen) {
                maxLen = curLen;
            }
            prev = cur;

        }
        return maxLen;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Sort array first then applied the above logic
    // Loop through array and if n-prev = 1, curLen++
    // Additional check is n-prev = 0, continue
    // other than those 2 cases, just set curLen back to 1
    // Runtime  : 14ms           -> + 97.92%
    // Memory   : 56.16 MB      -> + 83.28%
    public static int longestConsecutive2(int[] nums) {
        Arrays.sort(nums);

        int maxLen = 0, curLen = 0;
        int prev = 0;
        for(int n : nums) {
            if(curLen == 0 || n-prev == 1) {
                curLen++;
            } else if(n-prev != 0) {
                curLen = 1;
            }
            if(maxLen < curLen) {
                maxLen = curLen;
            }
            prev = n;
        }

        return maxLen;
    }
    // ***************** End of 2nd Method ******************
}
