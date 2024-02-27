package fppQuiz.CommonInterviewCode;

import java.util.ArrayList;
import java.util.List;

public class SMSMessages {
    public static String[] splitTextIntoSMS(String text, int limit) {
        List<String> messages = new ArrayList<>();

        int start = 0;
        int messageNumber = 1;
        int totalMessages = calculateTotalMessages(text, limit);

        System.out.println(totalMessages);

        while (start < text.length()) {
            int end = Math.min(start + (limit-5), text.length());
            String message = text.substring(start, end) + "<"
                    + messageNumber + "/" + totalMessages + ">";
            messages.add(message);
            start = end;
            messageNumber++;
        }

        System.out.println(messages);
        return messages.toArray(new String[0]);
    }

    public static int calculateTotalMessages(String text, int limit) {
        return (int) Math.ceil((double) text.length() / (limit-5));
    }

    public static void main(String[] args) {
        String text = "hello, world!";
        int limit = 10;

        String[] result = splitTextIntoSMS(text, limit);

        for (String message : result) {
            System.out.println(message);
        }
    }
}
