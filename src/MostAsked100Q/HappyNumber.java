package MostAsked100Q;

import java.util.*;

public class HappyNumber {
    // ***************** 1st Method ******************
    // Approach : Brute Force - Use HashMap to store numbers after every loop
    // If it containsKey => loops endlessly in a cycle => False
    // Runtime  : 1ms        -> + 88.55%
    // Memory   : 40.1 MB      -> + 26.30%
    public static boolean isHappy(int n) {
        if(n==1) return true;
        if(Math.pow(n,2) < 10) return false;

        HashMap<Integer, Integer> storeDup = new HashMap<>();
        while(n>1) {
            storeDup.put(n,0);

            int sum = 0;
            while(n > 0) {
                sum += (int) Math.pow(n % 10, 2);
                n /= 10;
            }

            if(sum == 1)
                return true;
            else
                n = sum;
            if(storeDup.containsKey(n))
                break;
        }
        return false;
    }

    public static boolean isHappy2(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum,remain;

        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

            System.out.println(inLoop);
            System.out.println("******************");
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 19; // true
        int n2 = 4; // false : loop endlessly

        System.out.println(isHappy2(n));
//        System.out.println(isHappy2(n2));
    }
}
