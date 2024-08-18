import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(1,4));
        list.add(Arrays.asList(0,5));
//        list.add(Arrays.asList(2, 3));

        System.out.println(maxDistance(list));
        System.out.println(maxDistance2(list));
    }

    // ***************** 1st Method ******************
    // Approach 1: Sort the arrays in ascending order and store it in a new list
    // Sort the arrays in descending order and store it in a new list
    // Check if the first element of the descending list is not the same as the ascending list
    // If it is not the same, get the max distance between the last element of the descending list
    // and the first element of the ascending list
    // If it is the same, get the max distance between the last element of the descending list
    // and the second element of the ascending list
    // Get the max distance between the last element of the second descending list
    // and the first element of the ascending list
    // Runtime  : 67ms     -> + 5.06%
    // Memory   : 65.38MB  -> + 16.46%
    public static int maxDistance(List<List<Integer>> arrays) {
        int maxDis;

        arrays.sort(Comparator.comparing(a -> a.get(0)));
        List<List<Integer>> asc = new ArrayList<>(arrays);

        arrays.sort((a, b) -> b.get(b.size()-1).compareTo(a.get(a.size()-1)));
        List<List<Integer>> desc = new ArrayList<>(arrays);

        int len = desc.get(0).size();
        if(asc.get(0) != desc.get(0)) {
            maxDis = desc.get(0).get(len-1) - asc.get(0).get(0);
        } else {
            int m1 = 0;
            int m2 = 0;
            if(asc.size() > 1) {
                m1 = desc.get(0).get(len-1) - asc.get(1).get(0);
            }
            if(desc.size() > 1) {
                int len2 = desc.get(1).size();
                m2 = desc.get(1).get(len2-1) - asc.get(0).get(0);
            }

            maxDis = Math.max(m1,m2);
        }
        return maxDis;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Get the first array and store the min and max values
    // Iterate through the remaining arrays (from i=1) and store the current min and max values
    // Calculate the possible max distances by comparing maxDistance, max_0 - currentMin, and currentMax - min_0
    // Update the min and max values for future comparisons
    // Runtime  : 5ms      -> + 98.94%
    // Memory   : 64.22MB  -> + 80.71%
    public static int maxDistance2(List<List<Integer>> arrays) {
        int len = arrays.size();
        int min_0 = arrays.get(0).get(0);
        int max_0 = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        // Iterate through the remaining arrays
        for (int i = 1; i < len; i++) {
            List<Integer> arr = arrays.get(i);
            int currentMin = arr.get(0);
            int currentMax = arr.get(arr.size() - 1);

            // Calculate the possible max distances
            maxDistance = Math.max(maxDistance, Math.abs(max_0 - currentMin));
            System.out.println("1st => " + maxDistance);
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - min_0));
            System.out.println("2nd => " + maxDistance);

            // Update the min_0 and max_0 for future comparisons
            min_0 = Math.min(min_0, currentMin);
            max_0 = Math.max(max_0, currentMax);
        }

        return maxDistance;
    }
    //  ***************** End of 2nd Method ******************
}