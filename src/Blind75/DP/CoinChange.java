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
        if(coins[0] > amount) return -1;
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));

        helper(coins, amount, coins.length-1);

        return -1;
    }

    private static void helper(int[] coins, int amount, int start) {
        if(start < 0 || curSum == amount) return;

        if(curSum > amount) {
            if(count > 0)
                --count;
            else
                --start;
        }

        int tmp = amount / coins[start];
        curSum += tmp * coins[start];
        count = tmp;

        if(curSum > amount) {
            curSum -= tmp * coins[start];
        }

        helper(coins, amount, start-1);


    }


}
