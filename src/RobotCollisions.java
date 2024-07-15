import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {
    public static void main(String[] args) {

    }

    /*
    * There are n 1-indexed robots, each having a position on a line, health, and movement direction.

You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.

All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever share the same position while moving, they will collide.

If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one. The surviving robot continues in the same direction it was going. If both robots have the same health, they are both removed from the line.

Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, i.e. final heath of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.

Return an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.

Note: The positions may be unsorted.

*/
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        for (int i = 0; i < n; i++) {
            int index = indices[i];
            if (directions.charAt(index) == 'L') {
                while (!stack.isEmpty() && healths[stack.peek()] >= healths[index] && positions[stack.peek()] >= positions[index]) {
                    if (healths[stack.peek()] == healths[index]) {
                        stack.pop();
                    } else {
                        healths[stack.peek()]--;
                        stack.pop();
                    }
                }
            } else {
                stack.push(index);
            }
        }

        while (!stack.isEmpty()) {
            result.add(healths[stack.pop()]);
        }

        return result;
    }
}
