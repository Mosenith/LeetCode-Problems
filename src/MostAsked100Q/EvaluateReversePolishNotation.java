package MostAsked100Q;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] tokens = {"4","3","-"};

        System.out.println(evalRPN(tokens));
        System.out.println(evalRPN2(tokens));
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

    // ***************** 2nd Method ******************
    // Approach 2: Use switch to validate case => +,-,*,/ & number
    // case - => -(stack.pop - stack.pop)
    // case / => secPop / firstPop
    // return stack.pop()
    // Runtime  : 7ms            -> + 33.22%
    // Memory   : 42.68MB        -> + 96.67%
    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            int tmp = 0;
            switch (token) {
                case "+":
                    tmp += stack.pop() + stack.pop();
                    stack.push(tmp);
                    break;
                case "-":
                    tmp += -(stack.pop() - stack.pop());
                    stack.push(tmp);
                    break;
                case "*":
                    tmp += stack.pop() * stack.pop();
                    stack.push(tmp);
                    break;
                case "/":
                    int first = stack.pop();
                    int sec = stack.pop();
                    tmp += sec / first;
                    stack.push(tmp);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
    // ***************** End of 2nd Method ******************
}
