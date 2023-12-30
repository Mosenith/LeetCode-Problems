import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
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
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        root1.right.right.left = new TreeNode(5);

        System.out.println(countNodes(root1));
        System.out.println(countNodes2(root1));

    }

    // ***************** 1st Method ******************
    // Approach 1: Recursion - base case root = null => return 0
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 48.31MB     -> + 5.55%
    public static int countNodes(TreeNode root) {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    // ***************** End of 1st Method ******************

    static int count;
    public static int countNodes2(TreeNode root) {
        count = 0;
        helper(root);

        return count;
    }

    private static void helper(TreeNode root) {
        if(root == null) return;

        count++;
        helper(root.left);
        helper(root.right);
    }

    public static int countNodes3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            count += levelSize;
            while (levelSize-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return count;
    }
}
