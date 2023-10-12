package MostAsked100Q;

import java.util.*;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    private static void printNode(Node node) {
        while (node != null) {
            System.out.println("Val = " + node.val);
            if (node.next == null) {
                System.out.println("Next = " + null);
            } else {
                System.out.println("Next = " + node.next.val);
            }

            if (node.random == null) {
                System.out.println("Random = " + null);
            } else {
                System.out.println("Random = " + node.random.val);
            }
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node ans = copyRandomList(head);
        printNode(ans);
    }

    static List<Node> nextList = new ArrayList<>();
    static List<Node> randList = new ArrayList<>();
    static int counter = 0;

    // ***************** 1st Method ******************
    // Approach 1: HashMap with k=head(cur in loop), v=tail
    // Create TempNode and assign val to 0
    // Create tailNode and assign to TempNode
    // 1st loop consider head.next & have tailNode.next = head.next
    // End of loop => tail stores the last node of root(head)
    // Assign tail = TempNode.next (TempNode=0, TempNode.next = head)
    // 2nd Loop consider head.random & tail.random = map.get(head.random)
    // End of loop return TempNode.next
    // Runtime  : 0ms           -> + 100%
    // Memory   : 43.28 MB        -> + 39.96%
    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node tmp = new Node(0);
        Node tail = tmp;

        for(Node cur = head; cur != null; cur = cur.next) {
            tail.next = new Node(cur.val);
            tail = tail.next;
            map.put(cur,tail);
        }

        tail = tmp.next;

        for(Node cur = head; cur != null; cur = cur.next) {
            tail.random = map.get(cur.random);
            tail = tail.next;
        }

        return tmp.next;
    }
    // ***************** End of 1st Method ******************
}
