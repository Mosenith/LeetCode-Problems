public class MiddleOfTheLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    // Utility function to print contents of a linked list
    public static void printList(ListNode node) {
        while (node != null)
        {
            System.out.print(node.val + " —> ");
            node = node.next;
        }
        System.out.print("null");
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode (1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5, new ListNode(6))))));

        printList(middleNode(l2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use slow(head) and fast list node, with slow moving 1 node at a time
    // fast ListNode moving 2 at a time, if fast.next == null break, return slow
    // Runtime  : 0ms           -> + 100.00%
    // Memory   : 41.46MB       -> + 8.39%
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }

        return head;
    }
    //  ***************** End of 1st Method ******************
}
