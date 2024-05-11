import java.util.*;

public class KSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;

        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr,k)));
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

}
