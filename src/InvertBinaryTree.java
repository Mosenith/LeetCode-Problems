import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {
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
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    public static void main(String[] args) {
        // 2
        // 1,4
        // 3,6
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        TreeNode dummy = root;

        invertUtil(dummy);

        printTreeNode(root);
        return null;
    }

    private static void invertUtil(TreeNode dummy) {
        if(dummy.left == null || dummy.right == null) return;

        invertTree(dummy.left);
        util(dummy.left);
        invertTree(dummy.right);
        util(dummy.right);

    }

    private static void util(TreeNode dummy) {
        while(dummy != null) {
            TreeNode left = new TreeNode();
            TreeNode right = new TreeNode();

            if(dummy.left != null) {
                left = dummy.left;
            }

            if(dummy.right != null) {
                right = dummy.right;
            }

            dummy.left = right;
            dummy.right = left;
        }
    }
}
