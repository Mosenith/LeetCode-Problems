import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    // ***************** 1st Method ******************
    // Runtime  : 0ms        -> + 100ms
    // Memory   : 42.3MB      -> + 81.32%
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        computePermute(0, nums, ans);
        return ans;
    }

    private static void computePermute(int index, int[] nums, List<List<Integer>> ans) {
        // base case
        if(index == nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) tempList.add(num);
            ans.add(tempList);
            return;
        }

        for(int i=index; i<nums.length; i++) {
            System.out.println("Before swap: " + Arrays.toString(nums));
            swap(i, index, nums);
            System.out.println("After swap: " + Arrays.toString(nums) + ", ans = " + ans);
            computePermute(index+1, nums, ans);
            System.out.println("i: " + i + ", index: " + index + ", nums:" + Arrays.toString(nums));
            swap(i, index, nums);
            System.out.println("After 2nd swap: " + Arrays.toString(nums) + ", ans = " + ans);
            System.out.println("***************************************************");
        }
    }
    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 1ms        -> + 90.29%
    // Memory   : 42.3MB      -> + 81.32%
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        int[] nums = {1,2,3};

        System.out.println(permute(nums));
    }
}
