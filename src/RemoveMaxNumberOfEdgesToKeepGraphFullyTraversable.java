public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};

        RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable rm = new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();
        System.out.println(rm.maxNumEdgesToRemove(n,edges));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Union Find to find the redundant edges
    // Create two UnionFind objects for Alice and Bob, init cnt to 0
    // Loop through edges, if type is 3, union Alice and Bob, else union Alice or Bob
    // Loop through edges, if type is 1 and union fails, increment cnt
    // If type is 2 and union fails, increment cnt
    // Return cnt if Alice and Bob have only 1 component, else return -1
    // Runtime  : 11ms       -> + 83.88%
    // Memory   : 107.66MB   -> + 36.78%
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int cnt = 0;

        for(int[] edge : edges) {
            if(edge[0] == 3) {
                if(alice.union(edge[1], edge[2])) {
                    bob.union(edge[1], edge[2]);
                } else {
                    cnt++;
                }
            }
        }

        for(int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if(type == 1 && !alice.union(u, v)) {
                cnt++;
            }

            if(type == 2 && !bob.union(u, v)) {
                cnt++;
            }
        }
        return alice.count == 1 && bob.count == 1 ? cnt : -1;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        public int count;

        public UnionFind(int count) {
            this.parent = new int[count];
            this.rank = new int[count];
            for(int i=0; i<count; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            this.count = count;
        }

        private int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int x, int y) {
            int rootX = find(x-1);
            int rootY = find(y-1);

            if(rootX == rootY) {
                return false;
            }

            if(rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
            count--;
            return true;
        }
    }
    //  ***************** End of 1st Method ******************
}
