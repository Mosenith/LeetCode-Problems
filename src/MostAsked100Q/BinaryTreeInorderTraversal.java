package MostAsked100Q;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
        // [1,null,2,3] => [1,3,2]
//        TreeNode root = new TreeNode(1,null, new TreeNode(2,new TreeNode(3),null));

        // [1,2,null,3,4,5,6] => [2,3,1,5,4,6]
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2, null, new TreeNode(3));
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(6);

//        TreeNode root = new TreeNode();

//        InOrder  -> [3, 1, 4, 0, 2]
//        PreOrder -> [0, 1, 3, 4, 2]
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);

        System.out.println("InOrder  -> " + inorderTraversal(root));
        System.out.println("PreOrder -> " + preorderTraversal(root));
    }


    // ***************** 1st Method : InOrder Traversal ******************
    // Approach : Depth-First Search - Backtracking
    // visit left until null, then add, then visit right
    // Use global static list - Don't initialize outside method
    // Runtime  : 0ms           -> + 100%
    // Memory   : 40.31 MB      -> + 98.38%
    static List<Integer> list;
    public static List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();

        dfs(root);
        return list;
    }
    private static void dfs(TreeNode root) {
        if(root  == null) return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    // ***************** End of 1st Method ******************

    // pre-order traversal
    static List<Integer> preAns;
    public static List<Integer> preorderTraversal(TreeNode root) {
        preAns = new ArrayList<>();

        dfs_preOrder(root);
        return preAns;
    }

    private static void dfs_preOrder(TreeNode root) {
        if(root == null) return;

        preAns.add(root.val);
        dfs_preOrder(root.left);
        dfs_preOrder(root.right);
    }
}
