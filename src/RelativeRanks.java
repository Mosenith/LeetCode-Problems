import java.util.*;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = {5,4,3,2,1};

        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use map to store each score and its position
    // Sort score[] and work from i=len-1 to len-3, has fixed output
    // Otherwise, have ranks[map.get(score[i]) = outRank++, initial outRank=4
    // Runtime  : 8m      -> + 80.99%
    // Memory   : 45.75MB -> + 28.80%
    public static String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<score.length; i++) {
            map.put(score[i], i);
        }

        Arrays.sort(score);
        String[] ranks = new String[score.length];
        int outRank = 4;
        for(int i=score.length-1; i>=0; i--) {
            int curScore = score[i];
            if(i==score.length-1) {
                ranks[map.get(curScore)] = "Gold Medal";
            } else if(i==score.length-2) {
                ranks[map.get(curScore)] = "Silver Medal";
            } else if(i==score.length-3) {
                ranks[map.get(curScore)] = "Bronze Medal";
            } else {
                ranks[map.get(curScore)] = String.valueOf(outRank++);
            }
        }
        return ranks;
    }
    // ***************** End of 1st Method ******************

}
