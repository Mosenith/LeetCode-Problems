package MostAsked100Q;

public class ValidateBinarySearchTree {
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
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(4); // 6 true, 4 false
//        root.right.right = new TreeNode(10);

//        TreeNode root = new TreeNode(15);
//        root.left = new TreeNode(7);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(10);
//        root.left.left.left = new TreeNode(2);
//        root.left.left.right = new TreeNode(5);
//        root.right = new TreeNode(21);
//        root.right.left = new TreeNode(19);
//        root.right.right = new TreeNode(25);
//        root.right.right.left = new TreeNode(24);

//        TreeNode root = new TreeNode(32);
//        root.left = new TreeNode(26);
//        root.left.left = new TreeNode(19);
//        root.left.left.right = new TreeNode(27);
//        root.right = new TreeNode(47);
//        root.right.right = new TreeNode(56);

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);

//        printTreeNode(root);
        System.out.println(isValidBST(root));

        System.out.println("~~~~~~");

        System.out.println(isValidBST2(root));
    }

    // ***************** 1st Method ******************
    // Approach 1: BST - root > leftNode && root < rightNode
    // Using recursion -> helper(TreeNode root, int min, int max) with initial min & max = MIN/MAX
    // With Left Tree -> update max = root-1 => the max of any left subTree must < root
    // With Right Tree -> update min = root+1 => the min of any right subTree must > root
    // Within helper -> If the value of the node is less than the minimum value possible or greater
    // than the maximum value possible then return false
    // Runtime  : 136ms           -> + 82.12%
    // Memory   : 39.99 MB      -> + 99.52%
    public static boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, int min, int max) {
        if(root == null) return true;

        // Check BST Basic Rule: root > left && root < right
        if(root.left != null && root.val <= root.left.val
                || root.right != null && root.val >= root.right.val) {
            return false;
        }

        // check cur root with min(righty Min) and max(lefty Max)
        if(root.val < min || root.val > max) {
            return false;
        }

        return helper(root.left, min, root.val-1)
                && helper(root.right, root.val+1, max);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: In Order Traversal Approach
    // Using recursive with boolean isBST(TreeNode root), initialized treeNode prev
    // if root!=null, check isBST(root.left) (if = false return false)
    // check if prev >= root, if so return false. Otherwise, let prev = root
    // return isBST(root.left) <= within if root!=null clause
    // out of clause, return true;
    // Runtime  : 0ms           -> + 100%
    // Memory   : 43.29 MB      -> + 98.94%
    static TreeNode prev;
    public static boolean isValidBST2(TreeNode root) {
        return isBST(root);
    }
    private static boolean isBST(TreeNode root) {
        if(root != null) {
            if(!isBST(root.left)) {
                return false;
            }
            if(prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            return isBST(root.right);
        }
        return true;
    }
    // ***************** 2nd Method ******************
}
