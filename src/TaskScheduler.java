import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        System.out.println(leastInterval(tasks,n));
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
                } else {
                    waitQueue.add(c);
                    continue;
                }
            }
            if(intakeMap.isEmpty() || !intakeMap.containsKey(c) || intakeMap.get(c) < n) {
                intakeMap.put(c,intakeMap.getOrDefault(c,0) + 1);
                intervals++;
            } else {
                if(intakeMap.containsKey(c) && intakeMap.get(c) == n) {
                    intakeMap.remove(c);
                }
                waitQueue.add(c);
            }
            if(coolDown == n) {
                intervals++;
                coolDown = 0;
            }
            System.out.println(intakeMap);
            System.out.println(waitQueue);
            System.out.println("***********\n");
        }
        return intervals;
    }
}
