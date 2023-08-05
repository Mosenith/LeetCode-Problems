import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // ***************** 1st Method ******************
    // Runtime  : 2ms        -> + 90.6%
    // Memory   : 42.5MB      -> + 81.72%
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> tmpResult = new ArrayList<>();
        combinationUtil(candidates, target, 0, tmpResult, new ArrayList<>());

        return tmpResult;
    }

    private static void combinationUtil(int[] arr, int target, int currIndex, List<List<Integer>> tmpResult, List<Integer> curr) {
        // base case 1 : index = arr.len
        if(currIndex == arr.length) {
            // add copy of curr to result since it reached target
            if(target == 0)
                tmpResult.add(new ArrayList<>(curr));

            return;
        }

        // element in arr is smaller than target, proceed to find combination that adds up to target
        if(arr[currIndex] <= target) {
            curr.add(arr[currIndex]); // adding element which can contribute to target
            combinationUtil(arr,target-arr[currIndex], currIndex, tmpResult, curr);
            curr.remove(curr.size()-1); // remove the last added element before checking the next element (backtracking)
        }

        // otherwise, move to the next index
        combinationUtil(arr, target, currIndex+1, tmpResult, curr);

    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 2ms        -> + 90.6%
    // Memory   : 42.2MB      -> + 95.55%
    // Pretty much the same approach as above but using global variables might reduce memory & time usage
    private List<List<Integer>> ans;
    private int target;
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        this.target = target;
        this.candidates = candidates;
        dfs(0, 0, new ArrayList<>());
        return ans;
    }

    // s : current sum
    private void dfs(int s, int u, List<Integer> t) {
        if (s == target) {
            ans.add(new ArrayList<>(t));
            return;
        }
        if (s > target) {
            return;
        }
        for (int i = u; i < candidates.length; ++i) {
            int c = candidates[i];
            t.add(c);
            dfs(s + c, i, t);
            t.remove(t.size() - 1);
        }
    }
    //  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(candidates,target));
    }
}
