package Blind75.Tree;

public class SameTree {
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
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println(isSameTree(root1, root2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use recursive function to check each node
    // if both node reach null => true
    // otherwise, if only is null, another is not => false
    // Also, if nodes val are different => false
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.25MB     -> + 28.89%
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return compareTree(p,q);
    }

    private static boolean compareTree(TreeNode pTree, TreeNode qTree) {
        if(pTree == null && qTree == null)
            return true;
        else if(pTree == null && qTree != null || pTree != null && qTree == null)
            return false;

        if(pTree.val != qTree.val)
            return false;

        return compareTree(pTree.left, qTree.left) && compareTree(pTree.right, qTree.right);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Optimized above approach
    // Runtime  : 0ms        -> + 100.00%
    // Memory   : 39.94MB    -> + 57.08%
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    // ***************** End of 2nd Method ******************
}
