import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
//        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] c = {'a','a','b','b','c','c','c'};
        StringCompression sc = new StringCompression();

        System.out.println(sc.compress(c));
    }

    public int compress(char[] chars) {
        int countDigits = 0;

        for(int i=0; i<chars.length;) {
            char curChar = chars[i];
            int next = i+1, count = 1;

            System.out.println("curChar ==> " + curChar + " at i = " + i);
            while(next < chars.length && chars[next] == curChar) {
                count++;
                next++;
            }

            System.out.println("# of count = " + count);
            int startIndex = i+1;
            i += count;
            if(count == 1) continue;
            System.out.println("startIndex = " + startIndex);
            while(count >= 10) {
                chars[startIndex++] = (char) ((count / 10) + '0');
                count /= 10;
            }
            countDigits = startIndex;
            chars[startIndex] = (char) (count + '0');
            System.out.println("***********");
        }

        System.out.println(countDigits);

        char[] copy = Arrays.copyOf(chars,countDigits+1);
        chars = Arrays.copyOf(copy,copy.length);
        System.out.println(Arrays.toString(chars));

        return countDigits+1;
    }
}
