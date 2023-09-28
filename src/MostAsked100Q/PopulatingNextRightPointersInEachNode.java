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

//        System.out.println(connect3(root));
        Node nd = connect2(root);
//        printTreeNode(nd);
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


    // ***************** 2nd Method ******************
    // Approach 2: Using DFS Recursive - dfs = once go down can't come up
    // If child(C) Node Exist:
    // - Set C.Left.Next to C.Right cos perfect binary tree left exist => right exist too
    // - If C.next exist => Set C.Right.Next = C.Next.Left
    // If child Node Does Not Exist:
    // - Return C since we reach last level of Binary Tree
    // Runtime  : 0ms           -> + 100%
    // Memory   : 42.98 MB      -> + 77.78%
    public static Node connect2(Node root) {
        if(root == null) return null;
        Node L = root.left, R = root.right, N = root.next;
        if(L != null) {
            System.out.println("Left = " + L.val);
            System.out.println("Right = " + R.val);
            if(N == null) System.out.println("N is null");
            L.next = R;
            if(N != null) {
                System.out.println("N = " + N.val);
                R.next = N.left;
            }
            connect(L);
            connect(R);
        }
        return root;
    }
    // ***************** End of 2nd Method ******************


    // ***************** 3rd Method ******************
    // Approach 3: Using the above approach but optimized space
    // Runtime  : 0ms           -> + 100.00%
    // Memory   : 42.77 MB      -> + 93.78%
    public static Node connect3(Node root) {
        Node head = root;
        for(; root != null; root = root.left)
            for(Node cur = root; cur != null; cur = cur.next)
                if(cur.left != null) {
                    cur.left.next = cur.right;
                    if(cur.next != null) cur.right.next = cur.next.left;
                } else break;

        return head;
    }
    // ***************** End of 3rd Method ******************

}
