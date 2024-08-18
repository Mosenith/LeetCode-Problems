import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(nthUglyNumber(n));
        System.out.println(nthUglyNumber2(n));
    }

    // ***************** 1st Method ******************
    // Approach 1: Works but exceed time limit
    public static int nthUglyNumber(int n) {
        if(n == 1) return 1;

        List<Integer> ls = new ArrayList<>();
        int cnt = 1;
        int uglyNum = 1;
        while(cnt != n) {
            uglyNum++;
            int curNum = uglyNum;
            while(curNum > 1) {
                if(curNum % 2 == 0) {
                    curNum /= 2;
                } else if(curNum % 3 == 0) {
                    curNum /= 3;
                } else if(curNum % 5 == 0) {
                    curNum /= 5;
                } else {
                    break;
                }
            }

            if(curNum == 1) {
                cnt++;
                ls.add(uglyNum);
            }
        }
        return uglyNum;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Ugly number - prime factors are limited to 2, 3, and 5
    // Create an array to store the ugly numbers, with init uglyNumbers[0] = 1
    // Create 3 pointers i2, i3, i5 to keep track of the next ugly number
    // Loop from i=1 to n, get the minimum ugly number from the 3 pointers
    // Get the minimum ugly number by Math.min(uglyNumbers[i2] * 2, uglyNumbers[i3] * 3, uglyNumbers[i5] * 5)
    // Assign the minimum ugly number to uglyNumbers[i]
    // If the minimum ugly number is from i2, increment i2
    // If the minimum ugly number is from i3, increment i3
    // If the minimum ugly number is from i5, increment i5
    // Return the last ugly number
    // Runtime  : 2ms         -> + 91.97%
    // Memory   : 41.62MB     -> + 50.00%
    public static int nthUglyNumber2(int n) {
        if (n == 1) return 1;

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            // get the minimum ugly number first
            int nextUgly = Math.min(Math.min(uglyNumbers[i2] * 2, uglyNumbers[i3] * 3), uglyNumbers[i5] * 5);
            uglyNumbers[i] = nextUgly;

            if (nextUgly == uglyNumbers[i2] * 2) i2++;
            if (nextUgly == uglyNumbers[i3] * 3) i3++;
            if (nextUgly == uglyNumbers[i5] * 5) i5++;
        }

        return uglyNumbers[n - 1];
    }
    //  ***************** End of 2nd Method ******************
}
