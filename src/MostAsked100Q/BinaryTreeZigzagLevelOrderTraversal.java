package MostAsked100Q;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
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
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

//        printTreeNode(root);
        System.out.println(zigzagLevelOrder(root));
    }

    // ***************** 1st Method ******************
    // Approach 1: Similar to Level Order Traversal
    // Except count from left-right at level 1 and right-left at level 2, ...
    // Let boolean fromLeft = true. If(fromLeft) => reverse(subList) before add to ans
    // Let fromLeft = !fromLeft
    // Runtime  : 1ms           -> + 90.74%
    // Memory   : 41.50 MB      -> + 19.29%
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean fromLeft = true; // start from left -> right -> left

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();

            for(int i=0; i<levelSize; i++) {
                TreeNode tmpNode = queue.poll();
                subList.add(tmpNode.val);

                if(tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if(tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }

            if(!fromLeft) {
                Collections.reverse(subList);
            }

            ans.add(subList);
            fromLeft = !fromLeft;
        }

        return ans;
    }
    // ***************** End of 1st Method ******************
}
