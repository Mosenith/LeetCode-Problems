package Blind75.DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;

        System.out.println(coinChange(coins,amount));
    }

    static int count = 0;
    static int curSum = 0;
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[len+1];

        // base case
        dp[0] = 1;
//        for(int i=1; i<len; i++) {
//            dp[i] = dp[i-coins[i]] + dp[i-coins[]]
//        }


        return dp[coins.length];
    }

    // coins = [2], amount = 3 => -1
    // coins = [1], amount = 0 => 0


}
