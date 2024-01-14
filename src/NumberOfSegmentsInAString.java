import java.util.Arrays;

public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        System.out.println(countSegments("                "));
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
}
