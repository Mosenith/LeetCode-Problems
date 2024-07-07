public class PassThePillow {
    public static void main(String[] args) {
        int n=33, time=218;

        System.out.println(passThePillow(n,time));
        System.out.println(passThePillow2(n,time));
    }

    // ***************** 1st Method ******************
    // Approach 1: Find the chunks and return the position
    // If chunks is even, return time % (n-1) + 1
    // Else, return n - time % (n-1)
    // Formula for even is due to the fact that the pillow is passed to the left
    // Formula for odd is due to the fact that the pillow is passed to the right
    // Runtime  : 10ms      -> + 26.23%
    // Memory   : 65.84MB   -> + 15.85%
    public static int passThePillow(int n, int time) {
        int chunks = time / (n - 1);
        return chunks % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Init ans as the position of the pillow after time passes to 1
    // k is the direction of the pillow, if 1, pillow is passed to the right,
    // if -1, pillow is passed to the left. If ans is 1 or n, change direction
    // Each iteration decrement time by 1 and increment ans by k
    // Runtime  : 0ms      -> + 100.00%
    // Memory   : 40.43MB  -> + 23.37%
    public static int passThePillow2(int n, int time) {
        int ans = 1, k = 1;
        while (time-- > 0) {
            ans += k;
            if (ans == 1 || ans == n) {
                k *= -1;
            }
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************
}
