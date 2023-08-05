package MostAsked100Q;

public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode nextListNode) {
            val = x;
            next = nextListNode;
        }
    }

    private static void printNode(ListNode intersectionNode) {
        if(intersectionNode == null) return;
        while(intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(3);
        l1.next.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next.next = new ListNode(1);

        // [1,0,1] -> true

        System.out.println(isPalindrome2(l1));
    }


    // ***************** 1st Method : HashMap ******************
    // Approach 1: 3 main loops
    // 1st Loop => use slow & fast to get slow to the middle of head
    // 2nd Loop => reverse slow
    // 3rd Loop => compare slow with head. If not match, return false
    // Out of Loop, return true
    // Runtime  : 3ms           -> + 99.83%
    // Memory   : 56.49 MB      -> + 77.75%
    // Time : O(n), Space: O(1), Each loop is O(n/2) ~= O(n)
    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        // get ListNode slow to the middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse slow : 2,1 => 1,2
        ListNode pre = null;
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }

        // check slow with head
        while(pre != null) {
            if(pre.val != head.val)
                return false;

            pre = pre.next;
            head = head.next;
        }

        return true;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method : HashMap ******************
    // Approach : make a slower pointer and a faster pointer
    // if the fast pointer catch up with slow pointer, then it's a circular linked list
    // if the fast pointer get to the end, then it's not a circular linked list
    // Runtime  : 0ms           -> + 100%
    // Memory   : 43.80 MB      -> + 35.32%
    // Time : O(n), Space: O(1)
    public static boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        System.out.println("start -> " + slow.val + " : " + fast.val);
        // After this loop, slow will be in the middle of the Original ListNode
        while (fast != null && fast.next != null) {
            System.out.println(slow.val + " : " + fast.val);
            slow = slow.next;
            fast = fast.next.next;

        }

        System.out.println("After 1st loop -> ");
        printNode(slow);

        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;

//        System.out.println("New Assigned slow ---");
//        printNode(slow);
        System.out.println("New Assigned cur ---");
        printNode(cur);
        // 34 => 43
        // 4->null
        // this loop will reverse the input cur and output pre
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;

            System.out.println("=====t=====");
            printNode(t);
            System.out.println("=====cur.next=====");
            printNode(cur.next);
            System.out.println("=====pre=====");
            printNode(pre);
            System.out.println("=====cur=====");
            printNode(cur);
        }

        System.out.println("******************");
//        System.ou

        // this loop validate pre & head one by one
        // pre reach null means heads reach the middle where last node of pre is
        // therefore, break when pre=null. If continue it'll dup elements
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }

        return true;
    }
    // ***************** End of 2nd Method ******************
}
