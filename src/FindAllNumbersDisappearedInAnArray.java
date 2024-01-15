import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,1};

        System.out.println(findDisappearedNumbers(nums));
    }

    // ***************** 3rd Method ******************
    // Approach 3: Using s.split(" ") and loop through the array of it
    // When !"".equals(curString), increment the answer
    // Runtime  : 20ms        -> + 13.19%
    // Memory   : 53.67MB     -> + 55.93%
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();
        int i=1, j=0;

        for(; i<=nums.length && j<nums.length;) {
            if(j>0 && nums[j] == nums[j-1]) {
                j++;
                continue;
            }
            if(i != nums[j]){
                ls.add(i);
            } else {
                j++;
            }
            i++;
        }

        while(i <= nums.length) {
            ls.add(i++);
        }
        return ls;
    }
    //  ***************** End of 1st Method ******************

}
