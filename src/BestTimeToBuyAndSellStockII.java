public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};    // out = 7
//        int[] prices = {1,2,3,4,5};    // out = 4
        int[] prices = {3,3,5,0,0,3,1,4};   // out = 8

        System.out.println(maxProfit2(prices));
    }

    // ***************** 1st Method ******************
    // Approach : Use 2 pointers - Left(Buy) & Right(Sell) (Left < Right)
    // If p[left] < p[right] => if p[right]-p[left] < curProfit 
    // profit += curProfit, curProfit=0, left = right (move to next index)
    // Otherwise => check if curProfit=0, if not add to profit, then left = right
    // Out-Loop : right++
    // Runtime  : 1ms        -> + 92.10%
    // Memory   : 44.7MB      -> + 27.77%
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int curProfit = 0;
        int left = 0;
        int right = 1;

        while(left < right && right <= prices.length-1) {
            if(prices[left] < prices[right]) {
                if(prices[right]-prices[left] < curProfit) {
                    profit += curProfit;
                    curProfit = 0;
                    left = right;
                } else {
                    curProfit = prices[right]-prices[left];
                }
            } else {
                if(curProfit != 0) {
                    profit += curProfit;
                    curProfit = 0;
                }
                left = right;
            }
            
            right++;
        }

        if(curProfit != 0)
            profit += curProfit;

        return profit;
    }

    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Short Program - loop i < p.len
    // From i = 0 : loop until p[left] < p[right] -> ith position = buy
    // From ith : loop until p[left] >= p[right] -> sell
    // Calculate profit += sell - buy, then move to next loop
    // Runtime  : 2ms        -> + 93.70%
    // Memory   : 61.2MB      -> + 42.63%
    public static int maxProfit2(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];
            System.out.println("i = " + i + " => Buy = " + buy);

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];
            System.out.println("i = " + i + " => Sell = " + sell);

            profit += sell - buy;
            System.out.println("Profit = " + profit);
            System.out.println("************************************");
        }
        return profit;
    }

}
