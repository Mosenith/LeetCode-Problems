namespace LeetCodeCSharp;

using System;
using System.Collections.Generic;

class RevealCardsInIncreasingOrder {
    static int[] DeckRevealedIncreasing(int[] deck) {
        LinkedList<int> queue = new LinkedList<int>();

        Array.Sort(deck);

        int len = deck.Length;
        for (int i = len - 1; i >= 0; i--) {
            if (queue.Count > 0) {
                int last = queue.Last.Value;
                queue.RemoveLast();
                queue.AddFirst(last);
            }
            queue.AddFirst(deck[i]);
        }

        int[] ans = new int[len];
        int index = 0;
        foreach (int num in queue) {
            ans[index++] = num;
        }
        return ans;
    }
}

