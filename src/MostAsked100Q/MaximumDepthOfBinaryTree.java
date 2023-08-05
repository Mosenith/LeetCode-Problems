package MostAsked100Q;

public class MaximumDepthOfBinaryTree {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        // [1,2,null,3,4,5,6] => [2,3,1,5,4,6]
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(6);

//        root = [1,null,2]
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);

        System.out.println(maxDepth(root));
    }

    // ***************** 1st Method : InOrder Traversal ******************
    // Approach : int l = backtracking root.left,
    // int r = bactracking rooo.right
    // return 1 + max(l,r);
    // Runtime  : 0ms           -> + 100%
    // Memory   : 42.03 MB      -> + 15.05%
    public static int maxDepth(TreeNode root) {
        System.out.println("Current max = ");
        if(root == null) return 0;

        int l = maxDepth(root.left);
        System.out.println("Left = " + l + " : " +  root.val);
        System.out.println("******************");
        int r = maxDepth(root.right);
        System.out.println("Right = " + r + " : " +  root.val);
        System.out.println("******************");
        System.out.println("Final-> " + l + " : " + r);

        return 1 + Math.max(l ,r);

        // OR just one line Solution
//        return root == null ? 0 : 1 + Math.max ( maxDepth(root.left) , maxDepth(root.right) );
    }

}
