package BacktrackingAlgorithm.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsBacktracking {
    public static Set<List<Integer>> getPermutation(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        List<Integer> cur = new ArrayList<>();

        backtrack(nums, cur, res);
        return res;
    }

    private static void backtrack(int[] nums, List<Integer> current,
                                  Set<List<Integer>> res) {
        if(current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            System.out.println("Current Set : " + res);
            System.out.println("Return Location");
            return;
        }

        // starting from the first element always
        for(int i=0; i < nums.length; i++) {

            // if the current number is already in the set, skip it
            if (current.contains(nums[i])) {
                continue;
            }

            current.add(nums[i]);
            backtrack(nums, current, res);
            current.remove(current.size() - 1);

            System.out.println("After Return & Remove -> i = " + i +
                    ", current = " + current);

            System.out.println("***************** " + res + " *******************");
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println(getPermutation(arr));
    }
}
