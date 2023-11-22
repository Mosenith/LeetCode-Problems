public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(findMin(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Check if arr[0] < arr[len-1] => if so, return arr[0]
    // Otherwise work from len-1 cos len-k < ... < len-2 < len-1
    // When len-k-1 > len-k, then min = len-k
    // Runtime  : 0ms            -> + 100%
    // Memory   : 40.74MB        -> + 52.40%
    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int len = nums.length;
        if(nums[0] < nums[len-1]) return nums[0];

        int min = nums[len-1];

        for(int i=len-2; i>0; i--) {
            if(nums[i] < min) {
                min = nums[i];
            } else {
                break;
            }
        }

        return min;
    }
    // ***************** End of 1st Method ******************

}
