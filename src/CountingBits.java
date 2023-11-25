public class CountingBits {
    public static void main(String[] args) {
        System.out.println(countBits(3));
    }
    public static int[] countBits(int n) {
        int[] arr = new int[n+1];

        for(int i=0; i<=n; i++) {
            String b = Integer.toBinaryString(i);
            System.out.println(b);
        }

        return arr;
    }
}
