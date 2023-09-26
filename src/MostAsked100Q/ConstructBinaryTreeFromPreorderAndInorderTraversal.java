package MostAsked100Q;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

//        printTreeNode(root);
//        printTreeNode(buildTree(preorder, inorder));
        TreeNode treeNode = buildTree2(preorder, inorder);
//        printTreeNode(treeNode);
    }

    // ***************** 1st Method ******************
    // Approach 1: Using Recursive & Notice that the 0th Index of PreOrder -> root
    // Locate the root index in InOder
    // Set root.left -> helper(preStart+1, inStart, inIndex-1, preorder, inorder)
    // Set root.right -> helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder)
    // Runtime  : 5ms           -> + 17.16%
    // Memory   : 43.00 MB      -> + 85.07%
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length-1 || inStart > inEnd) return null;

        TreeNode ans = new TreeNode(preorder[preStart]);

        int inIndex = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(ans.val == inorder[i]) {
                inIndex = i;    // Locate ansHead index in InOrder
            }
        }

        ans.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder);
        ans.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);

        return ans;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Using Hashmap to store key-inorder[i] & value-i, recursive
    // Set root=preorder[i], inIndex=map.get(root)
    // recursive left = dsf(i+1, j, inIndex-j, preorder)
    // rightTree = dsf(i+1+inIndex-j, inIndex+1, curLen-1-(inIndex-j), preorder);
    // Runtime  : 1ms           -> + 96.33%
    // Memory   : 43.04 MB      -> + 74.82%
    private static Map<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {

        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dsf(0,0,preorder.length, preorder);
    }

    private static TreeNode dsf(int i, int j, int curLen, int[] preorder) {
        if(curLen <= 0) return null;

        int preVal = preorder[i]; // head of the root
        int inIndex = map.get(preVal);

        TreeNode leftTree = dsf(i+1, j, inIndex-j, preorder);
        TreeNode rightTree = dsf(i+1+inIndex-j, inIndex+1, curLen-1-(inIndex-j), preorder);

        return new TreeNode(preVal, leftTree, rightTree);
    }
    // ***************** End of 1st Method ******************
}
