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
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        System.out.println(pathSum(root,22));
    }

    // ***************** 1st Method ******************
    // Approach 1: Pretty similar to Path Sum Problem, just keep innerList
    // At each node, add root.val to innerList
    // Rather than targetSum -= root.val every node, start curSum = 0 & + root.val at each node
    // If that node adds up > target, curSum -= root.val & remove from innerList
    // When curSum = target, add inner to Ans
    // Runtime  : 1ms            -> + 99.91%
    // Memory   : 43.57MB        -> + 87.76%
    static List<List<Integer>> ans;
    static int target;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        target = targetSum;
        List<Integer> inner = new ArrayList<>();

        dfs(root,0,inner);

        return ans;
    }

    private static void dfs(TreeNode root, int curSum, List<Integer> inner) {
        if(root == null) {
            return;
        }

        inner.add(root.val);
        curSum += root.val;
        if(curSum == target && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(inner));
        }

        dfs(root.left, curSum, inner);
        dfs(root.right,curSum, inner);

        curSum -= root.val;
        if(!inner.isEmpty()) {
            inner.remove(inner.size()-1);
        }
    }
    // ***************** End of 1st Method ******************
}
