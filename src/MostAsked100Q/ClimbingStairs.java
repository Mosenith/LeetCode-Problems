package MostAsked100Q;

import java.util.HashMap;

public class ClimbingStairs {
    // ***************** 1st Method ******************
    // Approach : DP Memoization - using HashMap.containsKey() take O(1)
    // Runtime  : 0ms           -> + 100%
    // Memory   : 39.1 MB      -> + 80.41%
    public static int climbStairs(int n) {
        HashMap<Integer,Integer> lookup = new HashMap<>();
        return helper(n, lookup);
    }

    private static int helper(int n, HashMap<Integer,Integer> lookup) {
        if(!lookup.containsKey(n) && n <= 2) {
            lookup.put(n, n);
            return n;
        }

        if(!lookup.containsKey(n)) {
            int a = helper(n-2, lookup);
            int b = helper(n-1, lookup);
            lookup.put(n, a+b);
        }

        return lookup.get(n);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Straight Forward - for loop
    // from i=0 to n-1, a=0, b=1 => c = a+b, a=b, b=c
    // return b
    // Runtime  : 0ms           -> + 100%
    // Memory   : 39.4 MB      -> + 57.69%
    public int climbStairs2(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 1 -> 1
    // 2 -> 11 = 2
    // 3 -> 111, 12, 21 = 3
    // 4 -> 112, 1111, 121, 13, 211, 31 = 6
    public static void main(String[] args) {
        int n = 2; // 2
        int n2 = 3; // 3

        System.out.println(climbStairs(1));
    }

}
