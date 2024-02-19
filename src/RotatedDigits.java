public class RotatedDigits {
    public static void main(String[] args) {
        int n = 10; // 4 : 2, 5, 6, 9

        System.out.println(rotatedDigits(857));
    }

    // ***************** 1st Method ******************
    // Approach 1: Check from 1 to n if it's valid or not
    // Check valid by init flag=false, if a digit=2,5,6,9 -> set flag=true
    // If encounter 3,4,7 => return false, out of loop return flag
    // Runtime  : 3ms           -> + 94.20%
    // Memory   : 40.11MB       -> + 85.32%
    public static int rotatedDigits(int n) {
        int count = 0;

        for(int i=1; i<=n; i++) {
            if(isValid(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isValid(int i) {
        boolean flag = false;
        while(i > 0) {
            int tmp = i % 10;
            if(tmp == 2 || tmp == 5 || tmp == 6 || tmp == 9) {
                flag = true;
            }
            if(tmp == 3 || tmp == 4 || tmp == 7) {
                return false;
            }
            i /= 10;
        }
        return flag;
    }
    //  ***************** End of 1st Method ******************
}
