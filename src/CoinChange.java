import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 6;

        System.out.println(coinChange2(coins,amount));
    }

    // ***************** 1st Method ******************
    // Approach : Dynamic Programming - return dp[amount+1]
    // dp[i] := the minimum number of coins to make up i
    // dp[] from amount i = 0 to amount with dp[0]=0
    // check dp[i] with coin[j] - Set tmp = MAX
    // if i>=coins[j] && dp[i-coins[j]] != -1 => tmp = min(tmp,dp[i-coins[j])
    // out of j-loop => if tmp != MAX => update dp[i] = min + 1, otherwise -1
    // Runtime  : 12ms           -> + 93.11%
    // Memory   : 43.22 MB      -> + 56.45%
    public static int coinChange(int[] coins, int amount) {
        // base case dp[0] = 0
        int[] dp = new int[amount+1]; // from 0 to amount

        for (int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            System.out.println("cur amount = " + i);
            for (int j=0; j<coins.length; j++) {
                if (i>=coins[j] && dp[i-coins[j]] != -1) {
                    System.out.println("¥¥¥ Update Min ¥¥¥");
                    min = Math.min(min,dp[i-coins[j]]);
                }
                System.out.println("at j = " + j + " => min = " + min);
                System.out.println("~~~~\n");
            }
            dp[i] =  (min == Integer.MAX_VALUE) ? -1 : 1+min;
            System.out.println(Arrays.toString(dp));
            System.out.println("=======");
        }

        System.out.println("Final dp => ");
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Pretty similar to approach 1 but start form coin as outer loop
    // Before loop need to fill dp[] with amount+1 cos that's the max step
    // Update the amount dp[0->amount] after every coin
    // Runtime  : 10ms          -> + 99.55%
    // Memory   : 43.50 MB      -> + 44.87%
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);

        for (final int coin : coins) {
            for (int i=coin; i<=amount; ++i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    // ***************** End of 2nd Method ******************

}
