package fppQuiz.CommonInterviewCode;

import java.util.*;

public class HireArtAssessment {

    public static void main(String[] args) {
        // rotateArray
        int[] arr = {8,9,10};
        int n = 3, k = 1;
//        System.out.println(Arrays.toString(rotateArray(arr,n,k)));

        // Shared course of Students
        String[][] enrollments1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}
        };

        String[][] enrollments2 = {
                {"0", "Advanced Mechanics"},
                {"0", "Art History"},
                {"1", "Course 1"},
                {"1", "Course 2"},
                {"2", "Computer Architecture"},
                {"3", "Course 1"},
                {"3", "Course 2"},
                {"4", "Algorithms"}
        };
//        System.out.println(findPairs(enrollments1));
//        System.out.println(findPairs2(enrollments1));

        // word-wrap
        List<String> words = Arrays.asList("The", "day", "began", "as", "still", "as", "the",
                "night", "abruptly", "lighted", "with", "brilliant",
                "flame");
        int len = 13;

        System.out.println(wordWrap(words,12));
    }

    // 2,3,4,5,1
    //
    public static int[] rotateArray(int[] arr, int n, int k) {
        int[] ans = new int[n];
        int index = 0;

        for(int i=k+1; i<n; i++) {
            ans[index++] = arr[i];
        }

        for(int i=0; i<=k; i++) {
            ans[index++] = arr[i];
        }

        return ans;
    }

    // find courses they share with friends
    public static Map<String,List<String>> findPairs(String[][] enrollments) {
        Map<String,List<String>> ans = new HashMap<>();
        List<String> studentId = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0; i<enrollments.length; i++) {
            String id = enrollments[i][0];
            if(studentId.isEmpty() || !studentId.contains(id)) {
                studentId.add(id);
            }
            map.put(id, map.getOrDefault(id, new ArrayList<>()));
            map.get(id).add(enrollments[i][1]);
        }
//        System.out.println(studentId);
//        System.out.println(map);

        for(int i=0; i<studentId.size(); i++) {
            String std1 = studentId.get(i);
            List<String> majors = map.get(std1);
            for(int j=i+1; j<studentId.size(); j++) {
                String std2 = studentId.get(j);
                List<String> matchMajor = findMatchMajor(majors,map.get(std2));
                ans.put(std1+","+std2, matchMajor);
            }
        }
        return ans;
    }

    private static List<String> findMatchMajor(List<String> std1, List<String> std2) {
        List<String> ans = new ArrayList<>();
//        Collections.sort(std1);
//        Collections.sort(std2);

        for(int i=0; i<std1.size(); i++) {
            String major1 = std1.get(i);
            for(int j=0; j<std2.size(); j++) {
                if(major1.equals(std2.get(j))) {
                    ans.add(major1);
                    break;
                }
            }
        }
        return ans;
    }

    public static Map<String,List<String>> findPairs2(String[][] enrollments) {
        Map<String, List<String>> coursesByStudent = new HashMap<>();
        for (String[] enrollment : enrollments) {
            String studentId = enrollment[0];
            String course = enrollment[1];
            coursesByStudent.putIfAbsent(studentId, new ArrayList<>());
            coursesByStudent.get(studentId).add(course);
        }

        Map<String, List<String>> sharedCourses = new HashMap<>();
        for (String student1 : coursesByStudent.keySet()) {
            List<String> courses1 = coursesByStudent.get(student1);
            for (String student2 : coursesByStudent.keySet()) {
                // Ensure student1 < student2 for unique key
                if (student1.compareTo(student2) < 0) {
                    List<String> courses2 = coursesByStudent.get(student2);
                    List<String> shared = new ArrayList<>(courses1);
                    // common element of shared & course2 will be retained in shared
                    shared.retainAll(courses2);
                    sharedCourses.put(student1 + "," + student2, shared);
                }
            }
        }
        return sharedCourses;
    }

    public static List<String> wordWrap(List<String> words, int len) {
        List<String> ans = new ArrayList<>();
        StringBuilder curWord = new StringBuilder();
        int curLen = 0;

        for(String word : words) {
            System.out.println(word);
            System.out.println("cur word = " + curWord);

            int wordLen = word.toCharArray().length;
            if(curLen + wordLen == len) {
                System.out.println("==13");
                curWord.append(word);
                ans.add(curWord.toString());
                curWord = new StringBuilder();
            } else if(curLen + wordLen > len){
                System.out.println(">13");
                if(curWord.charAt(curLen-1) == '-') {
                    ans.add(curWord.substring(0,curLen-1));
                } else {
                    ans.add(curWord.toString());
                }
                curWord = new StringBuilder();
                curWord.append(word+"-");
            } else {
                System.out.println("<13");
                curWord.append(word+"-");
            }
            curLen = curWord.length();
            System.out.println(curLen);
            System.out.println("******\n");
        }

        if(!curWord.isEmpty()) {
            ans.add(curWord.substring(0,curLen-1));
        }
        return ans;
    }
}
