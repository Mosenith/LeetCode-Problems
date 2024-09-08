public class LinkedListInBinaryTree {
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

     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
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

    public static void printList(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.val + " —> ");
            node = node.next;
        }
        System.out.print("null");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode (4, new ListNode(2, new ListNode(8)));
        printList(l1);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        LinkedListInBinaryTree obj = new LinkedListInBinaryTree();
        System.out.println(obj.isSubPath(l1, root));
    }

    // ***************** 1st Method ******************
    // Approach 1: Check if root = null, return false
    // Otherwise, return dfs || recursion(root.left) || recursion(root.right)
    // dfs: if head = null, return true. If root = null, return false. If head.val != root.val, return false
    // Otherwise, return dfs(head.next, root.left) || dfs(head.next, root.right)
    // Runtime  : 1ms       -> + 97.89%
    // Memory   : 44.92MB   -> + 54.56%
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if(head == null) {
            return true;
        }

        if (root == null || head.val != root.val) {
            return false;
        }

        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
    // ***************** End of 1st Method ******************
}
