import java.util.Arrays;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "1.1", version2 = "1.10";

        System.out.println(compareVersion(version1,version2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Compare from left to right and stop on '.'
    // If by then v1=v2, continue to compare till the '.'
    // Runtime  : 0ms       -> + 100.00%
    // Memory   : 41.80MB   -> + 8.85%
    public static int compareVersion(String version1, String version2) {
        int l1 = version1.length();
        int l2 = version2.length();

        for(int i=0, j=0; i<l1 || j<l2; i++,j++) {
            int a = 0, b = 0;
            while (i < l1 && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i++) - '0');
            }

            while (j < l2 && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j++) - '0');
            }
            if (a != b) {
                return a < b ? -1 : 1;
            }
        }

        return 0;
    }
    //  ***************** End of 1st Method ******************

}
