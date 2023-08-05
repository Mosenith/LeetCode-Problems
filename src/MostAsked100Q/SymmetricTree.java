package MostAsked100Q;

import java.util.ArrayList;
import java.util.List;


public class SymmetricTree {
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

    public static void main(String[] args) {
        // [1,2,2,3,4,4,3] -> true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

//        TreeNode root = new TreeNode(1  );
//        root.left = new TreeNode(2);
//        root.left.left = null;
//        root.left.right = new TreeNode(3);
//        root.right = new TreeNode(2);
//        root.right.left = null;
//        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    // ***************** 1st Method : InOrder Traversal ******************
    // Approach : Breadth-First Search - Backtracking
    // compare left -> left vs right -> right
    // then left -> right vs right -> left
    // Runtime  : 0ms           -> + 100%
    // Memory   : 40.57 MB      -> + 81.40%
    public static boolean isSymmetric(TreeNode root) {
        boolean ans = dfs(root.left, root.right);

        System.out.println(ans);
        return ans;
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left == null && right != null || left != null && right == null
                || left.val != right.val) {
            return false;
        }

        boolean ans = dfs(left.left, right.right);
        boolean ans2 = dfs(left.right, right.left);

        System.out.println(ans + " : " + ans2);
        return ans && ans2;
    }


}
