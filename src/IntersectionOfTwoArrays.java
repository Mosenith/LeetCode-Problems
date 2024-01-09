import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};

        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use a set to store nums1 and loop nums2
    // If set contain n in nums2, add to list & remove from set
    // If set is empty, break
    // return ls.stream().mapToInt(Integer::intValue).toArray();
    // Runtime  : 4ms          -> + 34.52%
    // Memory   : 43.64MB      -> + 32.56%
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ls = new ArrayList<>();

        for(int n : nums1) {
            set.add(n);
        }

        for(int n : nums2) {
            if(set.isEmpty()) break;
            if(set.contains(n)) {
                ls.add(n);
                set.remove(n);
            }
        }

        return ls.stream().mapToInt(Integer::intValue).toArray();
    }
    //  ***************** End of 1st Method ******************

}
