package fppQuiz.CommonInterviewCode;

public class ZipRecruiterAssessment {
    public static int longestCommonPrefix(int[] firstArray, int[] secondArray) {
        int maxLength = 0;

        for (int num1 : firstArray) {
            for (int num2 : secondArray) {
                int prefixLength = getCommonPrefixLength(num1, num2);
                maxLength = Math.max(maxLength, prefixLength);
                System.out.println("*******\n");
            }
        }

        return maxLength;
    }

    public static int getCommonPrefixLength(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        System.out.println(str1 + " : " + str2);

        int minLength = Math.min(str1.length(), str2.length());
        int prefixLength = 0;

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                System.out.println(str1.charAt(i) + " : " + str2.charAt(i));
                prefixLength++;
            } else {
                break;
            }
        }

        return prefixLength;
    }

    public static void main(String[] args) {
//        int[] firstArray = {25, 288, 2655, 54546, 54, 555};
//        int[] secondArray = {2, 255, 266, 244, 26, 5, 54547};

        int[] firstArray = {25, 288, 2655, 544, 54, 555};
        int[] secondArray = {2, 255, 266, 244, 26, 5, 5444444};


        int result = longestCommonPrefix(firstArray, secondArray);
        System.out.println("Length of longest common prefix: " + result);
    }
}
