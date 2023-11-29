package Blind75.DP;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
    }

    static int count = 0;
    public int coinChange(int[] coins, int amount) {
        if(coins[0] > amount) return 0;

        helper(coins,amount,0, coins.length-1);

        return count;
    }

    private void helper(int[] coins, int amount, int curSum, int start) {
        if(start < 0) return;

        int tmp = amount / coins[start];
        curSum += tmp * coins[start];

        if(curSum > amount) {
            curSum -= tmp * coins[start];
        }

        helper(coins, amount, curSum, start-1);


    }


}
