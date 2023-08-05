package MostAsked100Q;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};    // out = 5
//        int[] prices = {2,1,2,1,0,1,2};    // out = 2
//        int[] prices = {3,3,5,0,0,3,1,4};   // out = 4

        System.out.println(maxProfit3(prices));
    }

    // ***************** 1st Method ******************
    // Approach : Brute Force - Find the biggest from i+1 in Prices
    // => store[] - 0th index -> position in prices, 1st index -> sell value
    // if i == store[0] => Back to find the biggest from i+1
    // Runtime  : 523ms        -> + 6.58%
    // Memory   : 60MB      -> + 73.78%
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = -1;
        int[] store = null;
        for(int i=0; i<prices.length-1; i++) {
            if(store == null || i >= store[0]) {
                store = maxValue(i+1, prices);
            }
            if(buy == -1 && store[1]-prices[i] > profit) {
                profit = Math.max(profit, store[1]-prices[i]);
                buy = prices[i];
            } else if(buy > prices[i]) {
                profit = Math.max(profit, store[1]-prices[i]);
            }
        }
        return profit;
    }
    private static int[] maxValue(int start, int[] prices) {
        System.out.println("Run");
        int minIndex = -1;
        int minVal = Integer.MIN_VALUE;
        for (int i = start; i < prices.length; i++) {
            if (prices[i] >= minVal) {
                minVal = prices[i];
                minIndex = i;
            }
        }

        return new int[]{minIndex, minVal};
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Optimized - Update minPrice when prices[i] < minPrice
    // Otherwise : max(maxPrice, prices[i]-minPrice)
    // Runtime  : 2ms        -> + 93.70%
    // Memory   : 61.2MB      -> + 42.63%
    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            System.out.println("prices[i] = " + price + " -> " + minPrice + " : " + maxProfit);
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
            System.out.println(price + " : " + minPrice + " : " + maxProfit);
            System.out.println("******************");
        }

        return maxProfit;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Use 2 pointers - Left(Buy) & Right(Sell) (Left < Right)
    // If p[left] < p[right] => profit = max(profit, p[right]-p[left].
    // Otherwise left = right
    // Increase right+1 at every iteration
    // Runtime  : 3ms        -> + 18.35%
    // Memory   : 61.3MB      -> + 22.77%
    public static int maxProfit3(int[] prices) {
        int left = 0, right = 1;
        int maxProfit = 0;

        while(left < right && right <= prices.length-1) {
            if(prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right]-prices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
