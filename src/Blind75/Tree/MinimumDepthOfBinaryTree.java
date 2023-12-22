package Blind75.Tree;

public class MinimumDepthOfBinaryTree {
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
//        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        root1.right.right.right = new TreeNode(6);
        root1.right.right.right.right = new TreeNode(7);

//        root1.right.left = new TreeNode(3);
//        root1.right.right = new TreeNode(6);
//        root1.right.right.left = new TreeNode(5);

//        printTreeNode(root1);
        System.out.println(minDepth(root1));
    }


    // ***************** 1st Method ******************
    // Approach 1: check if root is null => 0
    // Then if root.left = null => 1 + minDepth(root.right)
    // Then if root.right = null => 1 + minDepth(root.left)
    // Otherwise => 1 + Math(minDepth(root.left),minDepth(root.right))
    // Runtime  : 5ms         -> + 36.76%
    // Memory   : 63.32MB     -> + 7.13%
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    // ***************** End of 1st Method ******************

    public int minDepth(TreeNode root) {
        if(root== null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode current = queue.remove();
                if(current.left == null && current.right == null){
                    return level;
                }
                if(current.left!=null)
                {
                    queue.add(current.left);
                }

                if(current.right!=null) {
                    queue.add(current.right);
                }
            }
            level++;
        }
        return level;
    }

}
