package MostAsked100Q;

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
         while(head != null) {
             System.out.print(head.val + " ");
             head = head.next;
         }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

//        printListNode(head);
        printListNode(sortList(head));
    }

    // treeset not support duplicate val
    public static ListNode sortList(ListNode head) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        while(head != null) {
            treeSet.add(head.val);
            head = head.next;
        }

//        System.out.println(treeSet);

        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while(!treeSet.isEmpty()) {
            dummy.next = new ListNode(treeSet.pollFirst());
            dummy = dummy.next;
        }

        return ans.next;
    }
}
