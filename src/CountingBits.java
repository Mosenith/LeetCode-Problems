import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits2(6)));
    }

    // ***************** 1st Method ******************
    // Approach : 2 cases - Odd & Even
    // Odd Num => #1 in bits = a[num/2] + 1
    // Even Num => #1 in bits = a[num/2]
    // Runtime  : 2ms           -> + 83.81%
    // Memory   : 46.45 MB      -> + 39.55%
    public static int[] countBits(int n) {
        // [0, 1, 1, 2, 1, 2, 2, 3]
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + 1;
            }
        }
        return ans;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Pretty straight forward approach
    // Runtime  : 10 ms          -> + 12.13%
    // Memory   : 48.73 MB     -> + 5.95%
    public static int[] countBits2(int n) {
        int[] arr = new int[n+1];

        for(int i=0; i<=n; i++) {
            String b = Integer.toBinaryString(i);
            arr[i] = countOne(b);
            System.out.println(b + " : " + arr[i]);
        }

        return arr;
    }

    private static int countOne(String b) {
        if(b.equals("0")) return 0;
        int zero = 0;
        for(int i=0; i<b.length(); i++) {
            if(b.charAt(i) == '1')
                zero++;
        }
        return zero;
    }
    // ***************** End of 2nd Method ******************

}
