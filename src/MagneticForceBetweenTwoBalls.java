import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {5,4,3,2,1,1000000000};
        int m = 2;

        System.out.println(maxDistance(position,m));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Binary search for the maximum distance between two balls
    // Sort the position array, set left to 1 and right to position[len-1] - position[0]
    // While left < right, find mid and check if canPutTheBall
    // If canPutTheBall, left = mid. Else, right = mid-1
    // Within canPutTheBall, count the number of balls that can be put
    // If fitBall >= m, return true. Else, return false
    // Runtime  : 43ms      -> + 58.58%
    // Memory   : 55.64MB   -> + 66.09%
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int left = 1;
        int right = position[len-1] - position[0];

        while(left < right) {
            int mid = (right+left+1) / 2;
            if(canPutTheBall(position,mid,m)) {
                left = mid; // get more bigger distance
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    private static boolean canPutTheBall(int[] position, int target, int m) {
        int fitBall =0;
        int lastBasket = -1000000000;
        for(int p : position) {
            if(p - lastBasket >= target) {
                fitBall++;
                lastBasket = p;
            }
        }
        return fitBall >= m;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Optimized the 1st method by using >>> 1 instead of / 2
    // Runtime  : 41ms      -> + 81.65%
    // Memory   : 55.56MB   -> + 78.33%
    public static int maxDistance2(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1];
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (check(position, mid, m)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static boolean check(int[] position, int f, int m) {
        int prev = position[0];
        int cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            int curr = position[i];
            if (curr - prev >= f) {
                prev = curr;
                ++cnt;
            }
        }
        return cnt >= m;
    }
    //  ***************** End of 2nd Method ******************
}
