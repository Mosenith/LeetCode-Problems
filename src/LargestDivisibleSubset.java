import java.util.*;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,24}; //1,2,4,24

        System.out.println(largestDivisibleSubset(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Brute Force
    // Find all possible subset of nums[] and check each subset if they all divisible with each other
    // If it is, check size if bigger than curlargestSubset, update largestSubset & maxSize
    // Exceed time limit
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> largestSubset = new ArrayList<>();
        int maxSize = 0;

        // Generate all possible subsets of nums
        List<List<Integer>> subsets = generateSubsets(nums);

        System.out.println(subsets);
        // Check each subset if it satisfies the conditions
        for (List<Integer> subset : subsets) {
            if (isDivisibleSubset(subset)) {
                // Update largestSubset and maxSize if the current subset is larger
                if (subset.size() > maxSize) {
                    largestSubset = subset;
                    maxSize = subset.size();
                }
            }
        }
        return largestSubset;
    }

    // Function to generate all possible subsets of nums
    private static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); // Add an empty subset
        for (int num : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
        }
        return subsets;
    }

    // Function to check if every pair of elements in the subset satisfies the conditions
    private static boolean isDivisibleSubset(List<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            for (int j = i + 1; j < subset.size(); j++) {
                int a = subset.get(i);
                int b = subset.get(j);
                if (a % b != 0 && b % a != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    //  ***************** End of 1st Method ******************

}
