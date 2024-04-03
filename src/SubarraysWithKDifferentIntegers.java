import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;

        System.out.println(subarraysWithKDistinct2(nums,2));
    }
    // ***************** 1st Method ******************
    // Approach 1: Work but exceed time limit
    // Loop through each iteration and init Set and cur=i
    // While loop until set.size>k, add nums[cur++] to set, also check if set.size = k
    // There could be duplication elements, so if set.size = k & set.contains(nums[cur]), count++
    // Otherwise break and out of while loop if set.size = k, count++
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            int cur = i;
            while(cur<nums.length && set.size() <= k) {
                set.add(nums[cur++]);
                if(cur<nums.length && set.size() == k) {
                    if(!set.contains(nums[cur])) {
                        break;
                    } else {
                        count++;
                    }
                }
            }
            if(set.size() == k) count++;
        }
        return count;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 maps to keep track of frequency of each element
    // 2 variables (left1 & left2) starting from 0 to keep track of elements to remove from maps when map.size >k or map.size>=k
    // map2 will be removed first since it checks map2.size>=k
    // Count ans += diff(left1,left2)
    // Runtime  : 3ms         -> + 78.07%
    // Memory   : 45.61MB     -> + 58.12%
    public static int subarraysWithKDistinct2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> freqMap1 = new HashMap<>();
        Map<Integer, Integer> freqMap2 = new HashMap<>();
        int left1 = 0, left2 = 0; // left1 -> freqMap1, left2 -> freqMap2

        for (int right=0; right<n; right++) {
            int num = nums[right];
            freqMap1.put(num, freqMap1.getOrDefault(num, 0) + 1);
            freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);

            // when maps have more elements than k
            while (freqMap1.size() > k) {
                int leftMost = nums[left1++];
                // can't just remove the keys cos needs to go through elements from left to right
                freqMap1.put(leftMost, freqMap1.get(leftMost) - 1);
                if (freqMap1.get(leftMost) == 0) {
                    freqMap1.remove(leftMost);
                }
            }

            while (freqMap2.size() >= k) {
                int leftMost = nums[left2++];
                freqMap2.put(leftMost, freqMap2.get(leftMost) - 1);
                if (freqMap2.get(leftMost) == 0) {
                    freqMap2.remove(leftMost);
                }
            }

            count += left2-left1;
        }

        return count;
    }
    //  ***************** End of 2nd Method ******************
}
