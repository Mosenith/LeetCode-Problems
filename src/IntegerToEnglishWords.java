import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(12345));
        System.out.println();
        System.out.println(numberToWords(123));
        System.out.println();
        System.out.println(numberToWords(1001));
        System.out.println();
        System.out.println(numberToWords(9099));
        System.out.println();
        System.out.println(numberToWords(1010101));
        System.out.println();
        System.out.println(numberToWords(100000100));

    }

    // ***************** 1st Method ******************
    // Approach : Use hashmap to store all special case of counting number i.e. 0-19,20,...
    // For-loop from i=10^9(billion) to 1000, each iteration is divided by 1000
    // Process the 3 digits of num/i, then append the appropriate numerical value (thousand,million, or billion)
    // Process 3 digits -> handle hundred, 0-19, 20, 30, ...
    // return ans.substring(1) due the space at 0 index
    // Runtime  : 3ms        -> + 80.08%
    // Memory   : 40.40 MB    -> + 95.23%%
    private static Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(0, ""); // "" here when 0 exist with other nums, if num=0, return "Zero"
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
    }

    public static String numberToWords(int num) {
        if(num == 0) return "";
        StringBuilder ans = new StringBuilder();

        if(num >= 1000) {
            for(int i=1000000000; i>=1000; i/=1000) {
                if(num >= i) {
                    ans.append(processThreeDigits(num/i)).append(" " + map.get(i));
                    num %= i;
                }

            }
        }
        ans.append(processThreeDigits(num));

        return String.valueOf(ans.substring(1));
    }
    private static String processThreeDigits(int n) {
        StringBuilder s = new StringBuilder();
        while(n > 0) {
            if(n >= 100) {
                s.append(" ").append(map.get(n/100)).append(" " + map.get(100));
                n %= 100;
            } else if(n >= 20 && n < 100) {
                int head = (n/10) * 10;
                s.append(" " + map.get(head));
                n %= 10;
            } else if(n>=1 && n <=19) {
                s.append(" " + map.get(n));
                n %= n;
            }
        }
        return String.valueOf(s);
    }
    // ***************** End of 1st Method ******************
}
