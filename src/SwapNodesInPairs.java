import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

//    ***************** 1st Method ******************
    // Runtime  : 1ms        -> (+100%) Not Enough Data
    // Memory   : 41.7MB      -> + 40.62%
    // Copy head to a list -> Change location and copy to ResNode
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        List<Integer> myList = new ArrayList<>();
        while(head != null) {
            myList.add(head.val);
            head = head.next;
        }
        System.out.println(myList);
        // change location and add to new list
        int[] myListShifted = new int[myList.size()];
        int arrIndex = -1;
//        List<Integer> myListShifted = new ArrayList<>(myList.size());
        for(int i=0; i<myList.size(); i++) {
            if(i % 2 == 0) {
                arrIndex = (i + 1 >= myList.size()) ? i : i + 1;
                myListShifted[arrIndex] = myList.get(i);
            } else {
                arrIndex = i - 1;
                myListShifted[arrIndex] = myList.get(i);
            }
        }

        System.out.println(Arrays.toString(myListShifted));

        // Copy result from Array to resNode
        ListNode resNode = new ListNode(0);
        ListNode point = resNode;
        for(int i : myListShifted) {
            ListNode current = new ListNode(i);
            point.next = current;
            point = point.next;
        }

        return resNode.next;
    }

//  ***************** End of 1st Method ******************

//    ***************** Upgrade 1st Method ******************
// Runtime  : 0ms        -> (+100%) Not Enough Data
// Memory   : 40.1MB      -> + 71.11%
    public static ListNode swapPairsUpgrade(ListNode head) {
        if(head == null || head.next == null) return head;

        List<Integer> myList = new ArrayList<>();
        while(head != null) {
            myList.add(head.val);
            head = head.next;
        }

        ListNode resNode = new ListNode(0);
        ListNode point = resNode;
        for(int i=0; i<myList.size(); i++) {
            int arrIndex = -1;
            if(i % 2 == 0) {
                arrIndex = (i + 1 >= myList.size()) ? i : i + 1;
            } else {
                arrIndex = i - 1;
            }

            ListNode current = new ListNode(myList.get(arrIndex));
            point.next = current;
            point = point.next;
        }

        return resNode.next;
    }
//  ***************** End of Upgrade 1st Method ******************

//    ***************** 2nd Method : Recursion ******************
// Runtime  : 0ms        -> (+100%) Not Enough Data
// Memory   : 41.6MB      -> + 46.51%
    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
//  ***************** End of 2nd Method ******************

//    ***************** 3rd Method ******************
    // quite similar to Method 2
    public static ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            System.out.print("dummy = "); printList(dummy.next); System.out.println();
            System.out.print("Above cur : ");
            printList(cur);
            System.out.println("\n");

            ListNode t = cur.next;
            cur.next = t.next;
            t.next = cur;

            pre.next = t;   // change value in dummy.next to t (4, 6)
            printList(pre); System.out.println();
            pre = cur;      // // change value in dummy.next.next to t (1, 5)
            printList(pre); System.out.println();
            cur = cur.next;

            System.out.print("\nBelow cur : ");
            printList(cur); System.out.println("\n******************");
        }
        System.out.println("Head after process");
        printList(head);
        System.out.println();

        return dummy.next;
    }
//  ***************** End of 3rd Method ******************
    public static void main(String[] args) {
        ListNode l1 = new ListNode (1, new ListNode(4, new ListNode(5, new ListNode(6))));
        ListNode l2 = new ListNode (1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode();

//        System.out.println(swapPairs(l2));
        printList(swapPairs3(l1));
//        printList(swapPairsUpgrade(l4));
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
