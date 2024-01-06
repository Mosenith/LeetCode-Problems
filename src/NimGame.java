public class NimGame {
    public static void main(String[] args) {
        System.out.println(canWinNim(4)); // false
        System.out.println(canWinNim(3)); // true
    }

    // ***************** 1st Method ******************
    // Approach 1: If total heap %4 == 0 => false
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.23MB     -> + 19.55%
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    //  ***************** End of 1st Method ******************
}
