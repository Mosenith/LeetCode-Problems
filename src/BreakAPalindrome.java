import java.util.Arrays;

public class BreakAPalindrome {
    public static void main(String[] args) {
        String palindrome = "aba";

        System.out.println(breakPalindrome(palindrome));
    }

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
}
