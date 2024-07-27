import java.util.HashMap;
import java.util.Map;

public class MinimumCostToConvertStringI {
    public static void main(String[] args) {

    }

    // Build Directed Graph with weights
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // store the cost of changing the character(source[i] + target[i])
        Map<Character,Character> mapDestiny = new HashMap<>();
        Map<Character,Integer> mapCost = new HashMap<>();

        for(int i=0; i<original.length; i++) {
            mapDestiny.put(original[i],changed[i]);
            mapCost.put(original[i],cost[i]);
        }

        return 0;
    }
}
