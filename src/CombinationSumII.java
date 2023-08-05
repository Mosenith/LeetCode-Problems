import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    // ***************** 1st Method ******************
    // Runtime  : 5ms        -> + 59.55%
    // Memory   : 42.5MB      -> + 76.39%

    int[] candidates;
    int target;
    static List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println("Sorted Array: " + Arrays.toString(candidates));
        ans = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

//        int curIndex = 0;
        // call helper
        combinationHelper(0, 0, new ArrayList<>());

        return ans;
    }

    private void combinationHelper(int curIndex, int sum, List<Integer> curList){
        if(sum == target) {
            ans.add(new ArrayList<>(curList));
        }

        if(sum > target) {
            return;
        }

        // sum < target
        for(int i=curIndex; i<candidates.length; i++) {
            if(i > curIndex && candidates[i] == candidates[i-1]) continue; // skip duplicates
            curList.add(candidates[i]);
            combinationHelper(i + 1, sum + candidates[i], curList);
            curList.remove(curList.size()-1);
        }
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 5ms        -> + 59.55%
    // Memory   : 42.4MB      -> + 87.5%

    public List<List<Integer>> combinationSum2_Method2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        CombinationSumII meth = new CombinationSumII();
        List<List<Integer>> out = meth.combinationSum2(candidates,target);
        System.out.println(out);
    }
}
