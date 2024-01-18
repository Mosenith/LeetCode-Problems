import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};

        NonDecreasingSubsequences k = new NonDecreasingSubsequences();
        System.out.println(k.findSubsequences(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Recursion & backtracking while set initial curLast=-1000
    // In dfs(), base case is index>nums.len & inside check if inner.size>1 => add inner to ans
    // Check nums[index] >= curLast => add to inner & dfs with update index+1 & curLast -> nums[index]
    // After that recursion backtrack by removing the last element of the inner
    // Another if check nums[index] != curLast (means smaller) -> dfs with update index+1
    // Runtime  : 4ms         -> + 96.17%
    // Memory   : 51.05MB     -> + 43.93%
    List<Integer> inner;
    List<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        inner = new ArrayList<>();
        ans = new ArrayList<>();

        // -1000 is curLast to compare with start
        dfs(nums,0, -1000);
        return ans;
    }

    private void dfs(int[] nums, int index, int curLast) {
        if(index >= nums.length) {
            if(inner.size() > 1)
                ans.add(new ArrayList<>(inner));
            return;
        }

        if(nums[index] >= curLast) {
            inner.add(nums[index]);
            dfs(nums, index+1, nums[index]); // recursion
            inner.remove(inner.size()-1);   // backtrack
        }

        if(nums[index] != curLast) {
            dfs(nums, index+1, curLast);
        }
    }
    //  ***************** End of 1st Method ******************
}
