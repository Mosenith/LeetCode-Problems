public class GuessNumberHigherOrLower {
    public class GuessGame {
        public static int guess(int n) {
            if(n == 3) return 0;
            else if(n > 3) return -1;
            else return 1;
        }
    }

    // ***************** 1st Method ******************
    // Approach 1: Binary Search - mid = left + (right - left) / 2;
    // Runtime  : 0ms          -> + 100.00%
    // Memory   : 40.72MB      -> + 6.43%
    public int guessNumber(int n) {
        if(GuessGame.guess(n) == 0) return n;
        int left = 1, right = n;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(GuessGame.guess(mid) == -1) {
                right = mid;
            } else if(GuessGame.guess(mid) == 1) {
                left = mid+1;
            } else {
                return mid;
            }
        }

        return left;
    }
    //  ***************** End of 1st Method ******************
}
