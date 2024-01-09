import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};

        System.out.println(Arrays.toString(intersection2(nums1,nums2)));
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

    // ***************** 2nd Method ******************
    // Approach 2: Sort array and use 2 pointers
    // If n1[i] == n2[j] => if ls is empty or last element of ls != n1[i] -> add to ls
    // If n1[i] > n2[j] => j++, otherwise i++
    // Return ls.stream().mapToInt(Integer::intValue).toArray();
    // Runtime  : 5ms          -> + 22.19%
    // Memory   : 42.94MB      -> + 78.77%
    public static int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i=0, j=0; i<nums1.length && j<nums2.length;) {
            if(nums1[i] == nums2[j]) {
                if(ls.isEmpty() || ls.get(ls.size()-1) != nums1[i])
                    ls.add(nums1[i]);
                i++; j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return ls.stream().mapToInt(Integer::intValue).toArray();
        //  ***************** End of 2nd Method ******************

    }
}
