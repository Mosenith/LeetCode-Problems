import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,1};

        System.out.println(findDisappearedNumbers2(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use store=boolean[] of len nums[].len and set store[n]=true if n in nums
    // Then loop from i=1 to nums.len and check if store[i] is false => add to list
    // Runtime  : 3ms         -> + 99.22%
    // Memory   : 53.24MB     -> + 84.78%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        boolean[] store = new boolean[nums.length+1];

        // since 1 <= nums[i] <= n
        for(int n : nums) {
            store[n] = true;
        }

        for(int i = 1; i <= nums.length; i++) {
            if(!store[i]) {
                ls.add(i);
            }
        }

        return ls;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use set to store all elements in nums[]
    // Check from i=1 to nums.len if i not exist in set, add to list
    // Runtime  : 17ms        -> + 29.77%
    // Memory   : 55.65MB     -> + 7.07%
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ls = new ArrayList<>();

        for(int n : nums) {
            set.add(n);
        }

        for(int i=1; i<=nums.length; i++) {
            if(!set.contains(i)) {
                ls.add(i);
            }
        }
        return ls;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Using s.split(" ") and loop through the array of it
    // When !"".equals(curString), increment the answer
    // Runtime  : 20ms        -> + 13.19%
    // Memory   : 53.67MB     -> + 55.93%
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
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
    //  ***************** End of 3rd Method ******************
}
