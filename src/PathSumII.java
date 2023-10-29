import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
//        root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        System.out.println(pathSum(root,22));
    }

    static List<List<Integer>> ans;
    static int target;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        target = targetSum;
        List<Integer> inner = new ArrayList<>();

        dfs(root,targetSum,inner);

        System.out.println(ans);
        return null;
    }

    private static void dfs(TreeNode root, int targetSum, List<Integer> inner) {
        if(root == null) {
            return;
        }

        System.out.println("root => " + root.val);

        inner.add(root.val);
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(inner));
            inner = new ArrayList<>();
            targetSum = target;
        }

        dfs(root.left, targetSum, inner);
        System.out.println("Root after left -- " + root.val);
        System.out.println("\n****\n");


        dfs(root.right,targetSum, inner);
        System.out.println("Root after right -- " + root.val);
        System.out.println("\n====\n");

    }
}
