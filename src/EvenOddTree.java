public class EvenOddTree {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);

        System.out.println(isEvenOddTree(root));
    }

    // odd-level => even nodes, strictly decreasing
    // even-level => odd nodes, strictly increasing

    public static boolean isEvenOddTree(TreeNode root) {
        return traversal(root,0);
    }

    private static boolean traversal(TreeNode root, int level) {
        if(root == null) return true;

        if(level % 2 == 0) {
            if(root.val % 2 == 0) {
                return false;
            }
        } else {
            if(root.val % 2 != 0) {
                return false;
            }
        }

        traversal(root.left, level+1);
        traversal(root.right, level+1);

        return true;
    }
}
