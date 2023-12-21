import com.sun.source.tree.Tree;

public class BalancedBinaryTree {
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
        // 0,1,2
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        root1.right.right.left = new TreeNode(5);

        printTreeNode(root1);

        System.out.println(isBalanced(root1));
    }

// A height-balanced binary tree is a binary tree
// in which the depth of the two subtrees of every node never differs by more than one.

    public static boolean isBalanced(TreeNode root) {
        return countHeight(root) <= 1;
    }
    public static int countHeight(TreeNode root) {
        if(root == null) return 0;


        System.out.println("root => " + root.val);
        int h1 = countHeight(root.left);
        System.out.println("");
        int h2 = countHeight(root.right);



        return Math.max(h1,h2) + 1;
    }
}
