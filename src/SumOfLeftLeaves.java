public class SumOfLeftLeaves {
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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(5);

        System.out.println(sumOfLeftLeaves(root));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use recursion & add only left leaf (leaf with both leftNode & rightNode = null)
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.37MB     -> + 23.33%
    static int res = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        util(root);
        return res;
    }

    private static void util(TreeNode root) {
        if(root == null) return;

        util(root.left);
        if(root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        util(root.right);
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Optimized code
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.42MB     -> + 17.08%
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        res += sumOfLeftLeaves(root.left);
        res += sumOfLeftLeaves(root.right);
        return res;
    }
    //  ***************** End of 2nd Method ******************
}
