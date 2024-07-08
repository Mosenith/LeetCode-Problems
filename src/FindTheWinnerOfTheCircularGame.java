import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        System.out.println(findTheWinner(6,5));
        System.out.println(findTheWinner2(6,5));
        System.out.println(findTheWinner3(6,5));

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

    // ***************** 2nd Method ******************
    // Approach 2: Using Josephus Problem Iterative Formula
    // Runtime  : 0ms      -> + 100.00%
    // Memory   : 40.34MB  -> + 65.98%
    public static int findTheWinner2(int n, int k) {
        int ans = 0;
        for(int i=1; i<=n; i++) {
            ans = (ans + k) % i;
        }
        return ans+1;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Using queue to store all numbers from 1 to n
    // Until queue.size() = 1, store the removed element before reaching k steps in tmpQueue,
    // Then remove element at k steps, and add all the elements in tmpQueue back to queue
    // If by any chance queue is empty before reaching k steps, add all elements in tmpQueue back to queue
    // Proceed until queue.size() = 1 and return the element
    // Runtime  : 84ms     -> + 5.02%
    // Memory   : 44.20MB  -> + 18.28%
    public static int findTheWinner3(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            Queue<Integer> tmp = new ArrayDeque<>();
            for(int i= 1; i<k; i++) {
                int v = queue.remove();
                tmp.offer(v);
                if(queue.isEmpty()) {
                    while(!tmp.isEmpty()) {
                        queue.offer(tmp.remove());
                    }
                }
            }
            queue.remove();
            while(!tmp.isEmpty()) {
                queue.offer(tmp.remove());
            }
        }

        return queue.peek();
    }
    // ***************** End of 3rd Method ******************
}
