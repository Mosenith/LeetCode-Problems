import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SumRootToLeafNumbers {
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
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use recursion and init global sum=0 for the return ans
    // In dp(), check if root.left & root.right = null, add the combine string to sum
    // Otherwise, add root to stack, call recursion of root.left, then root.right, after that pop()
    // Runtime  : 2ms         -> + 16.30%
    // Memory   : 40.95MB     -> + 65.41%
    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        Stack<Integer> stk = new Stack<>();

        dp(root, stk);

        return sum;
    }

    private static void dp(TreeNode root, Stack<Integer> stk) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            Stack<Integer> cloned = new Stack<>();
            cloned.addAll(stk);
            while(!cloned.isEmpty()) {
                sb.append(cloned.pop());
            }
            sum += Integer.parseInt(sb.reverse().toString());
            return;
        }

        stk.add(root.val);

        dp(root.left,stk);
        dp(root.right,stk);

        stk.pop();
    }
    //  ***************** End of 1st Method ******************



//    private static int checkBothSidesNull(TreeNode node, LinkedList<Integer> ans, int sum) {
//        if(node.left == null && node.right == null) {
//            System.out.println("Both Null");
//            LinkedList<Integer> cloned = new LinkedList<>();
//            cloned.addAll(ans);
//            StringBuilder sb = new StringBuilder();
//            while(!cloned.isEmpty()) {
//                sb.append(cloned.pop());
//            }
//            System.out.println("sb - " + sb);
//            sum += Integer.parseInt(sb.reverse().toString());
//            ans.pollLast();
//        }
//        return sum;
//    }
}
