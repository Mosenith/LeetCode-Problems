import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal2(root));

    }

    // ***************** 1st Method ******************
    // Approach 1: Recursive -> root-left-right
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.93MB     -> + 10.42%
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        preorder(root,ls);
        return ls;
    }

    private static void preorder(TreeNode root, List<Integer> ls) {
        if(root == null) return;

        ls.add(root.val);
        preorder(root.left, ls);
        preorder(root.right, ls);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use Stack to store the whole tree
    // Loop until stack is empty and add root.val to list
    // each iteration check root.right & root.left
    // if not null add each of them to the stack (check right first)
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.72MB     -> + 10.42%
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ls.add(cur.val);

            if(cur.right != null) {
                stack.add(cur.right);
            }

            if(cur.left != null) {
                stack.add(cur.left);
            }
        }

        return ls;
    }
    // ***************** End of 2nd Method ******************

}
