public class AddDigits {
    public static void main(String[] args) {
        int num = 38;

        System.out.println(addDigits(38));
    }
    // ***************** 1st Method ******************
    // Approach 1: Nested Loop
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

    // ***************** 2nd Method ******************
    // Approach 2: Consider when num = 0, num%9==0, and num%9!=0
    // Runtime  : 0ms         -> + 100.0%
    // Memory   : 41.31MB     -> + 5.94%%
    public static int addDigits2(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
    //  ***************** End of 2nd Method ******************

}
