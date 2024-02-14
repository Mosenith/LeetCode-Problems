package fppQuiz.CommonInterviewCode;

import java.util.*;

// Interview Question by HireArt
public class DivideDataSet {
    public static void main(String[] args) {
        String[][] events = {
                {"CONNECT","Alice","Bob"},
                {"DISCONNECT","Bob","Alice"},
                {"CONNECT","Alice","Charlie"},
                {"CONNECT","Dennis","Bob"},
                {"CONNECT","Pam","Dennis"},
                {"DISCONNECT","Pam","Dennis"},
                {"CONNECT","Pam","Dennis"},
                {"CONNECT","Edward","Bob"},
                {"CONNECT","Dennis","Charlie"},
                {"CONNECT","Alice","Nicole"},
                {"CONNECT","Pam","Edward"},
                {"DISCONNECT","Dennis","Charlie"},
                {"CONNECT","Dennis","Edward"},
                {"CONNECT","Charlie","Bob"}
        };

        List<List<String>> ans = divide(events, 1);
        System.out.println(ans);
    }

    public static List<List<String>> divide(String[][] events, int n) {
        Map<String, Set<String>> map = new HashMap<>();

        for(int i=0; i<events.length; i++) {
            String head = events[i][1];
            String tail = events[i][2];
            if(events[i][0].equals("CONNECT")) {
                map.computeIfPresent(head, (k,v) -> {
                    v.add(tail);
                    return v;
                });
                map.computeIfAbsent(head, v -> new HashSet<>());
                map.get(head).add(tail);

                map.computeIfPresent(tail, (k,v) -> {
                    v.add(head);
                    return v;
                });
                map.computeIfAbsent(tail, v -> new HashSet<>());
                map.get(tail).add(head);
            } else {
                map.get(head).remove(tail);
                map.get(tail).remove(head);
            }
        }

        List<List<String>> ans =  new ArrayList<>();
        List<String> lessThanN = new ArrayList<>();
        List<String> moreThanN = new ArrayList<>();

        for(String s : map.keySet()) {
            if(map.get(s).size() >= n) {
                moreThanN.add(s);
            } else {
                lessThanN.add(s);
            }
        }
        ans.add(moreThanN);
        ans.add(lessThanN);

        return ans;
    }
}
