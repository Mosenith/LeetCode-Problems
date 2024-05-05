import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {1,5,3,5}; // 2
        int limit = 7;

        System.out.println(numRescueBoats(people,limit));
    }

    // ***************** 1st Method ******************
    // Approach 1: Sort array and use 2 pointers
    // Check if sum of the left & right <= limit, boat++ & i++, j--
    // Else boat++, only decrement the right j--
    // Runtime  : 16ms      -> + 97.12%
    // Memory   : 53.40MB   -> + 73.47%
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat = 0;

        for(int i=0,j=people.length-1; i<=j;) {
            if(people[i] + people[j] <= limit ) {
                boat++;
                i++; j--;
            } else {
                boat++;
                j--;
            }
        }

        return boat;
    }
    //  ***************** End of 1st Method ******************
}
