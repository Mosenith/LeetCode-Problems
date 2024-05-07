public class DoubleANumberRepresentedAsALinkedList {
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
        // head = [1,8,9] -> [3,7,8]
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);

        printList(doubleIt(head));
    }

    // ***************** 1st Method ******************
    // Approach 1: Reverse the given ListNode, init ans=listnode(0) & dummy=ans, then loop through head
    // Cal sum=head.val*2 + remain, update remain=sum%10, add dummy.next=listNode(sum/10)
    // Move dummy to dummy.next & head to head.next. When head reaches null, out of loop check remain
    // If remain = 1, add to dummy.next & move dummy, return reverse(ans.next)
    // Runtime  : 4m      -> + 77.89%
    // Memory   : 45.49MB -> + 91.41%
    public static ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        int remain = 0;
        while(head != null) {
            int sum = head.val + head.val + remain;
            remain = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            head = head.next;
        }
        if(remain != 0) {
            dummy.next = new ListNode(remain);
            dummy = dummy.next;
        }
        return reverse(ans.next);
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    // ***************** End of 1st Method ******************

}
