import java.util.Stack;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(numTeams(nums));
    }


    // ***************** 1st Method ******************
    // Approach 1: Use 2 stacks increment and decrement to find the teams
    // Find the teams with incrementing order and decrementing order
    // If increment.size() == 3 or decrement.size() == 3, increment count
    // If start >= rating.length, return
    // If increment is empty or rating[start] > increment.peek(), push rating[start] to increment
    // Call findTeamsIncrement with rating, start+1, increment
    // Pop the last element from increment
    // Call findTeamsIncrement with rating, start+1, increment
    // If decrement is empty or rating[start] < decrement.peek(), push rating[start] to decrement
    // Call findTeamsDecrement with rating, start+1, decrement
    // Pop the last element from decrement
    // Runtime & Memory   : Work but exceed time limit
    static int count;
    public static int numTeams(int[] rating) {
        Stack<Integer> increment = new Stack<>();
        Stack<Integer> decrement = new Stack<>();
        count = 0;

        findTeamsIncrement(rating, 0, increment);
        findTeamsDecrement(rating, 0, decrement);

        return count;
    }

    private static void findTeamsIncrement(int[] rating, int start, Stack<Integer> increment) {
        if(increment.size() == 3) {
            count++;
            return;
        }
        if(start >= rating.length) return;

        if(increment.isEmpty() || rating[start] > increment.peek()) {
            increment.push(rating[start]);
            findTeamsIncrement(rating, start+1, increment);
            increment.pop();
        }

        findTeamsIncrement(rating, start+1, increment);
    }

    private static void findTeamsDecrement(int[] rating, int start, Stack<Integer> decrement) {
        if(decrement.size() == 3) {
            count++;
            return;
        }
        if(start >= rating.length) return;

        if(decrement.isEmpty() || rating[start] < decrement.peek()) {
            decrement.add(rating[start]);
            findTeamsDecrement(rating, start+1, decrement);
            decrement.pop();
        }

        findTeamsDecrement(rating, start+1, decrement);
    }
    //  ***************** End of 1st Method ******************

}
