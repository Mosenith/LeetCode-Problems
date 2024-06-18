import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int[] difficulty = {7,20,68};
        int[] profit = {26,28,57};
        int[] worker = {71,20,71};

        System.out.println(maxProfitAssignment(difficulty,profit,worker));
    }

    // ***************** 1st Method ******************
    // Approach 1:
    // Work but exceed time limit
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, List<Integer>> difWorker = new HashMap<>();

        for(int i=0; i<difficulty.length; i++) {
            int level = difficulty[i];
            difWorker.put(i, new ArrayList<>());
            for(int j=0; j<worker.length; j++) {
                if(worker[j] >= level) {
                    difWorker.get(i).add(j);
                }
            }
        }
        Map<Integer,Integer> profitMap = new HashMap<>();
        for(int i=0; i<profit.length; i++) {
            List<Integer> tmp = difWorker.get(i);
            if(tmp.isEmpty()) continue;
            for(int n : tmp) {
                profitMap.put(n, Math.max(profitMap.getOrDefault(n,0),profit[i]));
            }
        }

        int maxProfit = 0;
        for(int p : profitMap.values()) {
            maxProfit += p;
        }
        return maxProfit;
    }
    //  ***************** End of 1st Method ******************

}

// 57 + 57 = 114 + 28 = 142