import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateStackSequences {
    // ***************** 1st Method ******************
    // Runtime  : 1ms      -> + 92.11%
    // Memory   : 41.9MB      -> + 86.95%
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) return false;

        int arrLength = pushed.length;
        List<Integer> stored = new ArrayList<>();
        int i=0, j=0;
        for(; i<arrLength && j<arrLength;) {
            if(pushed[i] != popped[j]) {
                stored.add(pushed[i++]);
            } else {
                j++;
                i++;
                while (j < arrLength && !stored.isEmpty() &&
                        stored.get(stored.size() - 1) == popped[j]) {
                    stored.remove(stored.size() - 1);
                    j++;
                }
            }
        }

        if(j < arrLength || !stored.isEmpty()) {
            return false;
        }

        return true;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 3ms        -> + 79.61%
    // Memory   : 42.5MB      -> + 26.9%

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>(); // Create a stack

        int j = 0; // Initialise one pointer pointing on popped array

        for(int val : pushed){
            st.push(val); // insert the values in stack
            while(!st.isEmpty() && st.peek() == popped[j]){ // if st.peek() values equal to popped[j];
                st.pop(); // then pop out
                j++; // increment j
            }
        }
        return st.isEmpty(); // check if stack is empty return true else false
    }
    //  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
//        int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};

//        int[] pushed = {1,2,3,4,5}, popped = {4,3,5,1,2};
//        int[] pushed = {1,0,3,4,2}, popped = {0,3,1,4,2};
        int[] pushed = {0,1}, popped = {0,1};

        System.out.println(validateStackSequences(pushed,popped));
    }
}
