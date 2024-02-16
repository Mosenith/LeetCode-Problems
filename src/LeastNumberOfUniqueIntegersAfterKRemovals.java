import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        // Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;

        System.out.println(findLeastNumOfUniqueInts(arr,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use map to store element in arr[] and its occurrence
    // Sort map based on each element occurrences and remove from the lowest occurrences
    // Return map size
    // Runtime  : 66ms           -> + 26.39%
    // Memory   : 82.18MB        -> + 14.30%
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : arr) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        // Sort the entries based on their values (occurrences)
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());

        // Print the sorted entries
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            if(entry.getValue() <= k) {
                k -= entry.getValue();
                map.remove(entry.getKey());
            }
            if(k == 0)
                break;
        }
        return map.size();
    }
    //  ***************** End of 1st Method ******************

}
