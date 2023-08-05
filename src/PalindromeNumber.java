public class PalindromeNumber {
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
