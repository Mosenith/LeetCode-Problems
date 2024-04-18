import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestStringStartingFromLeaf {
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
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(smallestFromLeaf(root));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Recursion and keep a global sb & list for appending each node & store the combine nodes
    // In dfs, check null, if not covert root.val(int) to string
    // Check if both sides of root null, add sb to ls and substring(0,sb.len-1) and return
    // Call recursion from the left, then from the right. After that sb.subString(0,sb.len-1)
    // In condition check of root sides, init new StringBuilder and clone sb, reverse the clonedString, then add to ls
    // Runtime  : 8ms      -> + 40.83%
    // Memory   : 43.95MB  -> + 84.13%
    static List<String> ls = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static String smallestFromLeaf(TreeNode root) {
        dfs(root);

        return ls.stream().sorted().collect(Collectors.toList()).get(0);
    }

    private static void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        sb.append(String.valueOf((char)(root.val + 'a')));
        if(root.left == null && root.right == null) {
            StringBuilder clonedString = new StringBuilder(sb);
            ls.add(clonedString.reverse().toString());
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            return;
        }

        dfs(root.left);
        dfs(root.right);
        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
    }
    //  ***************** End of 1st Method ******************

}
