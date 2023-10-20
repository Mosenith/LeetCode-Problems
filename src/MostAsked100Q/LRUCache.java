package MostAsked100Q;

import java.util.*;

// Least Recently Used (LRU) cache
public class LRUCache {
    // ***************** 1st Method ******************
    // Approach 1: Use map to store the key-value pair
    // Have Queue to keep track of the usage of each key
    // Least usage key will be at the front
    // Runtime  : Work but Exceed time limit
    HashMap<Integer, Integer> map;
    Integer maxCap;
    Queue<Integer> queue;
    Map<Integer,Integer> store;
    // capacity > 0
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.maxCap = capacity;
        queue = new ArrayDeque<>();
        store = new LinkedHashMap<>();
    }

    // key.exist => key, otherwise => -1
    public int get(int key) {
        store.computeIfPresent(key, (k,v) -> v+1);
        return (map.containsKey(key)) ? map.get(key) : -1;
    }

    // key.exist => update value
    // otherwise, key-value => cache
    // num.keys > capacity => key.RemoveLast
    public void put(int key, int value) {
        if(maxCap == map.size() && !store.containsKey(key)) {
            map.remove(queue.poll());
        }
        map.computeIfPresent(key, (k,v) -> value);
        map.computeIfAbsent(key, v -> value);

        store.computeIfPresent(key, (k,v) -> v + 1);
        store.computeIfAbsent(key, v -> 1);
    }

    private int getLeastUsed() {
        return 0;
    }
    // ***************** End of 1st Method ******************

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(2,1);
        lRUCache.put(1,1);

        System.out.println(lRUCache.map);

        lRUCache.put(2,3);

        System.out.println(lRUCache.map);

        lRUCache.put(4,1);

        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));

    }
}
// [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

// [null,null,null,null,null,-1,3]

/*
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

*/
