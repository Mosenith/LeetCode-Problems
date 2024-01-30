public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        MinCostClimbingStairs mc = new MinCostClimbingStairs();

        System.out.println(mc.minCostClimbingStairs(cost));
    }
    public int minCostClimbingStairs(int[] cost) {

        int m1 = dp(cost,0);
        System.out.println("********");
        int m2 = dp(cost,1);

        System.out.println(m1 + " : " + m2);
        return -1;
    }

    private int dp(int[] cost, int pos) {
        System.out.println("Cur pos = " + pos);
        if(pos >= cost.length)
            return 0;

        int minSteps = cost[pos];
        minSteps += Math.min(dp(cost,pos+1), dp(cost,pos+2));

        return minSteps;
    }
}
