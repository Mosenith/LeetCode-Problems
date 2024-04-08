import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};

        System.out.println(countStudents(students,sandwiches));
    }

    // ***************** 1st Method ******************
    // Approach 1: Read students[] to queue & loop through sandwiches
    // Loop through queue till sandwiches[i]=queue.peek(), pop different element and add to the tail
    // Also keep track of the total iteration (queue.size)
    // So if student =[1,1,1] & sandwich[0,...], after looping 3 times, it'll back to the start
    // So if #round = queue.size, just return queue.size() -> students unable to eat
    // Runtime  : 1ms         -> + 71.05%
    // Memory   : 40.96MB     -> + 95.65%
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new ArrayDeque<>();

        // get students into queue
        for(int student : students) {
            studentsQueue.add(student);
        }

        for (int sandwich : sandwiches) {
            int cnt = studentsQueue.size();
            int round = 0;
            while (!studentsQueue.isEmpty() && studentsQueue.peek() != sandwich) {
                if (round == cnt) {
                    return studentsQueue.size();
                }
                int tmp = studentsQueue.poll();
                studentsQueue.add(tmp);
                round++;
            }
            studentsQueue.poll();
        }

        return studentsQueue.size();
    }
}
