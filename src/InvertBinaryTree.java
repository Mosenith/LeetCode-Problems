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

    // ***************** 1st Method ******************
    // Approach 1: Recursion - Use tmpTree to swap left & right
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.63MB     -> + 25.98%
    public static TreeNode invertTree(TreeNode root) {
        invertUtil(root);

        return root;
    }

    private static void invertUtil(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
    }
    // ***************** End of 1st Method ******************
}
