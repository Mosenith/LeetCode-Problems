package fppQuiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiuHackerank {
    public static void main(String[] args) {
        // If cat  catches the mouse first, print Cat A.
        //If cat  catches the mouse first, print Cat B.
        //If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
        int x=2; // cat A
        int y=5; // cat B
        int z=4; // mouse C

        List<Integer> ls = List.of(1,1,2,2,4,4,5,5,5);

//        System.out.println(pickingNumbers(ls));

        String s = "#HackerRank";
        System.out.println(minimumNumber(s.length(),s));
    }

    public String catAndMouse(int x, int y, int z) {
        if(Math.abs(x-z) > Math.abs(y-z)) {
            return "Cat B";
        } else if(Math.abs(x-z) < Math.abs(y-z)) {
            return "Cat A";
        }

        return "Mouse C";
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0; i<a.size(); i++) {
            List<Integer> inner = new ArrayList<>();
            int j = i+1;
            inner.add(a.get(i));
            while(a.get(i) == a.get(j) || a.get(j)-a.get(i) <= 1) {
                inner.add(a.get(j));
                j++;
                if(j == a.size())
                    break;
            }
            System.out.println(inner);
            ls.add(inner);
            i = j-1;
        }

        int maxSize = 0;
        for(List<Integer> l : ls) {
            if(l.size() > maxSize) {
                maxSize = l.size();
            }
        }

        return maxSize;
    }


//Its length is at least .
//It contains at least one digit.
//It contains at least one lowercase English character.
//It contains at least one uppercase English character.
//It contains at least one special character. The special characters are: !@#$%^&*()-+

    public static int minimumNumber2(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        int matches = 0;

        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isSpecial = false;
        boolean isNUmber = false;
        for(char c : password.toCharArray()) {
            if(!isLowerCase && Character.isLowerCase(c)) {
                isLowerCase = true;
                matches++;
            } else if(!isUpperCase && Character.isUpperCase(c)) {
                isUpperCase = true;
                matches++;
            } else if(!isNUmber && Character.isDigit(c)) {
                isNUmber = true;
                matches++;
            } else if(!isSpecial){
                isSpecial = true;
                matches++;
            }
        }

//        System.out.println(isSpecial);
//        System.out.println(isNUmber);
//        System.out.println(isLowerCase);
//        System.out.println(isUpperCase);
//
//        System.out.println(matches);

        int len = 0;
        if(password.length() < 6) {
            len = 6 - password.length();
        }
        return Math.max(4-matches, len);
    }

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isSpecial = false;
        boolean isNUmber = false;
        int matches = 4;
        
        for(char c : password.toCharArray()) {
            if(!isSpecial && checkInCases(c, special_characters)) {
                matches--;
                isSpecial = true;
            } else if(!isLowerCase && checkInCases(c, lower_case)) {
                matches--;
                isLowerCase = true;
            } else if(!isUpperCase && checkInCases(c, upper_case)) {
                matches--;
                isUpperCase = true;
            } else if(!isNUmber && checkInCases(c, numbers)) {
                matches--;
                isNUmber = true;
            }
        }


        return Math.max(matches, 6-password.length());
    }


    private static boolean checkInCases(char c, String special_characters) {
        for(char sp : special_characters.toCharArray()) {
            if(c == sp) {
                return true;
            }
        }
        return false;
    }
}
