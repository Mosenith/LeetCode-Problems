public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int[] tickets = {2,3,2};
        int k = 2;

        System.out.println(timeRequiredToBuy(tickets,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Using while loop to track tickets[k] = 0 or not
    // When it gets to 0, break. Each iteration time++ and renew i when i=tickets.len
    // Runtime  : 2ms      -> + 45.56%
    // Memory   : 41.59MB  -> + 17.22%
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int i = 0;

        while(tickets[k] != 0) {
            if(tickets[i] != 0) {
                time++;
                tickets[i]--;
            }
            i++;
            if(i == tickets.length) {
                i = 0;
            }
        }

        return time;
    }
    //  ***************** End of 1st Method ******************

}
