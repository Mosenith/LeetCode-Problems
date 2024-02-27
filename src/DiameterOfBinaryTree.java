public class DiameterOfBinaryTree {

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
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root1));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use DFS recursive - find dfs of root.left & root.right
    // In dfs, ans = max(ans, left+right) and return 1+max(left+right)
    // Runtime  : 0ms           -> + 100.00%
    // Memory   : 42.96MB       -> + 27.80%
    static int ans;
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        countNode(root);
        return ans;
    }

    private static int countNode(TreeNode root) {
        if(root == null) return 0;

        int left = countNode(root.left);
        int right = countNode(root.right);
        ans = Math.max(ans, left + right);

        return 1 + Math.max(left,right);
    }
    //  ***************** End of 1st Method ******************
}
