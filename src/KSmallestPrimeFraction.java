import java.util.*;

public class KSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;

        System.out.println(Arrays.toString(kthSmallestPrimeFraction2(arr,k)));
//        System.out.println(Arrays.toString(kthSmallestPrimeFraction3(arr,k)));

    }

    // ***************** 1st Method ******************
    // Approach 1: Use list of float to store all possible fractions
    // Use map to store each fraction and its numerator and denominator
    // Sort list and return kth element from map
    // Runtime  : 653ms     -> + 9.60%
    // Memory   : 184.24MB  -> + 5.24%
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<Float> list = new ArrayList<>();
        Map<Float,Integer[]> map = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                float num = (float) arr[i]/arr[j];
                list.add(num);
                map.put(num,new Integer[]{arr[i],arr[j]});
            }
        }
        Collections.sort(list);
        Integer[] result = map.get(list.get(k-1));
        return new int[]{result[0], result[1]};
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use binary search to find kth smallest fraction
    // Use two pointers to find maxFractionLessThanMid
    // Within the loop to find maxFractionLessThanMid, update total
    // If total == k, return the fraction
    // If total > k, update high = mid
    // If total < k, update low = mid
    // Runtime  : 3ms      -> + 96.47%
    // Memory   : 42.22MB  -> + 78.59%
    public static int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int[] res = new int[2];
        int len = arr.length;
        double low = 0;
        double high = 1.0;

        while(low<=high) {
            double mid = low + (high-low)/2;
            // maxFranction <= mid
            double maxFractionLessThanMid = 0.0;
            int total = 0;
            int num = 0, den = 0;
            int j=1;

            for(int i=0; i<len; i++) {
                while(j<len && arr[i]>=arr[j]*mid) {
                    ++j;
                }
                total += len-j;
                // update maxFractionLessThanMid if fraction > maxFractionLessThanMid
                if(j<len && maxFractionLessThanMid < arr[i]*1.0/arr[j]) {
                    maxFractionLessThanMid = arr[i]*1.0/arr[j];
                    num = i;
                    den = j;
                }
            }
            if(total == k) {
                res[0] = arr[num];
                res[1] = arr[den];
                break;
            }
            if(total > k) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return res;
    }
    // ***************** End of 2nd Method ******************
}
