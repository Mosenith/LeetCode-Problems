package BacktrackingAlgorithm.Backtracking;

import java.util.*;

public class CombinationSumToTarget {
    // Variation 1: Numbers are not distinct
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        // will store the final result
        List<List<Integer>> res = new ArrayList<>();

        // keeps track of the current state
        List<Integer> current = new ArrayList<>();

        // call the helper function which does the processing
        // first 0 is the sum of the numbers in the current state
        // second 0 is the index to start from
        backtrack(nums, target, 0, 0, current, res);

        return res;
    }

    private static void backtrack(int[] nums, int target, int currentSum,
                                  int startIndex, List<Integer> current, List<List<Integer>> res) {
        // if the sum of the numbers in the current state is equal to the target,
        // then we have found a solution
        if(currentSum == target) {
            // copy the content of the current state to a new list and save to result
            res.add(new ArrayList<>(current));
            return;
        } else if(currentSum > target){
            // short circuit, if the sum of the numbers in the current state is greater than the target,
            return;
        }

        for(int i=startIndex; i<nums.length; i++) {
            // add the current number to the current state
            current.add(nums[i]);

            // call the helper function to try the next state -
            // Current sum is updated and index is increased to the next number
            backtrack(nums, target, currentSum + nums[i],
                    i+1, current, res);

            // remove the current number from the current state
            current.remove(current.size() - 1);
            System.out.println("Current Result :" + res);
        }

        System.out.println("************************************");

    }

    // Variation 2: Numbers Can Be Used any Number of Times
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        // will store the temporary result
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack2(nums, target, 0, 0, current, res);


        System.out.println(res);

        // convert the set to a list
        return new ArrayList<>(res); 
    }

    private static void backtrack2(int[] nums, int target, int sum, int index,
                                   List<Integer> current, List<List<Integer>> res) {
        // checking for solution - omitted
        if(sum == target) {
            // copy the content of the current state to a new list and save to result
            res.add(new ArrayList<>(current));
            return;
        } else if(sum > target){
            // short circuit, if the sum of the numbers in the current state is greater than the target,
            return;
        }

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);

            // sum is updated but index is not incremented
            backtrack(nums, target, sum + nums[i], i, current, res);

            current.remove(current.size() - 1);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 4};
        int target = 5;

        System.out.println(combinationSum2(arr,target));
    }
}
