package MostAsked100Q;

import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoLinkedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode nextListNode) {
            val = x;
            next = nextListNode;
        }
    }

    public static void main(String[] args) {
        ListNode comNode = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode l1 = new ListNode(4, new ListNode(1));
        l1.next = comNode;
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(1)));
        l2.next = comNode;

        printNode(getIntersectionNode3(l1,l2));
    }

    private static void printNode(ListNode intersectionNode) {
        while(intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }

    // ***************** 1st Method : HashMap ******************
    // Approach 1: Clean & Great Approach
    // By the time a or b (copy of ListNodes) reaches null,
    // it's  assigned to the other (original) ListNode
    // When the other copy reaches null and is assigned to another ListNode,
    // They bothe will start from the same length,
    // therefore will reach the same common listNode if intersection exists
    // Runtime  : 1ms           -> + 99.98%
    // Memory   : 47.34 MB      -> +  9.55%
    // Time : O(n), Space: O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: HashSet to store nodeA, then loop nodeB
    // if contain in hashset, return nodeB
    // Runtime  : 5ms           -> + 27.18%
    // Memory   : 46.88 MB      -> + 55.39%
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> storeA = new HashSet<>();

        while(headA != null) {
            storeA.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(storeA.contains(headB))
                return headB;

            headB = headB.next;
        }

        return null;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: A little long but Classic approach:
    // Find lenght of both nodes, get the diff., the longer listnode can skip diff. nodes
    // Start looping one by one and compare the 2 listnodes
    // Runtime  : 1ms           -> + 99.98%
    // Memory   : 46.64 MB      -> + 77.82%
    // Time : O(n), Space: O(1)
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode a = headA, b = headB;

        while(a != null) {
            l1++;
            a = a.next;
        }
        while(b != null) {
            l2++;
            b = b.next;
        }
        if(l1 > l2) {
            int dif = l1 - l2;
            while(dif > 0) {
                headA = headA.next;
                dif--;
            }
        } else {
            int dif = l2 - l1;
            while(dif > 0) {
                headB = headB.next;
                dif--;
            }
        }

        while(headA != null && headB != null) {
            if(headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
    // ***************** End of 3rd Method ******************
}
