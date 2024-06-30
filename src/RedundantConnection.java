import java.util.Arrays;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};

        RedundantConnection rc = new RedundantConnection();
        System.out.println(Arrays.toString(rc.findRedundantConnection(edges)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Union Find to find the redundant connection
    // Create a UnionFind class with parent and rank arrays
    // Initialize parent and rank arrays with n
    // Loop through edges, if union of n1 and n2 is true, return the edge
    // Runtime  : 0ms      -> + 100.00%
    // Memory   : 43.12MB   -> + 45.15%
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for(int[] n : edges) {
            if(uf.union(n[0], n[1])) {
                return n;
            }
        }
        return new int[] {};
    }

    // union find class
    public class UnionFind {
        private int[] parent;
        public int count;

        public UnionFind(int n) {
            this.parent = new int [n];
            for(int i=0; i<n; i++) {
                parent[i] = i;
            }
            this.count = n;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2) {
                return false;
            }

            parent[p1] = p2;
            count--;

            return true;
        }

        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
    //  ***************** End of 1st Method ******************
}



