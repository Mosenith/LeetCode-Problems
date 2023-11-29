package Blind75.DP;

public class PracticeProb70 {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(climbStairs(3));
    }

    // recursive
    // 4 = 3 + 1
    // 2 = 1 + 0
    public static int climbStairs(int n) {
        // step = 1 or 2
        if(n == 0 || n == 1)
            return 1;


        return climbStairs(n-1) + climbStairs(n-2);
    }
}
