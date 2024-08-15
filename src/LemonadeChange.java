public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};

        System.out.println(lemonadeChange(bills));
    }

    // ***************** 1st Method ******************
    // Approach 1:
    // Runtime  : 3ms      -> + 14.02%
    // Memory   : 56.10MB  -> + 18.73%
    public static boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];

        for(int bill : bills) {
            if(bill == 5) {
                money[0]++;
            } else if(bill == 10) {
                if(money[0] == 0) {
                    return false;
                }
                money[1]++;
                money[0]--;
            } else {
                // 1:10 with 1:5 or 3:5
                if(money[1] > 0 && money[0] > 0) {
                    money[1]--;
                    money[0]--;
                } else if(money[0] >= 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
                money[2]++;
            }
        }

        return true;
    }
    //  ***************** End of 1st Method ******************

}
