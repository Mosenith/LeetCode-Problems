import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
    public static int[] countBits(int n) {
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
}
