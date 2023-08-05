import java.util.Arrays;

public class TrappingRainWater {
    // ***************** 1st Method ******************
    // Runtime  : 1ms        -> + 98.19%
    // Memory   : 50MB      -> + 5%
    // Find leftMax & rightMax. Get min(L,R) - height to calculate water
    // Time: O(n), Space: O(n)
    public static int trap(int[] height) {
        int len = height.length;
        if(len <= 1) return 0;

        int water = 0;
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        int[] rightMax = new int[len];
        rightMax[len-1] = height[len-1];

        for(int i=1; i<len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for(int i=len-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        for(int i=0; i<len; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 10ms        -> + 24.50%
    // Memory   : 57.7MB      -> + 10.95%
    // using two pointers. Time: O(n), Space: O(1)
    public static int trap2(int[] height) {
        int len = height.length;
        if (len <= 1) return 0;

        int water = 0;
        int l = 0, r = len -1;
        int maxL = height[l], maxR = height[r];

        while(l < r) {
            if(maxL <= maxR) {
                l++;
                water += Math.max((maxL - height[l]), 0);
                maxL = Math.max(maxL, height[l]);
            } else {
                r--;
                water += Math.max((maxR - height[r]), 0);
                maxR = Math.max(maxR, height[r]);
            }
        }

        return water;
    }

        public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};    // out = 6
        int[] h2 = {4,2,0,3,2,5};   // out = 9
        int[] h3 = {4,2,3};         // out = 1


        System.out.println(trap2(h));
        System.out.println(trap2(h2));
        System.out.println(trap2(h3));
    }
}
