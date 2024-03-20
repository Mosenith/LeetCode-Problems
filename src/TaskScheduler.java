import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
//        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'}; // n = 2 => 8
//        char[] tasks = {'A', 'C', 'A', 'B', 'D', 'B'};  // n = 1 => 6
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};  // n = 3 => 10

        System.out.println(leastInterval(tasks,3));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> intakeMap = new HashMap<>();
        Queue<Character> waitQueue = new LinkedList<>();
        int intervals = 0, coolDown = 0;

        for(int i=0; i<tasks.length; i++) {
            char c = tasks[i];
            System.out.println("at i=" + i + " => c=" + c);
            if(!waitQueue.isEmpty()) {
                if(waitQueue.peek() != c) {
                    coolDown++;
                    System.out.println("update coolDown=" + coolDown);
                } else {
                    waitQueue.add(c);
                    continue;
                }
            }
            if(intakeMap.isEmpty() || !intakeMap.containsKey(c) || intakeMap.get(c) < n-1) {
                intakeMap.put(c,intakeMap.getOrDefault(c,0) + 1);
                intervals++;
                if(i>0 && c!=tasks[i-1]) {
                    intakeMap.put(tasks[i-1],intakeMap.getOrDefault(c,0)-1);
                    if(intakeMap.get(tasks[i-1])<=0) {
                        intakeMap.remove(tasks[i-1]);
                    }
                }
            } else {
                if(intakeMap.containsKey(c) && intakeMap.get(c) == n) {
                    intakeMap.remove(c);
                }
                waitQueue.add(c);
            }
            if(coolDown == n) {
                intervals += (coolDown + 1);
                waitQueue.poll();
                coolDown = 0;
            }
            System.out.println(intakeMap);
            System.out.println(waitQueue);
            System.out.println("coolDown=" + coolDown);
            System.out.println("****** " + intervals + " ******\n");
        }

        while(!waitQueue.isEmpty()) {
            System.out.println(coolDown);
            coolDown++;
            if(coolDown == n) {
                intervals += (n-1);
                coolDown = 0;
                waitQueue.poll();
            }
        }
        return intervals;
    }
}
