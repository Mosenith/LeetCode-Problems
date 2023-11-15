public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }
    public static int getSum(int a, int b) {
        int c;
        while(b !=0 ) {
            c = (a&b);
            a = a ^ b;
            b = (c)<<1;
        }
        return a;
    }
}

// 2 = 0010
// 3 = 0011
// 5 = 0101


