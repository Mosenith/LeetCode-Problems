import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 1;

        System.out.println(maximumHappinessSum(happiness,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Sort array & work from right to left while check if turns<k
    // Each iteration check arr[i]-turn<0, break, otherwise, ans += arr[i]-turns
    // Runtime  : 34m      -> + 97.44%
    // Memory   : 61.21MB  -> + 87.76%
    public static long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int turns = 0;

        Arrays.sort(happiness);
        for(int i=happiness.length-1; i>=0 && turns<k; i--) {
            if(happiness[i] - turns < 0) break;
            ans += happiness[i] - turns;
            turns++;
        }
        return ans;
    }
    // ***************** End of 1st Method ******************

}
