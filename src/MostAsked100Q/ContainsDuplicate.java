package MostAsked100Q;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
    }

    // ***************** 1st Method : HashMap ******************
    // Approach 1: Use hashTable - check before adding to hashtable
    // Runtime  : 19ms           -> + 13.12%
    // Memory   : 46.5 MB        -> + 94.77%
    public static boolean containsDuplicate(int[] nums) {
        Hashtable<Integer,Integer> store = new Hashtable<>();

        for(int n : nums) {
            if(store.containsKey(n))
                return true;
            store.put(n,0);
        }
        return false;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Hashtable but add 2 elements each loop if not in hashtable
    // Runtime  : 1ms           -> + 99.97%
    // Memory   : 41.16 MB      -> + 79.75%
    public static boolean containsDuplicate2(int[] nums) {
        Hashtable<Integer,Integer> store = new Hashtable<>();

        for(int i=0, j=nums.length-1; i<=j; i++, j--) {
            if(i!=j && nums[i] == nums[j] || store.containsKey(nums[i]) || store.containsKey(nums[j]))
                return true;
            store.put(nums[i], 0);
            store.put(nums[j], 0);
        }

        return false;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Consider the condition, HashSet is way faster than other data structures
    // Runtime   : 10ms           -> + 91.07%
    // Memory    : 55.13 MB      -> +  65.99%
    public static boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
    // ***************** End of 3rd Method ******************
}
