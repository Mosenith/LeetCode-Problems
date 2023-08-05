import java.util.List;

public class AddTwoNumbers {
    //    *****************List Node Declaration******************
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
//    *****************End of Declaration******************
    // ***************** 1st Method ******************
    // Runtime  : 2ms      -> + 97.55%
    // Memory   : 43.1MB      -> + 17.45%
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempListnode = new ListNode();
        int remain = 0;

        while(l1 != null || l2 != null) {
            int curSum = remain;

            if(l1 != null && l2 != null) {
                curSum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null && l2 == null) {
                curSum += l1.val;
                l1 = l1.next;
            } else if(l1 == null && l2 != null){
                curSum += l2.val;
                l2 = l2.next;
            }
            remain = 0;
            System.out.println("Before Impl = " + curSum);
            if(curSum >= 10) {
                curSum = curSum % 10;
                remain = 1;
            }

            System.out.println("CurSum = " + curSum + ", remain = " + remain);
            ListNode newNode = new ListNode(curSum);
            if(tempListnode == null) {
                tempListnode = newNode;
            } else {
                ListNode last = tempListnode;
                while(last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }

            System.out.println("*************");
        }

        if(remain != 0) {
            ListNode last = tempListnode;
            while(last.next != null) {
                last = last.next;
            }
            last.next = new ListNode(remain);
        }

        printList(tempListnode);
        return tempListnode;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode (2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode (5, new ListNode(6, new ListNode(4)));

//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9,
//                new ListNode(9, new ListNode(9, new ListNode(9,
//                        new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9,
//                new ListNode(9))));

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        System.out.println(addTwoNumbers(l1,l2));
    }

    // Utility function to print contents of a linked list
    public static void printList(ListNode node)
    {
        while (node.next != null)
        {
            System.out.print(node.next.val + " —> ");
            node = node.next;
        }
        System.out.print("null");
    }
}
