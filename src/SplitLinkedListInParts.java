public class SplitLinkedListInParts {
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
    private static void printListNode(ListNode myNode) {
        while (myNode != null) {
            System.out.println(myNode.val);
            myNode = myNode.next;
        }
        System.out.println("~~~~~~~~");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        SplitLinkedListInParts obj = new SplitLinkedListInParts();
        ListNode[] ans = obj.splitListToParts(head, 5);

        for (ListNode node : ans) {
            printListNode(node);
            System.out.println("********");
        }
    }

    // ***************** 1st Method ******************
    // Approach 1: Copy head to another ListNode and loop through to get the total size
    // Calculate the inner length (length/k) and the remaining length
    // Loop through k times, each iteration init a dummy node and write node
    // Loop through inner length + (i < remain ? 1 : 0) times
    // Copy the value from current node to write.next
    // Then move write to write.next & current to current.next
    // When reach k, exit loop & return the result
    // Runtime  : 0ms         -> + 81.73%
    // Memory   : 43.69MB     -> + 14.30%
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while(current != null) {
            length++;
            current = current.next;
        }

        int innerLen = length / k;
        int remain = length % k;
        ListNode[] result = new ListNode[k];
        current = head;
        for(int i=0; i<k; i++) {
            ListNode dummy = new ListNode();
            ListNode write = dummy;
            for(int j=0; j<innerLen + (i < remain ? 1 : 0); j++) {
                write.next = new ListNode(current.val);
                write = write.next;
                current = current.next;
            }

            result[i] = dummy.next;
        }
        return result;
    }
    //  ***************** End of 1st Method ******************
}
