import java.util.*;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null && n == 1) return null;

        // count head size
        ListNode temp = head;
        int count = 0;
        while(temp != null && temp.next != null) {
            temp = temp.next;
            count++;
        }
        // position to delete
        int pos = count - n;
        System.out.println("count = " + count + ", pos = " + pos);
        // not necessary will be executed since we already put up the condition on the first line above
        if(pos < 0) {
            head = head.next;
            return head;
        }
        ListNode ans = head;
        for(int i=0; i<pos; i++) {
            ans = ans.next;
//            System.out.println("ans.val = " + ans.val);
        }
        // skip the position to delete
        ans.next = ans.next.next;
//        System.out.println("Off loop : ans.val = " + ans.next.val);
//        System.out.println("head.val = " + head.next.next.next.val);  // Here skip pos to delete and print the next

        return head;

    }
    public static class ListNode {
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

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode slow, fast, curr;
        slow = head; fast = head;

        // ListNode fast = 1 -> 2 -> 3
        System.out.print("1st Loop : ");
        for (int i = 0; i < n; i++) {
            System.out.print(fast.val + " ");
            fast = fast.next;
        }

        System.out.println(fast.val);

        // n == len
        if (fast == null) {
            head = head.next;
            return head;
        }

        // Move both pointers, until reach tail
        System.out.print("Slow Node : ");
        while (fast.next != null) {
            fast = fast.next;
            System.out.print(slow.val + " ");
            slow = slow.next;
        }

        System.out.println(slow.val);
        curr = slow.next;   // slow.next is the deletion node
        slow.next = curr.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode theList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
//        ListNode theList = new ListNode(1);
//        int n = 1;

        ListNode resultList = removeNthFromEnd(theList, n);
        System.out.println("********* Result *********");
        while(resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
