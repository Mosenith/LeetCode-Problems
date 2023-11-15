package AlgorithmsCode;

import java.util.Arrays;

public class ReverseStringRecursion {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        reverseString(s);
        System.out.println(Arrays.toString(s));

        char[] s1 = {'h','e','l','l','o'};
        recursiveReverse(s1);
        System.out.println(Arrays.toString(s1));
    }

    // 1st method - Using Pointer
    public static void reverseString(char[] s) {
        for(int i=0, j=s.length-1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    // 2nd method - Using Recursive
    public static void recursiveReverse(char[] s) {
        int left = 0, right = s.length-1;

        recursiveFunction(s, left, right);
    }

    private static void recursiveFunction(char[] s, int left, int right) {
        if(left >= right) return;

        char c = s[left];
        s[left] = s[right];
        s[right] = c;

        recursiveFunction(s, left+1, right-1);
    }
}
