import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        System.out.println(findTheWinner(6,5));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init ls to store all numbers from 1 to n
    // Until ls.size() > 1, remove element after k steps
    // Loop from 1 to k while incrementing curIndex, if curIndex >= ls.size(), set curIndex to 0
    // Remove element at curIndex-1 (or curIndex if curIndex=0) from ls
    // Update curIndex to curIndex-1 if curIndex is != ls.size(), else set curIndex to 0
    // Runtime  : 12ms      -> + 31.33%
    // Memory   : 41.16MB   -> + 27.08%
    public static int findTheWinner(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            ls.add(i);
        }

        int curIndex = 0;
        while(ls.size() > 1) {
            for(int i=1; i<=k; i++) {
                if(curIndex >= ls.size()) {
                    curIndex = 0;
                }
                curIndex++;
            }

            int obj = curIndex == 0 ? ls.get(0) : ls.get(curIndex-1);
            ls.remove((Integer) obj);

            if(curIndex-1 == ls.size()) {
                curIndex = 0;
            } else {
                curIndex--;
            }
        }
        return ls.get(0);
    }
    // ***************** End of 1st Method ******************
}
