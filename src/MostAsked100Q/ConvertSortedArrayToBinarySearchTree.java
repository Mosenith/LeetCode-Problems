package MostAsked100Q;

public class ConvertSortedArrayToBinarySearchTree {
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
        // [0,-3,9,-10,null,5] or [0,-10,5,null,-3,null,9]
//        int[] arr = {-10,-3,0,5,9};

        int[] arr = {1,2};
//        int[] arr = {-10,-7,-3,-1,0,3,5,7,9};

        TreeNode result = sortedArrayToBST(arr);

        printTreeNode(result);
    }

    public static void printTreeNode(TreeNode root) {
        if(root == null) return;

        System.out.println(root.val);
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    // ***************** 1st Method : InOrder Traversal ******************
    // Approach : BackTrack - take mid pos as the root
    // root.left = backtrack from start ~ mid-1
    // root.right = backtrack from mid+1 ~ end
    // BaseCase: start = end => return new TreeNode(nums[start])
    // else if start > end => return null
    // Runtime  : 0ms           -> + 100%
    // Memory   : 43.32 MB      -> + 66.43%
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = helper(nums, 0, nums.length-1);

        return res;
    }

    // {-10,-3,0,5,9};
    private static TreeNode helper(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        } else if(start > end) {
            return null;
        }

        int mid = (start+end+1)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);

        return root;
    }
}
