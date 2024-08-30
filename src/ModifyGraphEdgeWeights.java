import java.util.*;

public class ModifyGraphEdgeWeights {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}};
        int source = 0;
        int destination = 1;
        int target = 5;

        ModifyGraphEdgeWeights obj = new ModifyGraphEdgeWeights();
        int[][] result = obj.modifiedGraphEdges(n, edges, source, destination, target);
        System.out.println(Arrays.deepToString(result));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Dijkstra's Algorithm to find the shortest path from source to destination
    // First initialize the adjacency list with the edges from 0 to n-1
    // Update the adjacency list with the edges from the input edges
    // Initialize the distances array with the source node as 0 and all other nodes as Integer.MAX_VALUE
    // Run Dijkstra's Algorithm to find the shortest path from source to destination
    // If the difference between the target and the distance from source to destination is less than 0, return empty array
    // Run Dijkstra's Algorithm again to find the shortest path from source to destination with the difference
    // If the distance from source to destination is less than the target, return empty array
    // Update the weight of the edges with -1 to 1
    // Return the updated edges
    // Runtime  : 43ms       -> + 92.93%
    // Memory   : 55.18MB    -> + 9.09%
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adjacencyList = new ArrayList[n];
        // init inner array of adjacencyList
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // update adjacencyList with nodes is either the source or adjacent to adjacencyList[i]
        for (int i = 0; i < edges.length; i++) {
            int nodeA = edges[i][0], nodeB = edges[i][1];
            adjacencyList[nodeA].add(new int[]{nodeB, i});
            adjacencyList[nodeB].add(new int[]{nodeA, i});
        }

        int[][] distances = new int[n][2];
        Arrays.fill(distances[source], 0);
        for (int i = 0; i < n; i++) {
            if (i != source) {
                distances[i][0] = distances[i][1] = Integer.MAX_VALUE;
            }
        }

        runDijkstra(adjacencyList, edges, distances, source, 0, 0);
        int difference = target - distances[destination][0];
        if (difference < 0) return new int[][]{};
        runDijkstra(adjacencyList, edges, distances, source, difference, 1);
        if (distances[destination][1] < target) return new int[][]{};

        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1;
        }
        return edges;
    }

    private void runDijkstra(List<int[]>[] adjacencyList, int[][] edges, int[][] distances, int source, int difference, int run) {
        int n = adjacencyList.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priorityQueue.add(new int[]{source, 0});
        distances[source][run] = 0;

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > distances[currentNode][run]) continue;

            for (int[] neighbor : adjacencyList[currentNode]) {
                int nextNode = neighbor[0], edgeIndex = neighbor[1];
                int weight = edges[edgeIndex][2];

                if (weight == -1) weight = 1;

                if (run == 1 && edges[edgeIndex][2] == -1) {
                    int newWeight = difference + distances[nextNode][0] - distances[currentNode][1];
                    if (newWeight > weight) {
                        edges[edgeIndex][2] = weight = newWeight;
                    }
                }

                if (distances[nextNode][run] > distances[currentNode][run] + weight) {
                    distances[nextNode][run] = distances[currentNode][run] + weight;
                    priorityQueue.add(new int[]{nextNode, distances[nextNode][run]});
                }
            }
        }
    }
    // ***************** End of 1st Method ******************
}
