import java.util.ArrayDeque;
import java.util.Queue;

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
        ListNode l3 = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode l4 = new ListNode();

        printList(removeElements2(l1,1));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use queue to store all the elements != removeElement
    // Runtime  : 9ms        -> + 93.02%
    // Memory   : 45.75MB    -> + 6.46%
    public static ListNode removeElements(ListNode head, int val) {
        Queue<Integer> queue = new ArrayDeque<>();

        while(head != null) {
            if(head.val != val) {
                queue.add(head.val);
            }
            head = head.next;
        }

        ListNode res = new ListNode(0);
        ListNode d1 = res;
        while(!queue.isEmpty()) {
            d1.next = new ListNode(queue.poll());
            d1 = d1.next;
        }

        return res.next;
    }
    // ***************** End of 1st Method ******************


    // ***************** 2nd Method ******************
    // Approach 2: Use 2 ListNodes one for prev & one for copy of head
    // Loop till dummy = null & check if dummy.val = val,
    // Have prev.next to the next one, move dummy to next one.
    // **Important** check at 1st iteration if head.val = val
    // If so, move head -> head.next & dummy = next, continue
    // Runtime  : 2ms        -> + 93.02%
    // Memory   : 45.04MB    -> + 53.44%
    public static ListNode removeElements2(ListNode head, int val) {
        ListNode prev = null;
        ListNode dummy = head;

        while(dummy != null) {
            // handle when origin head.val = val to remove
            if(head.val == val && dummy == head) {
                head = head.next;
                dummy = head;
                continue;
            }

            if(dummy.val == val) {
                prev.next = dummy.next;
            } else {
                prev = dummy;
            }
            dummy = dummy.next;
        }
        return head;
    }
    // ***************** End of 2nd Method ******************

}
