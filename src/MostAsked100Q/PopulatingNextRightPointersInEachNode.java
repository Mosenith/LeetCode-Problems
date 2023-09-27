package MostAsked100Q;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void printTreeNode(Node root) {
        if (root == null) {
            return;
        }

        // Print root, root.left, and root.right
        System.out.println("Root: " + root.val);

        if (root.left != null) {
            System.out.println("Root left: " + root.left.val);
        } else {
            System.out.println("Root left: null");
        }

        if (root.right != null) {
            System.out.println("Root right: " + root.right.val);
        } else {
            System.out.println("Root right: null");
        }

        // Traverse left subtree
        printTreeNode(root.left);

        // Traverse right subtree
        printTreeNode(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(connect(root));
        Node nd = connect(root);
        printTreeNode(nd);
    }

    // ***************** 1st Method ******************
    // Approach 1: Using Binary Tree Level OrderTraversal
    // Just add curNode.next to queue.peek() for node before last node of the level
    // Return root since its reference has been updated
    // Runtime  : 3ms           -> + 40.40%
    // Memory   : 42.64 MB      -> + 97.16%
    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node curNode = queue.poll();

                // Before last element of that level points to next element
                // At last element no need = points to null
                if (i < levelSize - 1) {
                    curNode.next = queue.peek();
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }

        return root;
    }
    // ***************** End of 1st Method ******************

}
