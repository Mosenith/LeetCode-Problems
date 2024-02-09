import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        int n1 = 12; // 3 - 4 + 4 + 4
        int n2 = 13; // 2 - 4 + 9

        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        // Initialize an array dp to store the least number of perfect square numbers
        // that sum up to each number from 0 to n
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++) {
            System.out.println("i = " + i);
            for(int j=1; j<=Math.sqrt(i); j++) {
                System.out.println("j = " + j);
                int square = j * j;
                System.out.println(dp[i] + " : " + (dp[i - square] + 1));
                // Update dp[i] with the minimum value of dp[i - square] + 1 for each square
                dp[i] = Math.max(dp[i], dp[i - square] + 1);
                System.out.println(dp[i]);
            }

            System.out.println(Arrays.toString(dp));
            System.out.println("******\n");
        }
        return dp[n];
    }
}
