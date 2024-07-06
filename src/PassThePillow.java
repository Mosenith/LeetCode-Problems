public class PassThePillow {
    public static void main(String[] args) {
        int n=33, time=218;

        System.out.println(passThePillow(2,341));

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


    // 218/(33-1)=7
    // 218%32=2
    // 33*6=198
    // 218-198=20
    // from 1 move 26 steps => 27
    public static int passThePillow2(int n, int time) {
        if(time < n) return time+1;

        int direction = time/n;
        int remainSteps = time - ((n-1)*direction);

        // even -> to left
        if(direction % 2 != 0) {
            return remainSteps+1;
        }

        // odd -> to right
        return n-remainSteps;
    }
}
