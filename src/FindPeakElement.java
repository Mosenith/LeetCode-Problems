public class FindPeakElement {
    public static void main(String[] args) {
//        int[] nums = {1,2,1,3,5,6,4}; // out: 4
        int[] nums = {1,2,3}; // out: 2
//        int[] nums = {1,2}; // out: 1

        System.out.println(findPeakElement(nums));
    }

    // ***************** 1st Method ******************
    // Approach :
    // Runtime  : 0ms        -> + 100.00%
    // Memory   : 40.93MB      -> + 93.83%
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        else if(nums.length <= 2)
            return (nums[0] < nums[1]) ? 1 : 0;

        int ans = 0;
        for(int i=1; i<nums.length-1; i++) {
            if(nums[i+1] > nums[i]) {
                ans = i+1;
                continue;
            } else if(nums[i] > nums[i+1] && nums[i] > nums[i-1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach :
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.67MB      -> + 99.70%
    public static int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    //  ***************** End of 2nd Method ******************
}
