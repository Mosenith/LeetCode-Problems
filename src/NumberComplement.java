public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(2));
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

}
