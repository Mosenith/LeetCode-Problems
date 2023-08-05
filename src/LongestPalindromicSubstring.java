import java.util.Arrays;
import java.util.Objects;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String front = s;
        String back = "";
        String out = "";        // Final Result

        for(int i=s.length()-1; i>=0; i--){
            back = back + front.charAt(i);
        }

        for(int i=0; i<back.length(); i++){
            String current_Back = String.valueOf(back.charAt(i));
            int copy_i = i;     // could change within the next loop
            String curr_result = "";    // non-final result



            for(int front_index=0; front_index<front.length(); front_index++){

                if(current_Back.equals(String.valueOf(front.charAt(front_index)))){
                    curr_result += front.charAt(front_index);
                    copy_i++;
                    if(copy_i >= back.length()){
                        break;
                    }
                    //System.out.println(current_Back);
                    System.out.println(front.charAt(front_index));
                    current_Back = String.valueOf(back.charAt(copy_i));


                } else {
                    if(i != copy_i){
                        break;
                    }
                }
            }

            //System.out.println(curr_result);
            if(out.length() <= curr_result.length()){
                out = curr_result;
            }
        }

        return out;
    }

    public static String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int mx = 1, start = 0;

        for (int j = 0; j < n; ++j) {
            for (int i = 0; i <= j; ++i) {
                System.out.println("i-" + i + "; j-" + j);
                if (j - i < 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    System.out.println(s.charAt(i) + "-" + s.charAt(j));
                    System.out.println(dp[i][j]);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && mx < j - i + 1) {
                    mx = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + mx);
    }

    public static int longestPalSubstr(String str)
    {
        // get length of input String
        int n = str.length();

        // All subStrings of length 1
        // are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;

                    System.out.println("i-" + i + "; j-" + j + "; k-" + k + "; charAt(i + k)- "
                            + str.charAt(i + k) + "; charAt(j - k)- " + str.charAt(j - k));
                }

                // Palindrome
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        // return length of LPS
        return maxLength;
    }

    public static void main(String[] args) {

        String wd = "babad";        // output : aba / bab
        String wd2 = "aacabdkacaa"; // output : aca
        String wd3 = "acacacb";     // output : acaca

        //System.out.println(longestPalindrome("acacacb"));

        System.out.println(longestPalindrome2(wd3));
        //System.out.println(longestPalSubstr("acacacb"));

       //System.out.println(wd3.length());

        //System.out.println(wd2.substring(2,5));
    }
}
