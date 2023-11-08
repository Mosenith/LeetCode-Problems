import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExpressiveWords {
    public static void main(String[] args) {
        // 3
//        String s = "zzzzzyyyyy";
//        String[] words = {"zzyy","zy","zyy"};

        // 1
        String s = "heeellooo"; // s > words
        String[] words = {"hello", "hi", "helo"};

        // 0
//        String s = "heeelllooo";  // <= i
//        String[] words = {"hellllo"};

        System.out.println(expressiveWords(s,words));
    }

    // ***************** 1st Method ******************
    // Approach 1: Check every str in words[] with s
    // Let i -> s, j -> str
    // While Loop until either i > s.len or j > str.len
    // In Loop, check s.at(i) == str.at(j) -> if not return false
    // Else - countS = consecutive characters in s
    // countStr = consecutive characters in str
    // Compare both => countS < countStr || (countS > countStr && countS < 3) return false ****
    // Then, next i & j until out of loop return i == s.length() && j == str.length()
    // Runtime  : 2ms          -> + 63.37%
    // Memory   : 40.52MB      -> + 79.87%
    public static int expressiveWords(String s, String[] words) {
        int count = 0;

        for (String str : words) {
            if (isExpressive(s, str)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isExpressive(String s, String str) {
        int i = 0; // s
        int j = 0; // str

        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                int countS = 1;
                int countStr = 1;

                // Count consecutive characters in s
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    countS++;
                }

                // Count consecutive characters in str
                while (j + 1 < str.length() && str.charAt(j) == str.charAt(j + 1)) {
                    j++;
                    countStr++;
                }

                // s > Str cos s is the stretchy version of Str
                // s is stretchy unless #RepeatCharacter > 2
                if (countS < countStr || (countS > countStr && countS < 3)) {
                    return false;
                }
            } else {
                return false;
            }

            i++;
            j++;
        }

        // Expressive word if both i & j reach the len of s & str(words[i]) respectively
        return i == s.length() && j == str.length();
    }
    //  ***************** End of 1st Method ******************


}
