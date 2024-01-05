public class AddDigits {
    public static void main(String[] args) {
        int num = 38;

        System.out.println(addDigits(38));
    }
    // ***************** 1st Method ******************
    // Approach 1:
    // Runtime  : 1ms         -> + 85.02%
    // Memory   : 40.82MB     -> + 13.36%
    public static int addDigits(int num) {
        while(num >= 10) {
            int cur = 0;
            while(num > 0) {
                cur += num%10;
                num /= 10;
            }
            num = cur;
        }
        return num;
    }
    //  ***************** End of 1st Method ******************

    public static int addDigits2(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
