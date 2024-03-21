import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
//        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'}; // n = 2 => 8
//        char[] tasks = {'A', 'C', 'A', 'B', 'D', 'B'};  // n = 1 => 6
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};  // n = 3 => 10

        System.out.println(leastInterval(tasks,3));
    }

    public static int leastInterval(char[] tasks, int n) {
        Set<Character> intakeSet = new HashSet<>();
        Queue<Character> waitQueue = new LinkedList<>();
        int intervals = 0, coolDown = 0;

        for(int i=0; i<tasks.length; i++) {
            char c = tasks[i];
            System.out.println("at i=" + i + " => c=" + c);
            // no char or not contain c, add to set
            if(intakeSet.isEmpty() || ! intakeSet.contains(c)) {
                intakeSet.add(c);
            } else {
                waitQueue.add(c);
            }
            System.out.println("coolDown=" + coolDown);
            System.out.println("****** " + intervals + " ******\n");
        }
        System.out.println(intakeSet);
        System.out.println(waitQueue);

        return intervals;
    }
}
