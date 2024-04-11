import java.util.*;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] deck = {17,13,11,2,3,5,7};
        // 1,2,3,4,5 -> 1,5,

        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use deque-arraydequeue to store elements
    // Start from len-1, before adding deck[i] to the first pos in queue,
    // Reverse the first element of queue to last element
    // Runtime  : 4ms       -> + 86.93%
    // Memory   : 43.80MB   -> + 31.65%
    public static int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> queue = new ArrayDeque<>();

        Arrays.sort(deck);

        int len = deck.length;
        for (int i=len-1; i>=0; i--) {
            if(!queue.isEmpty()) {
                queue.offerFirst(queue.pollLast());
            }
            queue.offerFirst(deck[i]);
        }

        int[] ans = new int[len];
        int index = 0;
        while(!queue.isEmpty()) {
            ans[index++]  = queue.pop();
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

}
