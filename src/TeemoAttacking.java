import java.util.Stack;

public class TeemoAttacking {
    public static void main(String[] args) {
        int[] timeSeries = {1,2,3,4,5};
        int duration = 5;

        TeemoAttacking ta = new TeemoAttacking();
        System.out.println(ta.findPoisonedDuration(timeSeries,duration));
    }
    // 1, 1+5-1 = 5
    // 2, 2+5-1 = 6
    // 3, 3+5-1 = 7
    // 4, 4+5-1 = 8
    // 5, 5+5-1 = 9
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ans = duration;
        for (int i = 1; i < n; ++i) {
            ans += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return ans;
    }
}
