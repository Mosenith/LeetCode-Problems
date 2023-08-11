package MostAsked100Q;

public class ReverseLinkedList {
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

    public static void main(String[] args) {
        ListNode myNode = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));

        printListNode(reverseList(myNode));
    }

    private static void printListNode(ListNode myNode) {
        while (myNode != null) {
            System.out.println(myNode.val);
            myNode = myNode.next;
        }
        System.out.println("~~~~~~~~");
    }

    // ***************** 1st Method ******************
    // Approach : Very Basic & Efficient Approach
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.98 MB      -> + 40.98%
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
