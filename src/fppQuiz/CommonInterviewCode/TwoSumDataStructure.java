package fppQuiz.CommonInterviewCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumDataStructure {
    Set<Integer> storeFind = new HashSet<>();
    Stack<Integer> storeAdd = new Stack<>();

    public void add(int num) {
        if(!storeAdd.isEmpty()) {
            storeFind.add(num + storeAdd.peek());
        } else {
            storeFind.add(num);
        }
        storeAdd.add(num);
    }

    public boolean find(int num) {
        return storeFind.contains(num) ? true : false;
    }
}
