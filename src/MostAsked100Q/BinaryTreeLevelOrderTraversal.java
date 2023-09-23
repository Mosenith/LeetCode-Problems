package MostAsked100Q;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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

        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(21);
        root.right.left = new TreeNode(19);
        root.right.right = new TreeNode(25);
        root.right.right.left = new TreeNode(24);

//        printTreeNode(root);
        System.out.println(levelOrder2(root));
    }

    // ***************** 1st Method ******************
    // Approach 1: Find Height of Tree and Add elements according to respective height
    // Runtime  : 14ms           -> + 20.24%
    // Memory   : 43.76 MB      -> + 79.79%
    static List<List<Integer>> ans;
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null) return ans;

        int height = treeHeight(root);

        List<Integer> cur = new ArrayList<Integer>();
        for(int i=1; i<=height; i++) {
            helper(root, i, cur);
            ans.add(new ArrayList<>(cur));
            cur = new ArrayList<>();
        }

        return null;
    }

    private static void helper(TreeNode root, int curHeight, List<Integer> curElement) {
        if(root == null) return;
        if(curHeight == 1) {
            curElement.add(root.val);
        } else if(curHeight > 1){
            helper(root.left, curHeight-1, curElement);
            helper(root.right, curHeight-1, curElement);
        }
    }

    private static int treeHeight(TreeNode root) {
        if(root == null) return 0;
        else {
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);

            return (leftHeight > rightHeight) ? leftHeight+1 : rightHeight+1;
        }
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use Queue keep track of nodes at each level while traversing the tree.
    // Loop until queue is empty
    // Nested For loop from i = 0 to levelSize (levelSize = queue.size() => #node at current levels)
    // After tmp = queue.poll(), let queue = tmp.left or tmp. right (non-null treeNode)
    // Add sublist to ansList after leaving for-loop
    // Runtime  : 1ms           -> + 90.45%
    // Memory   : 43.97 MB      -> + 57.31%
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null)
            return ansList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
                subList.add(tempNode.val);

                // Enqueue left child
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                // Enqueue right child
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }

            ansList.add(subList);  // Add the current level's nodes to the result list
        }

        return ansList;
    }

    public static List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> subList = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

            ansList.add(new ArrayList<>(subList));
        }

        return null;
    }
}
