import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
//        ListNode head = new ListNode(5);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(13);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(8);

//
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);

        printList(removeNodes(head));
    }

    public static ListNode removeNodes(ListNode head) {
        Queue<ListNode> queue = new ArrayDeque<>();
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;

        while(head != null) {
            if(queue.isEmpty() || queue.peek().val >= head.val) {
                queue.offer(head);
            } else {
                while(!queue.isEmpty()) {
                    queue.poll();
                }
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;
        }

        while(!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }

        return ans.next;
    }
}
