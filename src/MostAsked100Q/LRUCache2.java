package MostAsked100Q;

import java.util.HashMap;
import java.util.Map;
public class LRUCache2 {
    // ***************** 2nd Method ******************
    // Approach 2: Use Double Linked List to keep track of least recently used key
    // Use 2 dummy nodes -> left & right
    // Update left % right when use put() or get()
    // Before put(), check cap. If over Cap => remove right.prev
    // Runtime  : 54ms           -> + 15.45%
    // Memory   : 116.1 MB        -> + 88.83%
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {
        }
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> cache;
    Integer cap;
    Node left;
    Node right;
    public LRUCache2(int capacity) {
        cache = new HashMap<>(capacity);
        cap = capacity;

        // Left -> LRU
        left = new Node(-1,-1);
        right = new Node(-1,-1);
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node tmp = cache.get(key);
            cache.remove(key);
            removeNode(tmp);
            insertNode(tmp);
            cache.put(key,tmp);
            return cache.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node tmp = cache.get(key);
            cache.remove(key);
            removeNode(tmp);
        }

        if(cache.size() == cap) {
            Node lru = right.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }

        Node addedNode = new Node(key,value);
        cache.put(key, addedNode);
        insertNode(addedNode);
    }

    public void removeNode(Node node) {
        Node prv = node.prev;
        Node nxt = node.next;

        prv.next = nxt;
        nxt.prev = prv;
    }

    public void insertNode(Node node) {
        Node temp = left.next;

        node.next = temp;
        node.prev = left;

        temp.prev = node;
        left.next = node;
    }
}
