import java.util.*;
import java.util.stream.Collectors;

public class PermutationsII {
    // ***************** 1st Method ******************
    // Runtime  : 845ms        -> + 6.77%
    // Memory   : 42.9MB      -> + 80.73%
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        computePermute(0, nums, ans);
        return ans;
    }

    private static List<List<Integer>> afterSwap = new ArrayList<>();
    private static void computePermute(int index, int[] nums, List<List<Integer>> ans) {
        // base case
        if(index == nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) tempList.add(num);
            ans.add(tempList);
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(i, index, nums);
            if(!ans.contains(Arrays.stream(nums).boxed().collect(Collectors.toList()))) {
                computePermute(index+1, nums, ans);
//                afterSwap.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                swap(i, index, nums);
            } else {
                swap(i, index, nums);
            }

//            swap(i, index, nums);
//            computePermute(index+1, nums, ans);
//            afterSwap.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
//            swap(i, index, nums);
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
    public static List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                System.out.println("************************************");
                System.out.println(Arrays.toString(used) + ", i = " + i);
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                    System.out.println("Special case: " + nums[i]);
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);

                System.out.println("Before tempList: " + tempList + ", ans: " + list);
                backtrack(list, tempList, nums, used);
                System.out.println("After tempList: " + tempList + ", ans: " + list);

                used[i] = false;
                tempList.remove(tempList.size() - 1);
//                System.out.println("************************************");
            }
        }
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Runtime  : 3ms        -> + 61.75%
    // Memory   : 42.9MB      -> + 80.4%
    // Use HashMap to keep track of elements and their counts
    public static List<List<Integer>> permuteUnique3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // create hashmap to store elements and their counts
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            if (!counter.containsKey(num)) {
                counter.put(num, 0);
            }
            counter.put(num, counter.get(num) + 1);
        }

        System.out.println(counter);
        LinkedList<Integer> comb = new LinkedList<>();
        dfs(comb, nums.length, counter, ans);
        return ans;
    }

    private static void dfs(LinkedList<Integer> comb, int len,
                            HashMap<Integer, Integer> counter, List<List<Integer>> ans) {
        if(comb.size() == len) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();

            if(count == 0)
                continue;

            comb.addLast(num);
            counter.put(num,count-1);

            dfs(comb, len, counter, ans);

            comb.removeLast();
            counter.put(num, count);
        }
    }
    //  ***************** End of 3rd Method ******************

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(permuteUnique2(nums));
//        System.out.println(afterSwap);
    }
}
