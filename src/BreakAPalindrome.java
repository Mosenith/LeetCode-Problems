import java.util.Arrays;

public class BreakAPalindrome {
    public static void main(String[] args) {
        String palindrome = "aba";

        System.out.println(breakPalindrome(palindrome));
    }

    // ***************** 1st Method ******************
    // Approach 1: Base check if s.len = 1, it's always a palindrome so return ""
    // Iterate from i=0, if s[i] != 'a' or i=s.len-1, change s[i] to 'a' or 'b' (if s[i]='a')
    // Check if the new s after changed is not a palindrome, return the new s
    // otherwise rechange it, continue the next iteration
    // Runtime  : 0ms        -> + 100.0%
    // Memory   : 41.62MB    -> + 22.53%
    public static String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";

        char[] org = palindrome.toCharArray();

        for(int i=0; i<org.length; i++) {
            if(org[i] != 'a' || i == org.length-1) {
                char tmp = org[i];
                org[i] = (tmp == 'a') ? 'b' : 'a';
                String curStr = new String(org);
                if(!isPalindrome(curStr)) {
                    return curStr;
                } else {
                    org[i] = tmp;
                }
            }
        }
        return "";
    }
    public static boolean isPalindrome (String str) {
        char[] c = str.toCharArray();
        for(int i=0,j=str.length()-1; i<j; i++,j--) {
            if(c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Base case when s.len = 1 => return ""
    // From i=0, iterate till s[i] != 'a' && i<s.len/2
    // If i=s.len/2, replace s[i] to 'b', otherwise replace s[i] to 'a'
    // Runtime  : 0ms        -> + 100.0%
    // Memory   : 41.62MB    -> + 22.53%
    public static String breakPalindrome2(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] cs = palindrome.toCharArray();
        int i = 0;
        while (i < n / 2 && cs[i] == 'a') {
            ++i;
        }
        if (i == n / 2) {
            cs[n - 1] = 'b';
        } else {
            cs[i] = 'a';
        }
        return String.valueOf(cs);
    }
    // ***************** End of 2nd Method ******************
}
