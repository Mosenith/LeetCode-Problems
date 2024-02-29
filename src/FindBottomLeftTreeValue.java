import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {
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

        System.out.println(findBottomLeftValue(root1));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Queue to store root then loop from queue.size to > 0
    // Poll TreeNode out of queue and check if leftNode != null, add leftNode to queue
    // Check if RightNode != null, add to queue. Before enter loop, have ans store root.val
    // When queue is empty out of loop, return ans;
    // Runtime  : 2ms           -> + 29.61%
    // Memory   : 43.02MB       -> + 88.49%
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;

        while(!queue.isEmpty()) {
            ans = queue.peek().val;
            for(int i=queue.size(); i>0; i--) {
                TreeNode tmp = queue.poll();
                printTreeNode(tmp);
                if(tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if(tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use dfs traversal method, when level > maxDept
    // Update res to root.val and update maxDept to new level
    // Runtime  : 0ms           -> + 100.00%
    // Memory   : 43.10MB       -> + 88.49%
    static private int maxDepth = 0;
    static private int res = 0;
    public static int findBottomLeftValue2(TreeNode root) {
        traversal(root, 1);
        return res;
    }

    private static void traversal(TreeNode root, int level) {
        if(root == null) return;

        // if level > maxDepth => update res to root.val
        if(level > maxDepth) {
            maxDepth = level;
            res = root.val;
        }

        traversal(root.left, level+1);
        traversal(root.right, level+1);
    }
    //  ***************** End of 2nd Method ******************
}
