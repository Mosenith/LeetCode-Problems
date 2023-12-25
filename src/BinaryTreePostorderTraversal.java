import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreePostorderTraversal {
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
    public static void printTreeNode(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        System.out.println("Left ==> ");
        printTreeNode(root.left);

        System.out.println("Right ==> ");
        printTreeNode(root.right);
    }

    public static void main(String[] args) {
        // 0,1,2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(postorderTraversal(root));
    }

    // left - right - root
    // ***************** 1st Method ******************
    // Approach 1: Recursive -> root-left-right
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.93MB     -> + 10.42%
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        postorderTraversalUtils(root, ls);
        return ls;
    }

    private static void postorderTraversalUtils(TreeNode root, List<Integer> ls) {
        if(root == null) return;

        postorderTraversalUtils(root.left,ls);
        postorderTraversalUtils(root.right, ls);
        ls.add(root.val);
    }
    // ***************** End of 1st Method ******************

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            ans.addFirst(node.val);
            if (node.left != null) {
                stk.push(node.left);
            }
            if (node.right != null) {
                stk.push(node.right);
            }
        }
        return ans;
    }
}
