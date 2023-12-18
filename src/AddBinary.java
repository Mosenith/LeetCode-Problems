import java.util.Stack;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";  // 10101
//        String a = "11", b = "1";   // 100

//        String a = "100", b = "110010"; // 110110
            //   110010
        //       110110

        System.out.println(addBinary(a,b));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use 2 pointer for string a & b, cal remain at each digit
    // Each iteration update remain => remain /= 2 & res.append(res%2)
    // remain = 3 (max) => remain-1, res-1
    // remain = 2 => remain-1, res-0
    // remain <=1 => remain-0, res-remain
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.62MB     -> + 35.13%
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        // i->a, j->b
        int i=a.length()-1, j=b.length()-1;
        int remain = 0;

        while(i >= 0 || j >= 0 || remain == 1) {
            System.out.println("cur remain = " + remain);
            if(i>=0) {
                remain += a.charAt(i--) - '0'; // convert to int by - '0'
            }

            if(j>=0) {
                remain += b.charAt(j--) - '0';
            }

            // remain = 3 (max) => remain-1, res-1
            // remain = 2 => remain-1, res-0
            // remain <=1 => remain-0, res-remain
            res.append(remain%2);
            remain /= 2;
        }

        return res.reverse().toString();
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Brute Force - consider cases of each digit
    // Runtime  : 3ms         -> + 29.79%
    // Memory   : 42.28MB     -> + 20.94%
    public static String addBinary2(String a, String b) {
        // i-a, j-b
        int i = a.length()-1, j = b.length()-1;
        Stack<Character> stack = new Stack<>();
        int remainder = 0;

        for(; i>=0 && j>=0; i--, j--) {
            int curSum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j));

            if(remainder == 0) {
                if(curSum <= 1) {
                    stack.add((char) (curSum + '0'));
                } else {
                    stack.add('0');
                    remainder = 1;
                }
            } else {
                if(curSum == 0) {
                    stack.add('1');
                    remainder = 0;
                } else if(curSum == 1) {
                    stack.add('0');
                    remainder = 1;
                } else if(curSum == 2) {
                    stack.add('1');
                    remainder = 1;
                }
            }

        }

        while(i >= 0) {
            int curSum = Character.getNumericValue(a.charAt(i)) + remainder;
            if(curSum <= 1) {
                stack.add((char) (curSum + '0'));
                remainder = 0;
            } else {
                stack.add('0');
                remainder = 1;
            }
            i--;
        }

        while(j >= 0) {
            int curSum = Character.getNumericValue(b.charAt(j)) + remainder;
            if(curSum <= 1) {
                stack.add((char) (curSum + '0'));
                remainder = 0;
            } else {
                stack.add('0');
                remainder = 1;
            }
            j--;
        }

        if(remainder != 0) {
            stack.add('1');
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }
    // ***************** End of 2nd Method ******************

}
