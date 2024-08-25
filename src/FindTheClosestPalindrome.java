import java.util.HashSet;
import java.util.Set;

public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        String n = "100";

//        System.out.println(Integer.valueOf(n));
//        System.out.println(n.substring(0,n.length()/2));
        System.out.println(nearestPalindromic(n));
    }

    public static String nearestPalindromic(String n) {
        if(Integer.valueOf(n) <= 10) return String.valueOf(Integer.valueOf(n)-1);
        int length = n.length();
        Set<String> candidates = new HashSet<>();

        // Edge case: all 9's
        candidates.add(String.valueOf((long) Math.pow(10, length) + 1));  // e.g., 999 -> 1001

        // Generate the first half
        String firstHalf = n.substring(0, (length + 1) / 2);
        for (int offset = -1; offset <= 1; offset++) {
            // Create the palindrome by adjusting the first half
            long newHalf = Long.parseLong(firstHalf) + offset;
            String newHalfStr = String.valueOf(newHalf);
            String palindrome;
            if (length % 2 == 0) {
                palindrome = newHalfStr + new StringBuilder(newHalfStr).reverse().toString();
            } else {
                palindrome = newHalfStr + new StringBuilder(newHalfStr).reverse().substring(1);
            }
            candidates.add(palindrome);
        }
        System.out.println(candidates);
        // Remove the original number if present
        candidates.remove(n);

        // Find the closest palindrome
        String closest = null;
        long minDiff = Long.MAX_VALUE;
        for (String candidate : candidates) {
            long diff = Math.abs(Long.parseLong(candidate) - Long.parseLong(n));
            if (diff < minDiff || (diff == minDiff && Long.parseLong(candidate) < Long.parseLong(closest))) {
                minDiff = diff;
                closest = candidate;
            }
        }

        return closest;
    }

    private static boolean isParlindrome(String tmp) {
        for(int i=0,j=tmp.length()-1; i<j; i++, j--) {
            if(tmp.charAt(i) != tmp.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
