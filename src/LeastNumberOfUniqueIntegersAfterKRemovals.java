import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        // Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;

        System.out.println(findLeastNumOfUniqueInts2(arr,k));
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
            if(k <= 0)
                break;
        }
        return map.size();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Optimized 1st method by using List<Integer> of map.values instead of List<Entry>
    // Sort this list and iterate from i=0 till i<list.size & if k<0 return len-i
    // Each iteration k-=list(i) and if out of loop return 0
    // Runtime  : 37ms       -> + 92.29%
    // Memory   : 56.70MB    -> + 80.19%
    public static int findLeastNumOfUniqueInts2(int[] arr, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();

        // Count the frequency of each element
        for (int x : arr) {
            cnt.merge(x, 1, Integer::sum);
        }

        // Get value() in map to List & sort it
        List<Integer> nums = new ArrayList<>(cnt.values());
        Collections.sort(nums);

        // Remove value from the smallest till k<0;
        for(int i=0, len=nums.size(); i<len; i++) {
            k -= nums.get(i);

            //**Important** Need to loop till k<0 cos i starts from 0
            // And we want to stop removing elements once we have removed exactly k elements
            if(k < 0) {
                return len-i;
            }
        }

        // If out of loop means we need to remove everything in the arr[]
        return 0;
    }
    //  ***************** End of 2nd Method ******************
}
