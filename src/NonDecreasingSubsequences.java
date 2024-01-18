import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};

        NonDecreasingSubsequences k = new NonDecreasingSubsequences();
        System.out.println(k.findSubsequences(nums));
    }

    List<Integer> inner;
    List<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        inner = new ArrayList<>();
        ans = new ArrayList<>();

        dfs(nums,0);
        return ans;
    }

    private void dfs(int[] nums, int start) {
        if(start >= nums.length) {
//            ans.add(new ArrayList<>(inner));
            inner = new ArrayList<>();
            return;
        }

        if(inner.size() == 0 || inner.size() > 0 && inner.get(inner.size()-1) <= nums[start]) {
            inner.add(nums[start++]);
            if(inner.size() > 1) {
                ans.add(new ArrayList<>(inner));
            }
        }

        dfs(nums, start);
    }
}
