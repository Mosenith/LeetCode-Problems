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

}
