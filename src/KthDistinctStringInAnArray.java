import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;

        System.out.println(kthDistinct(arr,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Read each string in the array and store it in a map
    // Loop through the array and check if the string is unique (value=1)
    // If it is unique, decrement k and check if k is 0, if so return the string
    // If there's no unique string, use System.gc() to clear the memory
    // Return an empty string
    // Runtime  : 6ms      -> + 89.11%
    // Memory   : 42.44MB  -> + 99.98%
    public static String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new HashMap<>();

        for(String s : arr) {
            map.put(s, map.getOrDefault(s,0)+1);
        }

        for(String s : arr) {
            if(map.get(s) == 1) {
                k--;
                if(k == 0) {
                    return s;
                }
            }
        }
        System.gc();
        return "";
    }
    //  ***************** End of 1st Method ******************
}
