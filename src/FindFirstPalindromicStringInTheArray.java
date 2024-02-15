public class FindFirstPalindromicStringInTheArray {
    public static void main(String[] args) {
        // ada
        String[] words = {"def","ghi"};

        System.out.println(firstPalindrome(words));
    }

    // ***************** 1st Method ******************
    // Approach 1: Check each string in the given list if it is Palindrome or not
    // If encounters one, just return it. Out of loop return ""
    // Runtime  : 1ms        -> + 100.00%
    // Memory   : 45.52MB    -> + 8.22%
    public static String firstPalindrome(String[] words) {
        for(String s : words) {
            if(isPalindrome(s)) {
                return s;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1; i<j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    //  ***************** End of 1st Method ******************

}
