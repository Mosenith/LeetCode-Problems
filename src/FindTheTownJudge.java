import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
    public static void main(String[] args) {
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int n = 4;

        System.out.println(findJudge(n,trust));
    }

    // ***************** 1st Method : Need to Optimized More ******************
    // Approach 1:
    // Runtime  : 33ms       -> + 5.11%
    // Memory   : 54.77MB    -> + 6.10%
    public static int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n != 1) return -1;

        int total = (n*(n+1))/2;
        int trustSum = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0; i<trust.length; i++) {
            if(map.isEmpty() || !map.containsKey(trust[i][0])) {
                trustSum += trust[i][0];
            }
            map.put(trust[i][0], map.getOrDefault(trust[i][0],new HashSet<>()));
            map.get(trust[i][0]).add(trust[i][1]);
        }

        int ans = total == trustSum ? -1 : total - trustSum;

        for(int i=0; i<trust.length; i++) {
            if(trust[i][1] != ans && !map.get(trust[i][0]).contains(ans)) {
                return -1;
            }
        }

        return ans;
    }
    //  ***************** End of 1st Method ******************

}
