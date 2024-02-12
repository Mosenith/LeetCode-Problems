import java.util.*;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,24}; //1,2,4,24

        System.out.println(largestDivisibleSubset3(nums));
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

    // ***************** 2nd Method ******************
    // Approach 2: Sort given array & DP with memoization using dp[nums.len]
    // Runtime  : 14ms       -> + 61.45%
    // Memory   : 42.54MB    -> + 95.87%
    public static List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> largestSubset = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return largestSubset;
        }

        // Sort the input array
        Arrays.sort(nums);

        // Initialize dynamic programming arrays
        int n = nums.length;
        int[] dp = new int[n];
        int[] prevIndex = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndex, -1);

        // Dynamic programming to find the largest divisible subset
        int maxSize = 1;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j;
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        // Reconstruct the largest divisible subset
        while (maxIndex != -1) {
            largestSubset.add(nums[maxIndex]);
            maxIndex = prevIndex[maxIndex];
        }

        return largestSubset;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Optimized 2nd Method
    // Runtime  : 13ms       -> + 99.85%
    // Memory   : 42.93MB    -> + 58.34%
    public static List<Integer> largestDivisibleSubset3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            if (f[k] < f[i]) {
                k = i;
            }
        }

        int m = f[k];
        List<Integer> ans = new ArrayList<>();
        for (int i = k; m > 0; --i) {
            if (nums[k] % nums[i] == 0 && f[i] == m) {
                ans.add(nums[i]);
                k = i;
                --m;
            }
        }
        return ans;
    }
    //  ***************** End of 3rd Method ******************
}
