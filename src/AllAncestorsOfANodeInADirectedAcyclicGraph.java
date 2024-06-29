import java.util.*;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        int n = 8;

        System.out.println(getAncestors(n,edges));
    }

    // ***************** 1st Method ******************
    // Approach 1: Create a reverse graph and perform topological sort
    // Create a reverse graph (reverse the edges), perform topological sort to process nodes in a valid order
    // Ancestors set to avoid duplicates and store ancestors of each node
    // Process each node in topological order and store ancestors in the set
    // Convert the set to a sorted list for the final result
    // Runtime  : 85ms      -> + 53.00%
    // Memory   : 76.40MB   -> + 39.27%
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Create a reverse graph (reverse the edges)
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            reverseGraph.get(edge[1]).add(edge[0]);
        }

        // Perform topological sort to process nodes in a valid order
        List<Integer> topoOrder = topologicalSort(n, edges);

        // Ancestors set to avoid duplicates and store ancestors of each node
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        // Process each node in topological order
        for (int node : topoOrder) {
            for (int ancestor : reverseGraph.get(node)) {
                ancestors.get(node).add(ancestor);
                ancestors.get(node).addAll(ancestors.get(ancestor));
            }
        }

        // Convert the set to a sorted list for the final result
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> sortedAncestors = new ArrayList<>(ancestors.get(i));
            Collections.sort(sortedAncestors);
            result.add(sortedAncestors);
        }

        return result;
    }

    private static List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> topoOrder = new ArrayList<>();
        int[] inDegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoOrder;
    }
    //  ***************** End of 1st Method ******************
}
