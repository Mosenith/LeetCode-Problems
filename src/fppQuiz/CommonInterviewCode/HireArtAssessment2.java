package fppQuiz.CommonInterviewCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HireArtAssessment2 {

    public static void main(String[] argv) {

        String[][] records1 = {
                {"Paul", "enter"},
                {"Pauline", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"},
        };

        String[][] records2 = {
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        String[][] records3 = {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        String[][] records4 = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"},
        };

        System.out.println(checkAccessRoom(records1));
    }
    public static List<List<String>> checkAccessRoom(String[][] record) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls1 = new ArrayList<>();
        List<String> ls2 = new ArrayList<>();
//        Set<String> enterSet = new HashSet();
        List<String> enterName = new ArrayList<>();

        for(int i=0; i<record.length; i++) {
            System.out.println(record[i][0]);
            if(record[i][1].equals("enter")) {
                // enter and enter again
                if(enterName.contains(record[i][0])) {
                    if(!ls1.contains(record[i][0])) {
                        ls1.add(record[i][0]);
                    }
//                    enterSet.remove(record[i][0]);
                    enterName.remove(record[i][0]);
                } else {
//                    enterSet.add(record[i][0]);
                    enterName.add(record[i][0]);
                }
            } else {
                // exit without enter
                if(!enterName.contains(record[i][0])) {
                    System.out.println("exit without enter");
                    if(!ls2.contains(record[i][0])) {
                        ls2.add(record[i][0]);
                    }
                } else {
                    enterName.remove(record[i][0]);
                }
            }
            System.out.println(enterName);
            System.out.println("*****\n");
        }
        System.out.println(ls1);
        System.out.println(ls2);
        while(!enterName.isEmpty()) {
            String name = enterName.remove(enterName.size()-1);
            System.out.println(name);
            if(!ls1.contains(name))
                ls1.add(name);
        }

        ans.add(ls1);
        ans.add(ls2);
        return ans;
    }
}
