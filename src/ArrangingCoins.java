public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }
    public static int arrangeCoins(int n) {
        int step = 0, count = n;
        while(step <= count) {
            count -= ++step;
        }
        return step;
    }
}
