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
        System.out.println(canFinish2(numCourses2, prerequisites2));
    }

    // false
    // 3
    // [[1,0],[0,2],[2,1]]
    // must -> 0-1-2-0-2
    // then -> 1,0,2
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        // key - must take course, value - course to take after prerequisite
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        // Create a map with key from 0 to numCourses & Value = empty arraylist
        for(int i=0; i<numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            System.out.println(Arrays.toString(prerequisites[i]));
            int preReqCourse = prerequisites[i][1];

            preMap.get(preReqCourse).add(prerequisites[i][0]);
            System.out.println("#####\n");
        }

        System.out.println(preMap);

        // loop from i=0 to numCourses-1
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numCourses; i++) {
            if(!dfs(i,preMap,set))
                return false;
        }

        return true;
    }

    private static boolean dfs(int key, Map<Integer, List<Integer>> preMap, Set<Integer> set) {
        if(set.contains(key)) return false;
        if(preMap.get(key).isEmpty()) return true;

        set.add(key);
        for(int course : preMap.get(key)) {
            if(!dfs(course,preMap,set))
                return false;
        }
        set.remove(key);
        preMap.put(key,new ArrayList<>());
        return true;
    }
}
