package MostAsked100Q;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        int[] nums = {1,2,3};

        System.out.println(subsets(nums));
        System.out.println(subsets2(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Using backtrack technique
    // Runtime  : 0ms        -> + 100.00%
    // Memory   : 41.92 MB    -> + 51.31%
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> curAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        partition(nums, 0, ans, curAns);

        return ans;
    }

    private static void partition(int[] nums, int start, List<List<Integer>> ans, List<Integer> curAns) {
        if(start == nums.length) {
            ans.add(new ArrayList<>(curAns));
            return;
        }

        partition(nums, start+1, ans, curAns);
        curAns.add(nums[start]);
        partition(nums, start+1, ans, curAns);
        curAns.remove(curAns.size()-1);
    }
    // ***************** End of 1st Method ******************

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        ans.add(inner);

        dfs(nums, 0, ans, inner);
        return ans;
    }

    private static void dfs(int[] nums, int start, List<List<Integer>> ans, List<Integer> inner) {
        if(start == nums.length) {
            ans.add(new ArrayList<>(inner));
            return;
        }

        dfs(nums,start+1,ans,inner);
        inner.add(nums[start]);
        dfs(nums,start+1,ans,inner);
        inner.remove(inner.size()-1);
    }
}
