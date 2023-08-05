public class ReverseLinkedListIterative {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        ListNode cur = head;

        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode (1, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(3)))));
        ListNode l2 = new ListNode (1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(1, new ListNode(4));
        ListNode l4 = new ListNode();

        printList(reverse(l3));
    }

    public static void printList(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.val + " —> ");
            node = node.next;
        }
        System.out.print("null");
    }
}
