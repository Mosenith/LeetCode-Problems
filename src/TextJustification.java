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

    // ***************** 1st Method ******************
    // Approach 1: Add elements in words[] to queue while consider the #chars + #spaces <= maxWidth
    // String in queue is one line of ans that is needed to format with spaces
    // Runtime  : 2ms           -> + 46.38%
    // Memory   : 41.52MB       -> + 79.62%
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            int curLen = words[i].toCharArray().length;
            int nextIndex = i+1;
            Queue<String> queue = new ArrayDeque<>();
            queue.add(words[i]);
            while(nextIndex < words.length) {
                if(curLen + (queue.size()-1) + words[nextIndex].toCharArray().length >= maxWidth) {
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

                if(tmp.length() > maxWidth) {
                    ans.add(tmp.substring(0,tmp.length()-1));
                } else {
                    ans.add(tmp.toString());
                }
            } else {
                String txt = formatText(queue, maxWidth, curLen);
                ans.add(txt);
            }
        }
        return ans;
    }

    private static String formatText(Queue<String> queue, int maxWidth, int totalChar) {
        // calculate space and store in queue
        int totalSpaces = maxWidth - totalChar;
        Queue<Integer> space = new ArrayDeque<>();

        for(int i=0; i<queue.size()-1; i++) {
            int curSpace = (int) Math.ceil((double) totalSpaces / (queue.size()-1-i));
            if(totalSpaces < curSpace) {
                space.add(totalSpaces);
            } else {
                space.add(curSpace);
            }
            totalSpaces -= curSpace;
        }
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()) {
            str.append(queue.poll());
            int tmp = (!space.isEmpty() ? space.poll() : 0);
            for(int i=0; i<tmp; i++) {
                str.append(" ");
            }
        }
        return str.toString();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar approach as the 1st but more organised and optimized
    // Runtime  : 0ms           -> + 100.00%
    // Memory   : 41.60MB       -> + 66.62%
    public static List<String> fullJustify2(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (i < words.length) {
            int sum = 0;
            int prefixLength = 0;
            int j = i;
            while (j < words.length && sum + prefixLength + words[j].length() <= maxWidth) {
                sum += prefixLength + words[j].length();
                prefixLength = 1;
                j++;
            }
            var sb = new StringBuilder();
            if (j != words.length) {
                var numOfAdditionalSpaces = maxWidth - sum;
                var numOfGuaranteedSpaces = j > i + 1
                        ? numOfAdditionalSpaces / (j - i - 1) : 0;
                var spacesLeft = numOfAdditionalSpaces - numOfGuaranteedSpaces * (j - i - 1);

                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ".repeat(numOfGuaranteedSpaces + 1));
                    if (spacesLeft > 0) {
                        sb.append(" ");
                        spacesLeft--;
                    }
                    sb.append(words[k]);
                }

                sb.append(" ".repeat(spacesLeft));
            } else {
                sb.append(words[i]);
                for (int k = i + 1; k < words.length; k++)
                    sb.append(" ").append(words[k]);
                sb.append(" ".repeat(maxWidth - sum));
            }
            list.add(sb.toString());
            i = j;
        }

        return list;
    }
    //  ***************** End of 2nd Method ******************
}
