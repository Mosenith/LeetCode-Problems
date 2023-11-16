import java.util.List;

public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode (1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode (1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(1, new ListNode(4));
        ListNode l4 = new ListNode();

        printList(reverseBetween(l1,2,4));
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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }

        ListNode dummyNode = new ListNode(0, head);
        ListNode beforeStartNode = dummyNode;

        for (int i = 0; i < left - 1; ++i) {
            beforeStartNode = beforeStartNode.next;
        }

        printList(dummyNode);
        printList(beforeStartNode);
        System.out.println("~~~~~~~");

        ListNode startNode = beforeStartNode;
        ListNode endNode = startNode.next;
        ListNode currentNode = endNode;

        for (int i = 0; i < right - left + 1; ++i) {
            ListNode nextNode = currentNode.next;
            currentNode.next = beforeStartNode;
            beforeStartNode = currentNode;
            currentNode = nextNode;
        }





        startNode.next = beforeStartNode;
        endNode.next = currentNode;

        printList(beforeStartNode);
        printList(currentNode);
        System.out.println("~~~~~~~");

        return dummyNode.next;
    }
}
