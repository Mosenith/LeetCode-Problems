import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
//        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] c = {'a','a','b','b','c','c','c'};
        StringCompression sc = new StringCompression();

        System.out.println(sc.compress(c));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use 2 Pointers & reset chars[] by using index from 0
    // In loop, find repeated char by checking chars[i] == chars[j]
    // Reset chars[index++] = chars[i] and getNum by String.valueOf(j-i)
    // Convert to charArray and add to chars[index++], then set i = j
    // Runtime  : 1ms         -> + 99.48%
    // Memory   : 44.28MB     -> + 19.41%
    public int compress(char[] chars) {
        int len = chars.length;
        int index = 0;

        for(int i=0,j=i+1; i<len;) {
            while(j<len && chars[i] == chars[j]) {
                j++;
            }
            chars[index++] = chars[i];  // redefine chars

            // has repeated chars
            if(j-i>1) {
                String cnt = String.valueOf(j-i); // convert to string & use charArray
                for(char c : cnt.toCharArray()) {   // if 12 => ['1','2']
                    chars[index++] = c;
                }
            }
            i = j; // continue from the non-repeated index
        }
        return index;
    }
    //  ***************** End of 1st Method ******************

}
