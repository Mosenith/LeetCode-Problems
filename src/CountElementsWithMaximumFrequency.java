import java.util.*;
import java.util.stream.Collectors;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};

        System.out.println(maxFrequencyElements2(nums));
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

    // ***************** 2nd Method ******************
    // Approach 2: Sort given array first and loop through the array
    // Count the duplicate element while keeping tract of the maxFreq, also add all freq to the list
    // Loop through the list while comparing to the maxFreq, if equal, plus to the ans
    // Runtime  : 2ms         -> + 70.78%
    // Memory   : 42.07MB     -> + 79.03%
    public static int maxFrequencyElements2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int maxFreq = 0;
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            int freq = 1;
            while(i+1<nums.length && nums[i+1] == cur) {
              freq++;
              i++;
            }
            maxFreq = Math.max(maxFreq, freq);
            ls.add(freq);
        }

        for(int n : ls) {
            if(maxFreq == n) {
                count += n;
            }
        }
        return count;
    }
    //  ***************** End of 2nd Method ******************
}
