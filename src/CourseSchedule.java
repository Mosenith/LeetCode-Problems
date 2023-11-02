import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        // true
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        // {{0,1},{1,0}} - [[1,0],[0,1]] => false
        int numCourses2= 3;
        int[][] prerequisites2 = {{0,1},{0,2},{2,1}}; // true

        // true
//        int numCourses2= 5;
//        int[][] prerequisites2 = {{1,4},{2,4},{3,1},{3,2}};
        // 4,1,2
        // 1,2,3

        System.out.println(canFinish(numCourses2, prerequisites2));
//        System.out.println(canFinish2(numCourses2, prerequisites2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Basically check if there's a cycle, if so false, otherwise true
    // Create an empty adjacency list (graph), each node = course, edges = prerequisites
    // indegree -> keep track of the num of course can take after preReq
    // Use Queue to store visited Node => Performing Topological Sort using Kahn's Algorithm
    // Runtime  : 4ms            -> + 80.05%
    // Memory   : 43.35MB        -> + 95.28%
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer> ans = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        System.out.println(Arrays.toString(adj));
        System.out.println(Arrays.toString(indegree));


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);

            if (adj[current] != null) {
                for (int next : adj[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return ans.size() == numCourses;
    }

    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use DFS
    // Runtime  : 6ms            -> + 47.41%
    // Memory   : 44.67MB        -> + 13.87%%
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        // key - must take course, value - course to take after prerequisite
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        // Create a map with key from 0 to numCourses & Value = empty arraylist
        for(int i=0; i<numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            int preReqCourse = prerequisites[i][1];
            preMap.get(preReqCourse).add(prerequisites[i][0]);
        }

        System.out.println(preMap);

        // loop from i=0 to numCourses-1
        Set<Integer> visitedSet = new HashSet<>();
        for(int i=0; i<numCourses; i++) {
            if(!dfs(i,preMap,visitedSet))
                return false;
        }

        return true;
    }

    private static boolean dfs(int key, Map<Integer, List<Integer>> preMap, Set<Integer> visitedSet) {
        if(visitedSet.contains(key)) return false;
        if(preMap.get(key).isEmpty()) return true;

        // add current key to visitedSet
        visitedSet.add(key);
        for(int course : preMap.get(key)) {
            if(!dfs(course,preMap,visitedSet))
                return false;
        }
        visitedSet.remove(key);
        // set value to empty arrayList for next check (return true anyway - no need to check again)
        preMap.put(key,new ArrayList<>());
        return true;
    }
    // ***************** End of 2nd Method ******************
}
