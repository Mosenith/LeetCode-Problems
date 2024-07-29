import java.util.Stack;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[] nums = {2,5,3,4,1};

        System.out.println(numTeams(nums));
        System.out.println(numTeams2(nums));

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

    // ***************** 2nd Method ******************
    // Approach 2: Optimize the 1st method by using nested loop
    // The main idea is to choose a middle soldier and count the number of soldiers on the left and right side
    // Count solders on the left that are less than the middle soldier and more than the middle soldier
    // Count solders on the right that are less than the middle soldier and more than the middle soldier
    // Multiplying the number of soldiers that are less on the left and more on the right
    // Multiply the number of soldiers that are more on the left and less on the right
    // Add the result to the count
    // Runtime  : 16ms     -> + 82.28%
    // Memory   : 41.78MB  -> + 98.45%
    public static int numTeams2(int[] rating) {
        int count = 0;
        int n = rating.length;

        // Loop through each soldier as the middle soldier
        for (int j = 1; j < n - 1; j++) {
            int lessLeft = 0, moreLeft = 0, lessRight = 0, moreRight = 0;
            // Count soldiers on the left side
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) lessLeft++;
                if (rating[i] > rating[j]) moreLeft++;
            }

            // Count soldiers on the right side
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) lessRight++;
                if (rating[k] > rating[j]) moreRight++;
            }

            // Calculate the number of valid teams
            count += lessLeft * moreRight + moreLeft * lessRight;
        }

        return count;
    }
    //  ***************** End of 2nd Method ******************

}
