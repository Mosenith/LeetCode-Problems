import java.util.*;
import java.util.stream.Collectors;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray2(arr1,arr2)));
    }

    // ***************** 1st Method ******************
    // Approach : Using TreeMap to store the frequency of elements in arr1
    // Traverse through arr2 and add the elements to ans based on the frequency
    // Traverse through the remaining elements in map and add them to ans
    // Runtime  : 4ms        -> + 21.58%
    // Memory   : 41.97 MB   -> + 53.15%
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int index = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : arr1) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int n : arr2) {
            while(map.containsKey(n) && map.get(n) > 0) {
                ans[index++] = n;
                map.put(n, map.get(n)-1);
                if(map.get(n)==0) map.remove(n);
            }
        }

        List<Integer> ls = map.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
        for(int n : ls) {
            while(map.get(n) > 0) {
                ans[index++] = n;
                map.put(n, map.get(n)-1);
            }
        }

        return ans;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Using TreeMap to store the frequency of elements in arr1
    // Traverse through arr1 and store the element and its position in arr2
    // Sort the arr based on the position
    // Runtime  : 3ms        -> + 42.92%
    // Memory   : 41.97 MB   -> + 53.15%
    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> pos = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; ++i) {
            pos.put(arr2[i], i);
        }
        int[][] arr = new int[arr1.length][0];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new int[] {arr1[i], pos.getOrDefault(arr1[i], arr2.length + arr1[i])};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < arr.length; ++i) {
            arr1[i] = arr[i][0];
        }
        return arr1;
    }
    // ***************** End of 2nd Method ******************
}
