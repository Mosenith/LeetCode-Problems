package Blind75;

public class PracticeProb121 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int max = 0;
        int curr = prices[0];

        for(int i=1; i<prices.length; i++) {
            if(curr < prices[i]) {
                max = Math.max(max, prices[i]-curr);
            } else {
                curr = prices[i];
            }
        }

        return max;
    }
}
