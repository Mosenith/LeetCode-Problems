public class RemoveDuplicatesFromSortedList {
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
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        // head = [1,1,2,3,3] -> [1,2,3]
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);


        System.out.println(deleteDuplicates(head));
    }

    // ***************** 1st Method ******************
    // Approach 1:
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 43.32MB     -> + 31.29%
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null, next = null;
        ListNode cur = head;

        while(cur != null) {
            pre = cur;
            next = cur.next;
            while(next != null && next.val == pre.val) {
                next = next.next;
            }

            cur.next = next;
            cur = next;

            printList(cur);
            System.out.println("====\n");
        }

        printList(head);
        printList(pre);

        return head;
    }
}
