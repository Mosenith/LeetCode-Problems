import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(maxFrequencyElements(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Count each element frequency and store in map
    // Then, convert values() to sorted list and count freq from len-1
    // If ls.get(len-2) == ls.get(len-1), add to freq, otherwise break
    // Runtime  : 8ms         -> + 5.45%
    // Memory   : 42.14MB     -> + 66.22%
    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // Using streams to convert map values to a sorted list
        List<Integer> ls = map.values()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        int prevMax = ls.get(ls.size()-1);
        int freq = prevMax;

        for(int i=ls.size()-2; i>=0; i--) {
            if(ls.get(i) == prevMax) {
                freq += prevMax;
            } else {
                break;
            }
        }

        return freq;
    }
    //  ***************** End of 1st Method ******************

}
