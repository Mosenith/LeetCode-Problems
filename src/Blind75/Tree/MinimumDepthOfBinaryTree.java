package Blind75.Tree;

import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println("Left ==> ");
        printTreeNode(root.left);

        System.out.println("Right ==> ");
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
        System.out.println(minDepth2(root1));
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

    // ***************** 2nd Method ******************
    // Approach 2: Use Queue to store the root at each level start from root
    // With the loop, have another loop from 0 to origin size
    // Within inner loop, remove the treeNode from queue and check 3 condition
    // 1: Both left & right node are null => return level
    // 2: Left != null => add root.left to queue
    // 3: Right != null=> add root.right to queue
    // Out of inner loop, increment level
    // Runtime  : 2ms         -> + 87.24%
    // Memory   : 62.82MB     -> + 12.51%
    public static int minDepth2(TreeNode root) {
        if(root== null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode current = queue.remove();
                if(current.left == null && current.right == null) {
                    return level;
                }
                if(current.left!=null) {
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
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Most balance & short code
    // Runtime  : 3ms         -> + 77.69%
    // Memory   : 62.58MB     -> + 28.70%
    public static int minDepth3(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int left = Integer.MAX_VALUE , right = Integer.MAX_VALUE;
        if(root.left != null)
            left = minDepth(root.left);
        if(root.right != null)
            right = minDepth(root.right);

        return Math.min(left,right) + 1;
    }
    // ***************** End of 3rd Method ******************

}
