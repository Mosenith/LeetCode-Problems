import java.util.*;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {3,2,3,4,6,5};

        System.out.println(Arrays.toString(findErrorNums2(nums)));
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

    // ***************** 2nd Method ******************
    // Approach 2: Use sum of arithmetics numbers - s,s1,s2
    // s-All sum in nums, s1-Well organized arithmetics nums(1-n), s2-Sums in nums without dup elements
    // return array of {s - s2,s1 - s2} with s-s2 => Get repeated number & s2-s1 => find missing number
    // Runtime  : 9ms       -> + 25.54%
    // Memory   : 45.68MB   -> + 24.23%
    public static int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        int s1 = (1 + n) * n / 2;
        int s2 = 0;
        Set<Integer> set = new HashSet<>();
        int s = 0;

        for (int x : nums) {
            if (set.add(x)) {
                s2 += x;
            }
            s += x;
        }
        // s2-s1 => find missing number
        // s-s2 => Get repeated number
        return new int[] {s - s2, s1 - s2};
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Similar to 1st method - since we know there are 2 elements in the return array
    // Have an occ[] to track n in nums, so if occ[i]=0 -> missing num
    // If occ[i]=2 -> duplicated num
    // Runtime  : 2ms         -> + 97.67%
    // Memory   : 46.28MB     -> + 5.04%
    public static int[] findErrorNums3(int[] nums) {
        int[] occurrences = new int[nums.length];

        for(int num : nums){
            occurrences[num-1]++;
        }

        int[] solution = new int[2];

        for(int i = 0; i < occurrences.length; i++){
            if(occurrences[i] == 0) solution[1] = i+1;
            if(occurrences[i] == 2) solution[0] = i+1;
        }

        return solution;
    }
    //  ***************** End of 3rd Method ******************
}
