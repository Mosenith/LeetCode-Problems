package MostAsked100Q;

import java.util.Stack;

public class ReverseLinkedList {
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

    public static void main(String[] args) {
        ListNode myNode = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));

//        printListNode(reverseList(myNode));

        printListNode(reverseList2(myNode));
    }

    private static void printListNode(ListNode myNode) {
        while (myNode != null) {
            System.out.println(myNode.val);
            myNode = myNode.next;
        }
        System.out.println("~~~~~~~~");
    }

    // ***************** 1st Method ******************
    // Approach : Very Basic & Efficient Approach
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.98 MB      -> + 40.98%
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use Stack and read all nodes store in stack
    // Pop out one by one to ansListNode
    // Runtime  : 1ms         -> + 5.28%
    // Memory   : 45.61MB     -> + 58.12%
    public static ListNode reverseList2(ListNode head) {
        Stack<Integer> stk = new Stack<>();

        while (head != null) {
            stk.push(head.val);
            head = head.next;
        }
        // init return listnode
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;

        while(!stk.isEmpty()) {
            dummy.next = new ListNode(stk.pop());
            dummy = dummy.next;
        }
        return ans.next;
    }
    //  ***************** End of 2nd Method ******************

}
