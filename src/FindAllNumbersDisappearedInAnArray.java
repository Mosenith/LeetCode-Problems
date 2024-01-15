import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,1};

        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();

        System.out.println(Arrays.toString(nums));
        for(int i=1; i<nums.length; i++) {
            int prev = nums[i-1];
            int cur = nums[i];

            if(cur != prev && cur-prev != 1) {
                System.out.println(prev + " : " + cur);
                while(prev < cur-1){
                    ls.add(++prev);
                }
            }
        }

        if(ls.isEmpty()) {
            ls.add(nums[nums.length-1]);
        }

        return ls;
    }
}
