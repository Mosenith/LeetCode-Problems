public class ReplaceAllDigitsWithCharacters {
    public static void main(String[] args) {
        // even - letter
        // odd - number
        String s = "a1b2c3d4e"; // abbdcfdhe

        System.out.println(replaceDigits(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: At odd index, covert char num to int by using Character.getNumericValue
    // Then, plus with s.charAt(i-1) and convert the sum to char
    // Runtime  : 1ms           -> + 56.56%
    // Memory   : 41.96MB       -> + 23.10%
    public static String replaceDigits(String s) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(i % 2 != 0) {
                ans.append((char)(s.charAt(i-1)+Character.getNumericValue(s.charAt(i))));
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Another way of converting char num to int is charNum - '0'
    // Then, similarly + with char and convert the whole thing to char
    // Runtime  : 0ms           -> + 100.00%
    // Memory   : 41.66MB       -> + 43.27%
    public static String replaceDigits2(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                ans.append((char)((c-'0')+(s.charAt(i-1))));
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
    //  ***************** End of 2nd Method ******************
}
