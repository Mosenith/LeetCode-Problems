package MostAsked100Q;

import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement3(nums));
    }

    // ***************** 1st Method : HashMap ******************
    // Approach 1: Using HashTable - Not the best but good space complexity
    // Runtime  : 19ms           -> + 13.12%
    // Memory   : 46.5 MB        -> + 94.77%
    public static int majorityElement(int[] nums) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int majElm = -1, ocur = 0;

        for(int n : nums) {
            table.computeIfAbsent(n,(v) -> 0);
            table.computeIfPresent(n, (k,v) -> v += 1);
            if(ocur < table.get(n)) {
                majElm = n;
                ocur = table.get(n);
            }
        }
        return majElm;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Sort array using selection sort
    // return nums[len/2] since majorElement has more than ⌊n / 2⌋ times
    // Runtime  : 3ms           -> + 49.86%
    // Memory   : 48.65 MB      -> + 43.41%
    public static int majorityElement2(int[] nums) {
        // sort array first
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Moore's Voting Algorithms
    // Runtime  : 1ms           -> + 99.84%
    // Memory   : 48.63 MB      -> + 43.41%
    public static int majorityElement3(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
    // ***************** End of 3rd Method ******************
}
