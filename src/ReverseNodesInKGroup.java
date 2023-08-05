import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {
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
    // Unfinished Function
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        boolean isEven = (k % 2 == 0) ? true : false;
        ListNode dummy = new ListNode(0, head);
        List<Integer> myList = new ArrayList<>();
        while(dummy != null && dummy.next != null) {
            myList.add(dummy.next.val);
            dummy = dummy.next;
        }

        List<Integer> myKList = new ArrayList<>();
        int copyK = k;
        for(int i=0; i<myList.size() && copyK<myList.size(); i++) {
            myKList.add(myList.get(i));
            if(i == copyK-1)
                copyK = copyK + copyK;
        }

        System.out.println(myList);
        System.out.println(myKList);

        List<Integer> newKList = new ArrayList<>();
        copyK = k;
//        while(!myKList.isEmpty()) {
//            while(copyK != 0) {
//
//            }
//            newKList.add(myKList.get(copyK-1));
//            newKList.add(myKList.get(0));
//            myKList.remove(copyK-1);
//            myKList.remove(0);
//        }
//        if(isEven) {
//            while(!myKList.isEmpty()) {
//                newKList.add(myKList.get(copyK-1));
//                newKList.add(myKList.get(0));
//                myKList.remove(copyK-1);
//                myKList.remove(0);
//            }
//        } else {
//            while(!myKList.isEmpty()) {
//                newKList.add(myKList.get(copyK-1));
//                newKList.add(myKList.get(0));
//                myKList.remove(copyK-1);
//                myKList.remove(0);
//            }
//        }
        System.out.println(newKList);

        return head;
    }

    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // Runtime  : 0ms        -> (+100%) Not Enough Data
    // Memory   : 41.7MB      -> + 89.46%
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = dummy;
        // cur : 0 -> ...

        while (cur.next != null) {
            // move cur element to k-1
            // cur stops at k-1
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }

            if (cur == null) {
                // if head has fewer elements than k
                // return
                return dummy.next;
            }

            ListNode t = cur.next;
            cur.next = null;
            ListNode start = pre.next;      // start determines head final image
            pre.next = reverseList(start);
            start.next = t;

            System.out.print("head : ");
            printList(head); System.out.println();

            pre = start;
            cur = pre;
        }
        return dummy.next;
    }
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null, p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
    }
    //  ***************** End of 2nd Method ******************

    //    ***************** 3rd Method ******************
    // Runtime  : 0ms        -> (+100%) Not Enough Data
    // Memory   : 42.2MB      -> + 69.27%
    public static ListNode reverseKGroup3(ListNode head, int k) {
        ListNode root = new ListNode(0, head);
        ListNode pre = root;
        ListNode cur = head;

        while(cur != null) {
            ListNode tail = cur;
            int i=0;
            for(; i<k && cur != null; i++) {
                cur = cur.next;
            }

            if(i != k) {
                pre.next = tail;
            } else {
                pre.next = reverseKTimes(tail, k);
                pre = tail;
            }
        }

        return root.next;
    }

    private static ListNode reverseKTimes(ListNode tail, int k) {
        ListNode pre = null, next = null;
        ListNode cur = tail;

        while(cur != null && k-- > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        tail = pre;
        return tail;
    }
    //  ***************** End of 3rd Method ******************
    //    ***************** Main Method ******************
    public static void main(String[] args) {
        ListNode l1 = new ListNode (1, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(3)))));
        ListNode l2 = new ListNode (1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(1, new ListNode(4));
        ListNode l4 = new ListNode();
        ListNode l5 = new ListNode (1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        int k = 2;
//        System.out.println(swapPairs(l2));
        printList(reverseKGroup2(l5, 4));
//        printList(reverseKGroup3(l5, 4));
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
