package Blind75;

public class LongestPalindromicSubstring {
    public static String longestPalindrome_Test(String s) {
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

    // ***************** 1st Method ******************
    // Approach : Nested Loop - Brutal Force
    // Runtime  : 261ms        -> + 19.28%
    // Memory   : 71.7MB      -> + 5.1%
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
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Nested Loop - Brutal Force
    // Runtime  : 181ms        -> + 32.40%
    // Memory   : 45.8MB      -> + 12.18%
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
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Nested Loop - Brutal Force
    // Runtime  : 28ms        -> + 51.79%
    // Memory   : 41.4MB      -> + 68.70%
    public static String longestPalindrome3(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //StringBuffer sb = new StringBuffer();
            //sb.append(s.charAt[i]);
            char c = s.charAt(i);
            int left = i;
            int right = i;

            System.out.println("Cur Char -> " + c + ", i = " + i);
            System.out.println("Initial -> left = " + left + ", right = " + right);
            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }

            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }

            // left + 1 and right - 1 are actually the start and end index of the Palindromic string
            // we don't set "right" because String.substring function required end index exclusively
            left = left + 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }

            System.out.println("After -> left = " + left + ", right = " + right);
            System.out.println("Start = " + start + ", End = " + end);
            System.out.println("************************************");
        }
        System.out.println("Final -> Start = " + start + ", End = " + end);
        return s.substring(start, end);
    }
    // ***************** End of 3rd Method ******************


    public static void main(String[] args) {

        String wd = "babad";        // output : aba / bab
        String wd2 = "aacabdkacaa"; // output : aca
        String wd3 = "acacacb";     // output : acaca

        // racecar & aabbaa
        //System.out.println(longestPalindrome("acacacb"));

        System.out.println(longestPalindrome3(wd));
    }
}
