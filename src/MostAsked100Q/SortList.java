package MostAsked100Q;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class SortList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

//        printListNode(head);
        printListNode(sortList2(head));
    }

    // ***************** 1st Method ******************
    // Approach 1: Copy ListNode to ArrayList
    // Use collections.sort() and transform it back to ListNode
    // Runtime  : 1ms            -> + 99.68%
    // Memory   : 40.71MB        -> + 89.16%
    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        int i = 0;
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while (i < list.size()) {
            dummy.next = new ListNode(list.get(i++));
            dummy = dummy.next;
        }

        return ans.next;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Merge Sort on ListNode
    // Runtime  : 9ms            -> + 89.64%
    // Memory   : 56.78MB        -> + 9.29%
    public static ListNode sortList2(ListNode head) {
        if(head == null || head.next == null) return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // prev - 4,2
        // slow - 1,3
        prev.next = null;
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(slow);

        ListNode ans = merge(l1,l2);
        return ans;
    }
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1 != null) {
            dummy.next = l1;
        }

        if(l2 != null) {
            dummy.next = l2;
        }

        return ans.next;
    }
    // ***************** End of 2nd Method ******************
}
