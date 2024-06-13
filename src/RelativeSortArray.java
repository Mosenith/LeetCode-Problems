import java.util.*;
import java.util.stream.Collectors;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
    }

    // ***************** 1st Method ******************
    // Approach : Start from i=0 to nums.len
    // Inner loop, keep count of element >=i, if by some points cnt>i, break
    // Out of inner loop if cnt=i, return cnt
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

}
