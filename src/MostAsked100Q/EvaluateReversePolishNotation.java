package MostAsked100Q;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        String[] tokens = {"2","1","+","3","*"};

        System.out.println(evalRPN(tokens));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Set to store all operations (+,-,*,/) and stack
    // Loop Tokens, if operation.contain(token) => 1st In (opt) 2nd In (switch)
    // Else, push to Stack
    // Return stack.pop()
    // Runtime  : 7ms            -> + 33.22%
    // Memory   : 42.68MB        -> + 96.67%
    public static int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens) {
            if(!operators.contains(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int tmp = 0;
                int tmpSec = stack.pop();
                int tmpFirst = stack.pop();
                switch (s) {
                    case "+":
                        tmp += tmpFirst + tmpSec;
                        break;
                    case "-":
                        tmp += tmpFirst - tmpSec;
                        break;
                    case "*":
                        tmp += tmpFirst * tmpSec;
                        break;
                    case "/":
                        tmp += tmpFirst / tmpSec;
                        break;
                }
                stack.push(tmp);
            }
        }
        return stack.pop();
    }
    // ***************** End of 1st Method ******************

}
