import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};

        System.out.println(lemonadeChange2(bills));
    }

    // ***************** 1st Method ******************
    // Approach 1: Loop through the bills and check if the cashier can give the correct change
    // Use an array to store the number of 5 and 10 bills
    // If the bill is 5, increment the number of 5 bills
    // If the bill is 10, check if there is a 5 bill to give change
    // If the bill is 20, check if there is a 10 bill and a 5 bill or three 5 bills to give change
    // If the cashier cannot give the correct change, return false
    // Runtime  : 2ms      -> +95.12%
    // Memory   : 55.74MB  -> +63.21%
    public static boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];

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
            }
        }

        return true;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar approach but use
    // Runtime  : 2ms      -> +95.12%
    // Memory   : 55.74MB  -> +63.21%
    public static boolean lemonadeChange2(int[] bills) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);

        for(int bill : bills) {
            if(bill == 5) {
                map.put(5,map.get(5)+1);
            } else if(bill == 10) {
               if(map.get(5) == 0) return false;
                map.put(5,map.get(5)-1);
                map.put(10,map.get(10)+1);
            } else {
                if(map.get(10)==0 || map.get(5) < 3) return false;
                if(map.get(10) > 0) {
                    map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)-1);
                } else if(map.get(5) >= 3){
                    map.put(5,map.get(5)-3);
                }
            }
        }
        return true;
    }
    //  ***************** End of 1st Method ******************
}
