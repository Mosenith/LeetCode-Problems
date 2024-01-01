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

    static Queue<Integer> q;
    public static TreeNode invertTree(TreeNode root) {
        q = new ArrayDeque<>();

        invertUtil(root);

        TreeNode res = new TreeNode();

        while (!q.isEmpty()) {
            res.val = q.poll();
            res.left = new TreeNode(q.poll());
            res.right = new TreeNode(q.poll());
        }
        return null;
    }

    private static void invertUtil(TreeNode root) {
        if(root == null) return;

        q.add(root.val);
        invertTree(root.right);
        invertTree(root.left);
    }
}
