import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    public static void main(String[] args) {
        int[] seats = {3,1,5};
        int[] students = {2,7,4};

        System.out.println(minMovesToSeat(seats,students));
    }

    // ***************** 1st Method ******************
    // Approach 1: Sort both arrays and calculate the difference
    // Runtime  : 2ms     -> + 97.35%
    // Memory   : 43.88MB -> + 80.64%
    public static int minMovesToSeat(int[] seats, int[] students) {
        int moves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i=0; i<seats.length; i++) {
            moves += Math.abs(students[i] - seats[i]);
        }

        return moves;
    }
    // ***************** End of 1st Method ******************
}
