package MostAsked100Q;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;


public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode extraNode1 = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        ListNode extraNode2 = head.next.next.next;
        extraNode2.next = extraNode1;
//        head.next.next.next.next = new ListNode(2);

        System.out.println(hasCycle2(head));
    }

    // ***************** 1st Method : HashMap ******************
    // Approach : make a slower pointer and a faster pointer
    // if the fast pointer catch up with slow pointer, then it's a circular linked list
    // if the fast pointer get to the end, then it's not a circular linked list
    // Runtime  : 0ms           -> + 100%
    // Memory   : 43.80 MB      -> + 35.32%
    // Time : O(n), Space: O(1)
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // An empty list or a list with only one node cannot have a cycle
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected, the two pointers have met
            }
            System.out.println(slow.val);
            System.out.println(fast.val);
        }

        return false; // No cycle found
    }
    // ***************** End of 1st Method ******************

    // This is comparing value, no reference
    // Not a valid solution
    public static boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        Set<Integer> store = new HashSet<>();
        while(head != null) {
            if(store.isEmpty() || !store.contains(head.val)) {
                store.add(head.val);
            } else {
                return true;
            }
            head = head.next;
        }

        return false;
    }
}

