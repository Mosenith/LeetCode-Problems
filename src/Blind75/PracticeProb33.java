package Blind75;

public class PracticeProb33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7};   // 0,1,2,3,..
        // target = 5

        System.out.println(search(nums,6));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 1) {
            return (nums[0] == target) ? 0 : -1;
        }

        int numRotated = 0;
        int start = 0, end = nums.length-1;
        int index = -1;

        // Not rotated
        if(nums[start] > nums[end]) {
            int min = nums[end];
            for(int i=end; i>0; i--) {
                if (nums[i] > min) {
                    break;
                }
                numRotated++;
                min = nums[i];
            }

            if(target <= nums[end]) {
                // right => len-numRotated
                index = helper(nums,target,end-numRotated+1,end);
            } else {
                // left => len-numRotated+1
                index = helper(nums,target,start,end-numRotated);
            }
        } else {
            index = helper(nums, target, start, end);
        }

        return index;
    }

    // Binary Search
    private static int helper(int[] nums, int target, int start, int end) {
        if(start > end) return -1;

        int mid = (start+end)/2;
        int ans = -1;


        if(target == nums[mid]) {
            return mid;
        } else if(target > nums[mid]) {
            // search right
            ans = helper(nums, target, mid+1, end);
        } else {
            ans = helper(nums, target, start, mid-1);
        }

        return ans;
    }


}
