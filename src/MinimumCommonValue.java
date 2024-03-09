public class MinimumCommonValue {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};

        System.out.println(getCommon(nums1,nums2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use 2 pointers to check both arrays
    // If nums1[i] = nums2[j], return nums1[i]
    // Else if nums1[i]<nums2[j], i++, otherwise j++
    // If it gets out of loop, no common minimum element so return -1
    // Runtime  : 2ms         -> + 81.56%
    // Memory   : 62.67MB     -> + 47.63%
    public static int getCommon(int[] nums1, int[] nums2) {
        for(int i=0,j=0; i<nums1.length && j<nums2.length;) {
            if(nums1[i] == nums2[j]) {
                return nums1[i];
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
    //  ***************** End of 1st Method ******************

}
