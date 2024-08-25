import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        String n = "999";

//        System.out.println(Integer.valueOf(n));
//        System.out.println(n.substring(0,n.length()/2));
        System.out.println(nearestPalindromic(n));
    }

    // ***************** 1st Method ******************
    // Approach 1: Check base case when n = 1, return 0
    // Create a set to store possible palindrome candidates
    // Add edge cases bigger & smaller than n, e.g., 999 -> 1001, 100 -> 99
    // Handle the prefix part to create possible palindrome candidates by adding -1, 0, 1
    // To create a palindrome, check if the length is odd, remove the last digit
    // Then add the reverse of the prefix to the end of the prefix
    // Find the closest palindrome by comparing the difference and the value
    // The return ans must not be equal to n
    // Runtime  : 4ms        -> + 24.86%
    // Memory   : 42.11MB    -> + 14.15%
    public static String nearestPalindromic(String n) {
        if (n.equals("1")) return "0"; // Special case for "1"

        int length = n.length();
        Set<Long> candidates = new HashSet<>();

        // Edge cases: 1000 -> 999, 100 -> 99
        candidates.add((long) Math.pow(10, length) + 1);  // e.g., 999 -> 1001
        candidates.add((long) Math.pow(10, length - 1) - 1);  // e.g., 100 -> 99

        // Handle the prefix part to create possible palindrome candidates
        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));
        for (int i = -1; i <= 1; i++) {
            String candidate = createPalindrome(String.valueOf(prefix + i), length % 2 == 0);
            if(!candidate.equals(n)) {
                candidates.add(Long.parseLong(candidate));
            }
        }

        // Find the closest palindrome
        long minDiff = Long.MAX_VALUE;
        long closest = 0;
        long num = Long.parseLong(n);
        for (long candidate : candidates) {
            long diff = Math.abs(candidate - num);
            if (diff < minDiff || (diff == minDiff && candidate < closest)) {
                minDiff = diff;
                closest = candidate;
            }
        }

        return String.valueOf(closest);
    }

    private static String createPalindrome(String half, boolean evenLength) {
        StringBuilder sb = new StringBuilder(half);
        if (!evenLength)
            sb.setLength(sb.length() - 1); // Remove the last digit for odd length palindromes
        return half + sb.reverse().toString();
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar to 1st Method but more optimized
    // Runtime  : 2ms        -> + 95.60%
    // Memory   : 41.58MB    -> + 81.84%
    public static String nearestPalindromic2(String n) {
        int len = n.length();
        int i = len % 2 == 0 ? len / 2 - 1: len / 2;
        long left = Long.parseLong(n.substring(0, i+1));

        // input: n 12345
        List<Long> candidate = new ArrayList<>();
        candidate.add(getPalindrome(left, len % 2 == 0)); // 12321
        candidate.add(getPalindrome(left+1, len % 2 == 0)); // 12421
        candidate.add(getPalindrome(left-1, len % 2 == 0)); // 12221
        candidate.add((long)Math.pow(10, len-1) - 1); // 9999
        candidate.add((long)Math.pow(10, len) + 1); // 100001

        long diff = Long.MAX_VALUE, res = 0, nl = Long.parseLong(n);
        for (long cand : candidate) {
            if (cand == nl) continue;
            if (Math.abs(cand - nl) < diff) {
                diff = Math.abs(cand - nl);
                res = cand;
            } else if (Math.abs(cand - nl) == diff) {
                res = Math.min(res, cand);
            }
        }

        return String.valueOf(res);
    }

    private static long getPalindrome(long left, boolean even) {
        long res = left;
        if (!even) left = left / 10;
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }
    // ***************** End of 1st Method ******************
}
