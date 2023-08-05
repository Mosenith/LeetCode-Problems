import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {


        int out = 0;
        int count = 0;
        List<String> store = new ArrayList<String>();

        //store[0] = String.valueOf(s.charAt(0));
        //store[i] = String.valueOf(s.charAt(i));

        for(int i=0; i<s.length(); i++){
            //System.out.println(s.charAt(i) + ":" + store);
            String curr = String.valueOf(s.charAt(i));
            int curr_index = store.indexOf(curr);

            if(!store.contains(curr)){
                store.add(curr);
                count++;
                //System.out.println("Count Value: " + count);
            } else {

                int leftLength = s.length() - curr_index + 1;
                if(leftLength > count){
                    if(count > out){
                        out = count;
                    }

                    if(curr_index == store.size()-1){
                        // duplicated letter is the last one in the List
                        store = new ArrayList<String>();
                        store.add(curr);
                        count = 1;
                    } else {
                        for(int j=curr_index; j>=0; j--){
                            System.out.println(store.get(j));
                            store.remove(j);
                            count--;
                        }

                        store.add(curr);
                        count++;
                    }
                } else {
                    break;
                }

            }

        }
        //return Math.max(out, count);
        return (out > count) ? out : count;
    }


    public static void main(String[] args) {

        String wd = "jessica";

        System.out.println(lengthOfLongestSubstring("vasquez"));

        //System.out.println(wd.charAt(0));
    }
}


