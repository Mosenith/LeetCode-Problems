import java.util.*;

public class FindTheTownJudge {
    public static void main(String[] args) {
        // 3
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int n = 4;

        System.out.println(findJudge2(n,trust));
    }

    // ***************** 1st Method : Need to Optimized More ******************
    // Approach 1: Calculate totalSum of n and trust-sum of trust[i][0]
    // while check if trust[i][0] is added before, map should contain key trust[i][0]
    // If totalSum=trustSum, return -1, otherwise our tmpAns = totalSum - trustSum
    // Still need to check if tmpAns is trusted by all people in the town
    // So if trust[i][1] != ans && !map.get(trust[i][0]).contains(ans) return -1
    // Otherwise tmpAns is the judge
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

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 arrays - inNode[] stores incoming node to i pos
    // outNode[] store outcome from i pos. Then loop through both arrays at once
    // If at i-th pos inNode[i]=n-1 & outNode[i]=0, return i, otherwise -1
    // Runtime  : 3ms        -> + 71.20%
    // Memory   : 54.09MB    -> + 27.13%
    public static int findJudge2(int n, int[][] trust) {
        int[] inNode = new int[n+1];
        int[] outNode = new int[n+1];

        for(int[] relation : trust) {
            inNode[relation[1]]++;
            outNode[relation[0]]++;
        }

        // loop through inNode & outNode, at a pos i, inNode[i]=n-1 & outNode[i]=0
        for(int i=1; i<=n; i++) {
            if(inNode[i] == n-1 && outNode[i] == 0) {
                return i;
            }
        }

        // otherwise return -1
        return -1;
    }
    //  ***************** End of 2nd Method ******************
}
