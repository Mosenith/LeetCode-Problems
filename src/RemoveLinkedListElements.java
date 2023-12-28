public class RemoveLinkedListElements {
     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void printList(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.val + " —> ");
            node = node.next;
        }
        System.out.print("null");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode (1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode l2 = new ListNode (1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(1, new ListNode(4));
        ListNode l4 = new ListNode();

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while(dummy. != null) {
            if(dummy.val )
        }

        return head;
    }
}
