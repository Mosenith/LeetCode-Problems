import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4,5,6,7));
//        list.add(Arrays.asList(2, 3));

        System.out.println(maxDistance(list));
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

}
