import java.util.Arrays;

public class ConstructTheRectangle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(37)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Start with initial width = sqrt(area)
    // Loop until area % width = 0 with each iteration decrement width
    // Return with 0th index = area/width, 1st index=width
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.99MB     -> + 21.92%
    public static int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[] {area / w, w};
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Check base case area=1 => [1,1]
    // Start with i=1 till area/2, check if area%i compare (area/i-i) with previous dis
    // Runtime  : 214ms       -> + 1.50%
    // Memory   : 41.08MB     -> + 14.57%
    public static int[] constructRectangle2(int area) {
        if(area == 1) return new int[]{1,1};

        int[] side = new int[2];
        int dis = Integer.MAX_VALUE;
        for(int i=1; i<=area/2; i++) {
            if(area % i == 0) {
                int w = area / i;
                if(dis > Math.abs(w-i)) {
                    side[0] = w;
                    side[1] = i;
                    dis = Math.abs(w-i);
                }
            }
        }
        return side;
    }
    //  ***************** End of 2nd Method ******************

}
