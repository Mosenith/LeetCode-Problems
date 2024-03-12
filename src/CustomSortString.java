import java.util.ArrayDeque;
import java.util.Queue;

public class CustomSortString {
    public static void main(String[] args) {
        String order = "cba", s = "abcd";
    }

    // s = "abcabcd"
    public String customSortString(String order, String s) {
        char[] orderArray = order.toCharArray();
        Queue<Integer> queue = new ArrayDeque<>();
        // read everything in s to map with k-s.charAt(i), v-s.charAt(i) occurrence while checking if it exist in orderSet
        // If not get it to another list or sth





        // Loop in orderArray, if charA in map set it to ans, then reduce it occurrence(>1) or remove it(==1)
        // Out of loop check map, if not empty, get all those keys to ans, doesn't matter about the order
    }
}
