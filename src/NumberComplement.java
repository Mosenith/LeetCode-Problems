public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement2(2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Get binaryString of num and ^ each digit to a stringBuilder
    // Use Integer.parseInt(flip.toString(),2) to convert it back to int
    // Runtime  : 1ms         -> + 32.48%
    // Memory   : 40.44MB     -> + 22.92%
    public static int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder flip = new StringBuilder();

        for(char s : binary.toCharArray()) {
            flip.append(Character.getNumericValue(s) ^ 1);
        }

        return Integer.parseInt(flip.toString(),2);
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Set time=0, ans=0, loop while num > 0 & have ans += ((num&1)^1)<<time++
    // Then shift num >>= 1 and return ans after loop
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.42MB     -> + 22.92%
    public static int findComplement2(int num) {
        int ans = 0;
        int time = 0;
        while (num > 0){
            ans += ((num&1)^1)<<time++;
            num >>= 1;
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************
}
