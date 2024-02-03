import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[]  arr = {1,4,1,5,7,3,6,1,9,9,3};
        int k = 4;

        System.out.println(maxSumAfterPartitioning(arr,k));
    }

    // 9 * 3 = 27
    // 9 * 3 = 27
    // 7 * 3 = 21
    // 6 * 2 = 12
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len+1];

        for(int i=0; i<len; i++) {

            // partition of arr must have #elements < k
            for(int j=i; j<())
        }

        return dp[len];
    }
}


// or (int) Math.ceil((float) arr.length / k)
