import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};

        System.out.println(findMaximizedCapital2(2, 0, profits, capital));
    }
    // ***************** 1st Method ******************
    // Approach 1: Iterate k times, find the max profit that can be added to w
    // Iterate through profits, if capital[i] <= w, check if profits[i] > maxProfit
    // If yes, update maxProfit and index
    // Add profits[index] to w, set profits[index] to 0, decrement k
    // Runtime  : Exceeded time limit
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        while(k > 0) {
            int maxProfit = 0;
            int index = -1;
            for(int i=0; i<profits.length; i++) {
                if(capital[i] <= w) {
                    if(profits[i] > maxProfit) {
                        maxProfit = profits[i];
                        index = i;
                    }
                }
            }
            if(index == -1) {
                break;
            }
            w += profits[index];
            profits[index] = 0;
            k--;
        }
        return w;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 priority queues, one for capital and one for profits, sort by capital and profit
    // Add all capital and profits to pqCap, iterate k times, add all capital <= w to pqPro
    // Add profits to w, decrement k, repeat
    // Runtime  : 4ms       -> + 86.93%
    // Memory   : 43.80MB   -> + 31.65%
    public static int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i=0; i<profits.length; i++) {
            pqCap.offer(new int[]{capital[i], profits[i]});
        }

        for(int i=0; i<k; i++) {
            while(!pqCap.isEmpty() && pqCap.peek()[0] <= w) {
                pqPro.offer(pqCap.poll());
            }

            if(pqPro.isEmpty()) {
                break;
            }

            w += pqPro.poll()[1];
        }
        return w;
    }
    //  ***************** End of 2nd Method ******************
}
