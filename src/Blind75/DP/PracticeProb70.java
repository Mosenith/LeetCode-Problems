package Blind75.DP;

public class PracticeProb70 {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(climbStairs2(3));
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

    public static int climbStairs2(int n) {
        int a = 0, b = 1;

        for(int i=0; i<n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }

        return b;
    }
}
// 0 - 0
// 1 - 1
// 2 - 11, 2 = 2
// 3 - 3
// 4 - 1111,22,211,112,121