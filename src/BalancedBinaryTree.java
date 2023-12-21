// A height-balanced binary tree is a binary tree
// in which the depth of the two subtrees of every node never differs by more than one.
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
//        root1.right.left = new TreeNode(3);
//        root1.right.right = new TreeNode(6);
//        root1.right.right.left = new TreeNode(5);

        System.out.println(isBalanced(root1));
    }

    // ***************** 1st Method ******************
    // Approach 1: countHeight() ==> Cal height of root to the left & right
    // If the diff is >1 => return -1
    // If subTree is imbalance, either h1 or h2 will return -1
    // Therefore, check if abs(h1-h2)>1 || h1==-1 || h2==-1 => -1
    // Base method return countHeight(root) >= 0;
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 44.48MB     -> + 6.01%
    public static boolean isBalanced(TreeNode root) {
        return countHeight(root) >= 0;
    }
    public static int countHeight(TreeNode root) {
        if(root == null) return 0;

        int h1 = countHeight(root.left);
        int h2 = countHeight(root.right);

        // when dif of height >=2 => false = -1
        // some sub-tree might be imbalance and return -1
        // so check if h1 || h2 = -1 => return -1
        if(Math.abs(h1-h2) > 1 || h1 == -1 || h2 == -1) {
            return -1;
        }

        return Math.max(h1,h2) + 1;
    }
}
