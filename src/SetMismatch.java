import java.util.*;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {3,2,3,4,6,5};

        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use boolean[] of len nums.len+1 to keep track of checked num
    // If encounters the 2nd time, add to list
    // Then check through boolean[] for false element, add i to list
    // Return ans.stream().mapToInt(Integer::intValue).toArray();
    // Runtime  : 3ms         -> + 81.73%
    // Memory   : 45.31MB     -> + 53.19%
    public static int[] findErrorNums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        boolean[] checkedNum = new boolean[nums.length+1];

        for(int n : nums) {
            if(!checkedNum[n]) {
                checkedNum[n] = true;
            } else {
                ans.add(n);
            }
        }

        for(int i=1; i<checkedNum.length; i++) {
            if(!checkedNum[i]) {
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    //  ***************** End of 1st Method ******************
}
