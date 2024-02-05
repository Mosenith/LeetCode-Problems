public class BreakAPalindrome {
    public static void main(String[] args) {
        String palindrome = "abcdcba";

        System.out.println(isPalindrome(palindrome));
    }

    public static String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";

        return ";";
    }

    public static boolean isPalindrome (String str) {
        char[] c = str.toCharArray();
        for(int i=0,j=str.length()-1; i>j; i++,j--) {
            if(c[i] != c[j]) {
                return false;
            }
        }

        return true;
    }
}
