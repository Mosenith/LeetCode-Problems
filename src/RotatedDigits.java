import java.util.*;

public class RotatedDigits {
    public static void main(String[] args) {
        int n = 10; // 4 : 2, 5, 6, 9

        System.out.println(rotatedDigits(857));
    }

    public static int rotatedDigits(int n) {
        int count = 0;

        for(int i=1; i<=n; i++) {
            if(checkDigits(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkDigits(int i, Set<Integer> set) {
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
}
