public class PatchingArray {
    public static void main(String[] args) {
        int[] nums = {1,2,31,33};

        System.out.println(minPatches(nums,2147483647));
    }

    // ***************** 1st Method ******************
    // Approach 1: upto starts from 0 and must be less than n
    // If nums[i] <= upto+1, upto += nums[i++]
    // Else, patches++, upto += upto+1
    // Runtime  : 4ms       -> + 86.93%
    // Memory   : 43.80MB   -> + 31.65%
    public static int minPatches(int[] nums, int n) {
        int patches = 0;
        long upto = 0;
        int i = 0;

        while(upto < n) {
            if(i < nums.length && nums[i] <= upto+1) {
                upto += nums[i++];
            } else {
                patches++;
                upto += (upto+1);
            }
        }

        return patches;
    }
    //  ***************** End of 1st Method ******************
}


// [1,2,5]
// initial: [0,0]

// add 1 -> [0,1]
// add 2<= ls.get(ls.size()-1)+1 -> [0,3]

// add 5 <= ls.last=3 + 1 false -> no add
// add 4 <= ls.last= 3+ 1 true -> [0,7]