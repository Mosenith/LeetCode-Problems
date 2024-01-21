import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] n1 = {1,3,5,2,4};
        int[] n2 = {6,5,4,3,2,1,7};

        NextGreaterElementI nge = new NextGreaterElementI();

        System.out.println(Arrays.toString(nge.nextGreaterElement2(n1,n2)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use 2 map to store k-nums2[i], v-i and vise-versa
    // Loop in nums1, have index=(map.get(nums1[i]) + 1) and while index < nums2.len
    // Loop till get element > nums1[i], if exit loop & index=nums2.len => -1
    // Otherwise, add ans[i]=rmap.get(index)
    // Runtime  : 5ms         -> + 29.09%
    // Memory   : 44.56MB     -> + 6.68%
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>(); // k-nums[i], v-i
        Map<Integer,Integer> rmap = new HashMap<>();

        // store elements of num2 -> map
        for(int i=0; i<nums2.length; i++) {
            map.put(nums2[i], i);
            rmap.put(i,nums2[i]);
        }

        for(int i=0; i<nums1.length; i++) {
            int index = map.get(nums1[i]) + 1;

            while(index < nums2.length) {
                if(rmap.get(index) > nums1[i]) {
                    break;
                }
                index++;
            }

            if(index == nums2.length) {
                ans[i] = -1;
            } else {
                ans[i] = rmap.get(index);
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use a map to store key as nums2[i], v as elements to the right > nums2[i]
    // If that element doesn't exist, put -1
    // In another loop for nums1, ans[i] = map.get(nums1[i])
    // Runtime  : 2ms       -> + 98.87%
    // Memory   : 43.58MB   -> + 60.49%
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>(); // k-nums[i], v-i

        for(int i=0; i<nums2.length; i++) {
            int cur = nums2[i];
            int j=i+1;
            while(j < nums2.length) {
                if(nums2[j] > cur) {
                    break;
                }
                j++;
            }
            if(j < nums2.length) {
                map.put(cur,nums2[j]);
            } else {
                map.put(cur,-1);
            }
        }

        for(int i=0; i<nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
    //  ***************** End of 2nd Method ******************
}
