import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        // true
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        // {{0,1},{1,0}} - [[1,0],[0,1]] => false
        int numCourses2= 3;
        int[][] prerequisites2 = {{0,1},{0,2},{2,1}};

        // true
//        int numCourses2= 5;
//        int[][] prerequisites2 = {{1,4},{2,4},{3,1},{3,2}};
        // 4,1,2
        // 1,2,3

//        System.out.println(prerequisites2[3][0]);
        System.out.println(canFinish(numCourses2, prerequisites2));
    }

    // false
    // 3
    // [[1,0],[0,2],[2,1]]
    // must -> 0-1-2-0-2
    // then -> 1,0,2
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        System.out.println(adj);

        int[] preReqRequired = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int preReq = prerequisites[i][1];
            adj.get(preReq).add(prerequisites[i][0]);
            preReqRequired[prerequisites[i][0]]++;
        }
        System.out.println(Arrays.toString(preReqRequired));
        System.out.println("current adj -> " + adj);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(preReqRequired[i]==0){
                queue.add(i);
            }
        }

        System.out.println("queue -> " + queue);
        List<Integer> topoOrder = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            topoOrder.add(curr);
            for(int i=0;i<adj.get(curr).size();i++){
                preReqRequired[adj.get(curr).get(i)]--;
                if(preReqRequired[adj.get(curr).get(i)]==0){
                    queue.add(adj.get(curr).get(i));
                }
            }
        }
        if(topoOrder.size() == numCourses) return true;
        return false;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (var p : prerequisites) {
            int a = p[0], b = p[1];
            g[b].add(a);
            ++indeg[a];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            ++cnt;
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return cnt == numCourses;
    }
}
