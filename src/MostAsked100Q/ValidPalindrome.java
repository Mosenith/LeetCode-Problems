package MostAsked100Q;

import java.util.regex.Pattern;

public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama"; // true
        String s = " "; // true
//        String s = "0P";

//        System.out.println(s.charAt(-1+s.length()/2));
        System.out.println(isPalindrome(s));
    }

    // ***************** 1st Method ******************
    // Approach : Use left & right index - to track each char => while left < right
    // Convert s.charAt(left) & s.charAt(right) to lower case
    // Check if !Character.isLetterOrDigit(l/r), skip -> left++ or right--
    // If pass the above case, examine if l == r
    // Runtime  : 3ms        -> + 97.85%%
    // Memory   : 42MB      -> + 81.44%
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while(left < right) {
            System.out.println(left + " : " + right);
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            System.out.println(l + " : " + r);
            if(!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else {
                if(l != r) return false;
                left++;
                right--;
            }
            System.out.println("************************************");
        }
        System.out.println(left + " : " + right);
        return true;
    }
    //  ***************** End of 1st Method ******************
}
