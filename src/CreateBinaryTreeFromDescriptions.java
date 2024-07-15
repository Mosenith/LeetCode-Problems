import java.util.*;

public class CreateBinaryTreeFromDescriptions {
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
        int[][] myArray = {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 0}
        };
        printTreeNode(createBinaryTree(myArray));
        printTreeNode(createBinaryTree2(myArray));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Set, Map and List to store the head, child and map of the tree
    // Each iteration in 2d Array, check if head contains desc[1], if not add to head, if so remove
    // Keep updating child for each iteration and check if it contains in head, before adding to head
    // Init treenode ans with head.stream().findFirst().get() as the root
    // Init dummy with ans, then use queue to add dummy
    // Loop through the map and create the tree
    // Create tempTree from polling queue, then get the children (list) from map
    // Keep on adding children to the queue. Check if children is null, if not add to the tree
    // Runtime  : 123ms       -> + 5.73%
    // Memory   : 56.07MB     -> + 44.59%
    public static TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> head = new HashSet<>();
        Set<Integer> child = new HashSet<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] desc : descriptions) {
            if(desc[2] == 0) {
                // right: set inner array to map with index=1 to desc[1]
                map.putIfAbsent(desc[0], new ArrayList<>());
                if(map.get(desc[0]).isEmpty()) {
                    map.get(desc[0]).add(0);
                }
                map.get(desc[0]).add(desc[1]);
            } else {
                // left: set inner array to map with index=0 to desc[1]
                map.putIfAbsent(desc[0], new ArrayList<>());
                if(map.get(desc[0]).isEmpty()) {
                    map.get(desc[0]).add(desc[1]);
                } else {
                    map.get(desc[0]).set(0, desc[1]);
                }
            }

            if(head.isEmpty() || (!child.isEmpty() && !child.contains(desc[0]))) {
                head.add(desc[0]);
            }
            if(head.contains(desc[1])) {
                head.remove(desc[1]);
            }
            child.add(desc[1]);
        }

        int root = head.stream().findFirst().get();
        TreeNode ans = new TreeNode(root);
        TreeNode dummy = ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(dummy);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            List<Integer> children = map.get(node.val);
            if(children != null) {
                if(children.get(0) != 0) {
                    node.left = new TreeNode(children.get(0));
                    queue.add(node.left);
                }
                if(children.get(1) != 0) {
                    node.right = new TreeNode(children.get(1));
                    queue.add(node.right);
                }
            }
        }

        return ans;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use Array to store the nodes and children
    // Init nodes and children array with 100001
    // Loop through the descriptions, if node is null, init new TreeNode with desc[0]
    // If node is null, init new TreeNode with desc[1].
    // If desc[2] == 0, set node[desc[0]].right to node[desc[1]]. Else, set node[desc[0]].left to node[desc[1]]
    // Set children[desc[1]] to true.
    // Loop through the descriptions, if children[desc[0]] is false, return node[desc[0]]
    // Runtime  : 12ms        -> + 99.36%
    // Memory   : 56.96MB     -> + 15.60%
    public static TreeNode createBinaryTree2(final int[][] descriptions) {
        final TreeNode[] nodes = new TreeNode[100001];
        final boolean[] children = new boolean[100001];

        for(final int[] description : descriptions) {
            if(nodes[description[0]] == null)
                nodes[description[0]] = new TreeNode(description[0]);

            if(nodes[description[1]] == null)
                nodes[description[1]] = new TreeNode(description[1]);

            if(description[2] == 0)
                nodes[description[0]].right = nodes[description[1]];
            else
                nodes[description[0]].left = nodes[description[1]];

            children[description[1]] = true;
        }

        for(final int[] description : descriptions)
            if(!children[description[0]])
                return nodes[description[0]];

        return null;
    }
    // ***************** End of 2nd Method ******************
}
