public class NumberOfSeniorCitizens {
    public static void main(String[] args) {
        String[] details = {"5612624052M0130","5378802576M6424","5447619845F0171","2941701174O9078"};

        System.out.println(countSeniors(details));
    }

    // ***************** 1st Method ******************
    // Approach 1: Loop through each string in details
    // Convert the string to char array, then get the age at index 11 and 12
    // If age > 60, increment count
    // Runtime  : 1ms      -> + 82.64%
    // Memory   : 42.53MB  -> + 45.62%
    public static int countSeniors(String[] details) {
        int count = 0;

        for(String s : details) {
            char[] c = s.toCharArray();
            int age = ((c[11] - '0') * 10) + (c[12] - '0');
            if(age > 60) {
                count++;
            }
        }

        return count;
    }
    //  ***************** End of 1st Method ******************



}
