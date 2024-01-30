import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs mc = new MinCostClimbingStairs();

        System.out.println(mc.minCostClimbingStairs2(cost));
    }
    // ***************** 1st Method ******************
    // Approach 1: DP & Use Map for memoization
    // Runtime  : 4ms         -> + 8.25%
    // Memory   : 45.04MB     -> + 5.61%
    public int minCostClimbingStairs(int[] cost) {
        // Memoization table to store minimum costs for each position - Map<>
        int min1 = dp(cost, new HashMap<>(),0);
        int min2 = dp(cost, new HashMap<>(), 1);

        return Math.min(min1,min2);
    }
    private int dp(int[] cost, Map<Integer,Integer> memo, int pos) {
        // Check if the minimum cost for this position is already calculated
        if(memo.containsKey(pos)) {
            return memo.get(pos);
        }

        // Base cases: reached the top or beyond
        if(pos >= cost.length) {
            return 0;
        }

        int minSteps1 = cost[pos] + dp(cost,memo,pos+1);
        int minSteps2 = cost[pos] + dp(cost,memo,pos+2);

        int minCost = Math.min(minSteps1,minSteps2);
        memo.put(pos,minCost);

        return minCost;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: DP & Use int[] for memoization
    // Runtime  : 1ms         -> + 49.15%
    // Memory   : 43.22MB     -> + 36.51%
    int[] cost;
    public int minCostClimbingStairs2(int[] cost) {
        // Memoization table to store minimum costs for each position - Map<>

        this.cost = cost;
        int min1 = dp2(new int[cost.length+1],0);
        int min2 = dp2(new int[cost.length+1], 1);

        return Math.min(min1,min2);
    }

    private int dp2(int[] memo, int pos) {
        // Check if the minimum cost for this position is already calculated
        if(pos < memo.length && memo[pos] != 0) {
            return memo[pos];
        }

        // Base cases: reached the top or beyond
        if(pos >= cost.length) {
            return 0;
        }

        int minSteps1 = cost[pos] + dp2(memo,pos+1);
        int minSteps2 = cost[pos] + dp2(memo,pos+2);


        int minCost = Math.min(minSteps1,minSteps2);
        memo[pos] = minCost;

        return minCost;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Use int[] for memoization without helper method
    // Basically, start from i=2 & continue filling minimumCost[i]
    // By find min(cost[i-1] + minimumCost[i-1],cost[i-2] + minimumCost[i-2])
    // Return the minimumCost[cost.length]
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 43.09MB     -> + 58.39%
    public int minCostClimbingStairs3(int[] cost) {
        int minimumCost[]  = new int[cost.length + 1];

        minimumCost[0] = 0;
        minimumCost[1] = 0;

        for(int i = 2; i < minimumCost.length; i++) {
            minimumCost[i] = Math.min(cost[i-1] + minimumCost[i-1],
                    cost[i-2] + minimumCost[i-2]);
        }

        return minimumCost[cost.length];
    }
    //  ***************** End of 3rd Method ******************
}
