import java.util.Arrays;

public class BreakAPalindrome {
    public static void main(String[] args) {
        String palindrome = "a";

        System.out.println(breakPalindrome(palindrome));
    }

    public static String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";

        char[] org = palindrome.toCharArray();
        System.out.println("Before --> " + Arrays.toString(org));

        for(int i=0; i<org.length; i++) {
            if(org[i] != 'a') {
                System.out.println("Change at i = " + i);
                char tmp = org[i];
                org[i] = 'a';
                String curStr = new String(org);
                System.out.println(curStr);
                if(!isPalindrome(curStr)) {
                    System.out.println("After --> " + Arrays.toString(org));
                    return curStr;
                } else {
                    org[i] = tmp;
                }
            }
            System.out.println("~~~~~\n");
        }

        System.out.println("After --> " + Arrays.toString(org));

        return ";";
    }

    public static boolean isPalindrome (String str) {
        char[] c = str.toCharArray();
        System.out.println("check => " + Arrays.toString(c));
        for(int i=0,j=str.length()-1; i<j; i++,j--) {
            if(c[i] != c[j]) {
                System.out.println("Is Not A Palindrome");
                return false;
            }
        }

        System.out.println("Is A Palindrome");
        return true;
    }
}
