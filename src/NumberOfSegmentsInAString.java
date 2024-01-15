import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        System.out.println(countSegments3("Hello, my name is John"));
    }

    // ***************** 1st Method ******************
    // Approach 1: Convert s to String[] with s.trim().split("\\s+");
    // split("\\s+") will ignore multiple blank spaces
    // trim() will removes blank spaces from both ends of a string
    // Need to check String[] len >0 && at index 0th if it's empty -> return 0 (eg: s="       )
    // Otherwise, return string[].len
    // Runtime  : 1ms         -> + 31.89%
    // Memory   : 41.05MB     -> + 34.20%
    public static int countSegments(String s) {
        if(s.isEmpty()) return 0;

        String[] splitString = s.trim().split("\\s+");
        if(splitString.length > 0 && splitString[0].isEmpty()) {
            return 0;
        }

        return splitString.length;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Have a list store all words separated by whiltespaces & loop through each char in s
    // Inner loop, increment until index is at whitespace & add s.substring(prev,++i) to list
    // At i=s.len, add s.substring(prev,i) and otherwise i++
    // Out of loop, return list.size
    // Runtime  : 0ms       -> + 100.00%
    // Memory   : 41.25MB    -> + 21.88%
    public static int countSegments2(String s) {
        List<String> ls = new ArrayList<>();

        for(int i=0; i<s.length();) {
            int left = i;
            while(i<s.length() && s.charAt(i) != ' ') {
                i++;
            }
            if(i<s.length() && i != left) {
                ls.add(s.substring(left,++i));
            } else if(i == s.length()) {
                ls.add(s.substring(left, i));
            } else {
                i++;
            }
        }

        return ls.size();
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Using s.split(" ") and loop through the array of it
    // When !"".equals(curString), increment the answer
    // Runtime  : 1ms         -> + 31.89%
    // Memory   : 41.25MB     -> + 21.88%
    public static int countSegments3(String s) {
        int ans = 0;
        for (String t : s.split(" ")) {
            if (!"".equals(t)) {
                ++ans;
            }
        }
        return ans;
    }
    //  ***************** End of 3rd Method ******************
}
