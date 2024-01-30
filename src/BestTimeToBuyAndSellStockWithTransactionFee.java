public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
    }

    int[] prices;
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;

        return dp(0,false);
    }

    public int dp(int pos, boolean buy) {
        if(pos == prices.length)
            return 0;
    }
}
