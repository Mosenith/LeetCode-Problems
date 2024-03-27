public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 100;

        System.out.println(numSubarrayProductLessThanK2(nums, 2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Nested loop to check subArray
    // Runtime  : 851ms       -> + 16.13%
    // Memory   : 47.90MB     -> + 15.67%
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= k) continue;
            int cur = nums[i];
            cnt++;

            for(int j=i+1; j<nums.length; j++) {
                if(cur * nums[j] >= k) break;
                cnt++;
                cur *= nums[j];
            }
        }
        return cnt;
    }
    //  ***************** End of 1st Method ******************

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int cnt = 0;
        int maxProduct = 1;
        for(int n : nums) {
            maxProduct *= n;
        }
        System.out.println(maxProduct);

        int curProduct = 1;
        int len = nums.length-1;
        for(int i=0; i+1<len && curProduct<k; i++) {
            curProduct *= nums[i];
            if(curProduct >= k) break;

            cnt += factorial(len-i);
            System.out.println();
            System.out.println("*******\n");
        }

        return cnt;
    }

    private static int factorial(int i) {
        if(i == 0 || i == 1) return 1;

        return i * factorial(i-1);
    }
}

// 600 : 100
// 600 / 10 = 60 => 0-3 = 3! = 6
// 600 / 50 = 12 => 2! = 2
// 600 / 100=k => x