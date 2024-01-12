public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        // 26 -> "1a"
        System.out.println(toHex(26));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use & 15 to find remainder and num >>>= 4 to shift 4 digit
    // return reverse stringbuilder to string
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.30MB     -> + 6.56%
    public static String toHex(int num) {
        // a-10, b-11, c-12, d-13, e-14, f-15
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int x = num & 15;
            if (x < 10) {
                sb.append(x);
            } else {
                sb.append((char) (x - 10 + 'a'));
            }
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use Built-in method Integer.toHexString(num);
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.85MB     -> + 24.41%
    public static String toHex2(int num) {
        return Integer.toHexString(num);
    }
    //  ***************** End of 2nd Method ******************
}
