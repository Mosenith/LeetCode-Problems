package AlgorithmsCode;

import java.util.Arrays;
import java.util.List;

public class DetectSpecialCharacter {
    // List<String> ls = {"ad*dsa", "adfhiaf"}
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("a d*dsa","jfasdf-");


        for(int i=0; i<ls.size(); i++) {
            String tmp = ls.get(i);
            if(tmp.contains("*") || tmp.contains("#")) {
                System.out.println("True -> " + tmp);
            }
        }


    }
}
