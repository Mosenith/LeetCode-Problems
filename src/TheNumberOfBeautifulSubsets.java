import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheNumberOfBeautifulSubsets {
    public static void main(String[] args) {
        int[] nums = {10,4,5,7,2,1};

        System.out.println(beautifulSubsets(nums, 3));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        backtrack(nums, k, ls, new ArrayList<>(),0);
        System.out.println(ls);

        return ls.size()-1;
    }

    private static void backtrack(int[] nums, int k, List<List<Integer>> ls, List<Integer> inner, int start) {
        if(inner.size()>2 && Math.abs(inner.get(inner.size()-1)-inner.get(inner.size()-2)) == k) {
            new ArrayList<>(inner);
            return;
        }
        if(inner.size()>0 && start+1<nums.length && Math.abs(inner.get(0)-nums[start+1]) == k) {
            System.out.println(inner.get(0)+ " : " +nums[start+1]);
            System.out.println(ls);
            start++;
            System.out.println("******\n");
        }
        if(start == nums.length) {
            System.out.println("At max len => " + inner);
            ls.add(new ArrayList<>(inner));
            return;
        }

        backtrack(nums,k,ls,inner,start+1);
        inner.add(nums[start]);
        backtrack(nums,k,ls,inner,start+1);
        System.out.println("Remove => " + inner.get(inner.size()-1));
        System.out.println(inner);
        inner.remove(inner.size()-1);
    }
}
