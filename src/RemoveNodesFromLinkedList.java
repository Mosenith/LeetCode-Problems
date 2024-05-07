import java.util.*;

public class RemoveNodesFromLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    public static void printList(ListNode node) {
        while (node != null)
        {
            System.out.print(node.val + " —> ");
            node = node.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        // head = [5,2,13,3,8] -> [1,2,3]
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);

        printList(removeNodes(head));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use dummy listnode with max element as initial head
    // Use ArrayDeque stk and offer dummy, then loop from head till head==null
    // Check if stk.peeklast.val < cur.val, remove one by one till condition false
    // Have stk.peek.next points to cur, then stk.offerLast(cur)
    // This stk will always have one element which is dummy initial max head
    // Return dummy.next;
    // Runtime  : 20m      -> + 36.69%
    // Memory   : 61.89MB  -> + 90.13%
    public static ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(1 << 30, head);
        Deque<ListNode> stk = new ArrayDeque<>();
        stk.offerLast(dummy);

        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!stk.isEmpty() && stk.peekLast().val < cur.val) {
                stk.pollLast();
            }
            if (!stk.isEmpty()) {
                stk.peekLast().next = cur;
            }
            stk.offerLast(cur);
        }
        return dummy.next;
    }
    // ***************** End of 1st Method ******************


}
