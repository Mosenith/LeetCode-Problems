public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int[] tickets = {5,1,1,1};
        int k = 0;

        System.out.println(timeRequiredToBuy2(tickets,k));
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

    // ***************** 2nd Method ******************
    // Approach 2: Check i & k, if i<=k, ans+=min(t[i],t[k])
    // Otherwise, ans += min(t[k]-1, t[i])
    // Runtime  : 0ms      -> + 100.00%
    // Memory   : 41.64MB  -> + 14.23%
    public static int timeRequiredToBuy2(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                ans += Math.min(tickets[k], tickets[i]);
            } else {
                ans += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************

}
