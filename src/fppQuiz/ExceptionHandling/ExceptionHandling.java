package fppQuiz.ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {
    // testException(2) will throw FileNotFoundException so testException(-3) will not be executed
    // finally block will always be executed even Exceptions are thrown
    //
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            testException(-2);
            testException(-3); // never get executed
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Releasing resources");
        }

        testException(11);
    }

    // i < 0 => FileNotFoundException will be thrown
    // i > 10 => IOException will be thrown
    // Otherwise, ok
    public static void testException(int i) throws FileNotFoundException, IOException {
        if (i < 0) {
            FileNotFoundException myException = new FileNotFoundException("Negative Integer " + i);
            throw myException;
        } else if (i > 10) {
            throw new IOException("Only supported for index 0 to 10");
        }
    }
}
