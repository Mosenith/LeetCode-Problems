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
        TreeNode root1 = new TreeNode(0);
        root1.right = new TreeNode(2);
        root1.right.right = new TreeNode(3);


        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println(isBalanced(root1));
    }

// A height-balanced binary tree is a binary tree
// in which the depth of the two subtrees of every node never differs by more than one.

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;


        return validate(root.left) && validate(root.right);
    }

    public static boolean validate(TreeNode root) {
        int leftHeight = countHeight(root.left);
        System.out.println("=====");
        int rightHeight = countHeight(root.right);

        System.out.println(leftHeight + " : " + rightHeight);

        return Math.abs(leftHeight-rightHeight) <= 1 ? true : false;
    }
    public static int countHeight(TreeNode root) {
        if(root == null) return 0;

        System.out.println("cur root = " + root.val);
        int h1 = 0, h2 = 0;

        System.out.println("Left =>");
        while(root.left != null) {
            System.out.println(root.left.val);
            h1++;
            root = root.left;
        }

        System.out.println("Right =>");
        while(root.right != null) {
            System.out.println(root.right.val);
            h2++;
            root = root.right;
        }

        return Math.max(h1,h2) + 1;
    }
}
