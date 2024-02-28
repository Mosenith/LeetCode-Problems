import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TextJustification {
    public static void main(String[] args) {
//        String[] words = {"Science","is","what","we","understand","well","enough","to",
//                "explain","to","a","computer.","Art","is","everything","else","we","do"};
//        int maxWidth = 20;

        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what",
                "you","can","do","for","your","country"};
        int maxWidth = 16;

        System.out.println(fullJustify(words, maxWidth));
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            int curLen = words[i].toCharArray().length;
            int nextIndex = i+1;
            Queue<String> queue = new ArrayDeque<>();
            queue.add(words[i]);
            while(nextIndex < words.length) {
                if(curLen + (queue.size()-1) + words[nextIndex].toCharArray().length >= maxWidth) {
                    System.out.println("break at nextIndex = " + nextIndex);
                    break;
                }
                curLen += words[nextIndex].toCharArray().length;
                queue.add(words[nextIndex]);
                nextIndex++;
            }

            i = nextIndex-1;
            // last line => left-justified
            if(i == words.length-1 || queue.size() == 1) {
                StringBuilder tmp = new StringBuilder();
                while(!queue.isEmpty()) {
                    tmp.append(queue.poll() + " ");
                }

                while(tmp.length() < maxWidth) {
                    tmp.append(" ");
                }
                ans.add(tmp.toString());
            } else {
                String txt = formatText(queue, maxWidth, curLen);
                ans.add(txt);
            }

            System.out.println(queue);
            System.out.println("cur i = " + i + " with curlen = " + curLen);
            System.out.println("*************\n");
        }

        return ans;
    }

    private static String formatText(Queue<String> queue, int maxWidth, int totalChar) {
        System.out.println("==== Sub Method =====");

        // calculate space and store in queue
        int totalSpaces = maxWidth - totalChar;
        int curSpace = (int) Math.ceil((double) totalSpaces / (queue.size()-1));
        Queue<Integer> space = new ArrayDeque<>();

        System.out.println(totalSpaces + " : " + curSpace);
        for(int i=0; i<queue.size()-1; i++) {
            if(totalSpaces < curSpace) {
                space.add(totalSpaces);
            } else {
                space.add(curSpace);
            }
            totalSpaces -= curSpace;
        }
        System.out.println("space ==> "+space);
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()) {
            str.append(queue.poll());
            int tmp = (!space.isEmpty() ? space.poll() : 0);
            for(int i=0; i<tmp; i++) {
                str.append(" ");
            }
        }

        System.out.println(str);
        return str.toString();
    }
}
