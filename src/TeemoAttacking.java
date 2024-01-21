import java.util.Stack;

public class TeemoAttacking {
    public static void main(String[] args) {
        int[] timeSeries = {1,2,3,4,5};
        int duration = 5;

        TeemoAttacking ta = new TeemoAttacking();
        System.out.println(ta.findPoisonedDuration(timeSeries,duration));
    }

    // ***************** 1st Method ******************
    // Approach 1: Find min of duration & timeSeries[i] - timeSeries[i - 1] => += ans
    // Runtime  : 2ms         -> + 98.89%
    // Memory   : 44.86MB     -> + 68.66%
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ans = duration;
        for (int i = 1; i < n; ++i) {
            ans += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

}
