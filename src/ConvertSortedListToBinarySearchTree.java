import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
        // -10 -> -3 -> 0 -> 5 -> 9
        // [0,-3,9,-10,null,5] or [0,-10,5,null,-3,null,9]
        ListNode ls = new ListNode(-10);
        ls.next = new ListNode(-3);
        ls.next.next = new ListNode(0);
        ls.next.next.next = new ListNode(5);
        ls.next.next.next.next = new ListNode(9);

//        printListNode(ls);
        TreeNode result = sortedListToBST(ls);
        System.out.println("Final Answer : ");
        printTreeNode(result);

//        ListNode midNode = findMid(ls);
//        printListNode(midNode);
    }

    private static void printListNode(ListNode myNode) {
        while (myNode != null) {
            System.out.println(myNode.val);
            myNode = myNode.next;
        }
        System.out.println("~~~~~~~~");
    }

    public static void printTreeNode(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.println(root.val);
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    // -10 -> -3 -> 0 -> 5 -> 9
    // [0,-3,9,-10,null,5]
    // ***************** 1st Method ******************
    // Approach : Recursion - toBST() & findMid()
    // findMid() - find mid of given ListNode
    // assign 2 pointers - slow: jump 1, fast: jump 2 <= fast!=null && fast.next != null
    // return slow; minimize listnode by setting pre = slow before jump slow
    // if pre!=null, set pre.next = null
    // toBST() - base head == null, return null
    // set mid.val = Tree root, if head=mid, return root
    // otherwise, recursion left with head, recursion rigth with mid.next
    // Runtime  : 0ms           -> + 100%
    // Memory   : 44.84 MB      -> + 15.64%
    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        if(head == mid)
            return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        // slow is the mid
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        if(prev != null) {
            prev.next = null;
        }

        return slow;
    }

    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Straight Forward - for loop
    // from i=0 to n-1, a=0, b=1 => c = a+b, a=b, b=c
    // return b
    // Runtime  : 0ms           -> + 100%
    // Memory   : 44.84 MB      -> + 15.64%
}
