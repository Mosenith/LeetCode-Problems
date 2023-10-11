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

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next;
        head.next.next = null;
        head.random = head.next;

        Node ans = copyRandomList(head);
        printNode(ans);
    }

    static List<Node> nextList = new ArrayList<>();
    static List<Node> randList = new ArrayList<>();
    static int counter = 0;

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Node tmp = head;
        fillUp(tmp);

        Node ans = nextList.remove(counter);
        Node curCopy = ans;

        helperNext(curCopy);
        counter = 0;
        helperRand(curCopy);

        return ans;
    }

    private static void helperNext(Node curCopy) {
        while(!nextList.isEmpty() && counter+1 < nextList.size()) {
            curCopy.next = nextList.remove(++counter);
        }
    }

    private static void helperRand(Node curCopy) {
        while(!randList.isEmpty() && counter+1 < randList.size()) {
            curCopy.random = randList.remove(++counter);
        }
    }
    private static void fillUp(Node head) {
        nextList.add(head);
        while(head != null) {
            if(head.next == null) {
                nextList.add(null);
            } else {
                nextList.add(head.next);
            }

            if(head.random == null) {
                randList.add(null);
            } else {
                randList.add(head.random);
            }
            head = head.next;
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
}
