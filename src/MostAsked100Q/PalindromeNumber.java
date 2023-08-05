package MostAsked100Q;

public class PalindromeNumber {
    // ***************** 1st Method ******************
    // Approach : Calculate reverse of x - reverse = (reverse * 10) + (copyX % 10)
    // Return true if reverse = x, otherwise false
    // Runtime  : 9ms        -> + 99.59%
    // Memory   : 43.1MB      -> + 33.9%
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;

        int reverse = 0, copyX = x;

        while(copyX > 0){
            reverse = (reverse * 10) + (copyX % 10);
            copyX /= 10;
        }

        if(reverse != x)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        int x = 9;

        System.out.println(isPalindrome(x));
    }
}
