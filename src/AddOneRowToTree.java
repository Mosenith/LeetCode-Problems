import java.util.*;

public class AddOneRowToTree {
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

    // 15, 116 = 131
    public static void main(String[] args) {
        // 0,1,2
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(1);

        printTreeNode(addOneRow(root,1,3));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use ArrayDeque to store root node, then loop until q.isEmpty
    // Each iteration keeps track of level and get q.size to form another loop from q.size() to >0
    // Check if curRoot.left or curRoot.right != null, add it to q
    // Then check if level=depth-1, set curRoot.left & curRoot.right to new value
    // Runtime  : 1ms      -> + 32.04%
    // Memory   : 44.42MB  -> + 34.44%
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int i = 0;
        while (!q.isEmpty()) {
            ++i;
            for (int k = q.size(); k > 0; --k) {
                TreeNode node = q.pollFirst();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                // At the level that needs to included new Tree
                if (i == depth - 1) {
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                }
            }
        }
        return root;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar approach but use recursion while also keep track of level
    // Initial level is 1 and if level == dept-1, add new Tree to the current level
    // Then, just call recursion from left & then right node with level+1
    // Runtime  : 0ms      -> + 100.00%
    // Memory   : 44.90MB  -> + 9.21%
    private static int val;
    private static int depth;
    public TreeNode addOneRow2(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        this.val = val;
        this.depth = depth;
        dfs(root, 1);
        return root;
    }

    private static void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        if (d == depth - 1) {
            TreeNode l = new TreeNode(val, root.left, null);
            TreeNode r = new TreeNode(val, null, root.right);
            root.left = l;
            root.right = r;
            return;
        }
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }
    //  ***************** End of 2nd Method ******************
}
