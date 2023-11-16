import java.util.Arrays;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        String[] output = new String[numRows];
        int count = 0; // < numRows

        for(int i=0; i<numRows; i++){
            output[i] = "";
        }

        for(int i=0; i<s.length(); i++){
            output [count] += String.valueOf(s.charAt(i));
            count++;    // 0 -> numRows-1

            // middle case
            if(count == numRows && numRows > 2){
                count = 0;
                int num = numRows/2;
                for(;num>0; num--){
                    i++;
                    output [num] += String.valueOf(s.charAt(i));
                }
                //i = i + (numRows/2);
            } else if(count == numRows){
                count = 0;
            };
        }

        String str = String.join("",output);
        //System.out.println(str);
        //return Arrays.toString(output);
        return str;
    }
    public static String convert2(String s, int numRows){
        String[] output = new String[numRows];
        //StringBuilder ouput = new StringBuilder();

        if(numRows <= 1 || numRows >= s.length())
            return s;

        // i tracks s, j tracks output[]
        for(int i=0, j=0; i<s.length(); i++){
            System.out.println("i = " + i + ", j = " + j);
            if(output [j] == null){
                output [j] = "";
            }

            if(j==(numRows-1)){
                // work from down to upper
                output [j] = output[j].concat(String.valueOf(s.charAt(i)));
                j--;
                while(j!=0){
                    i++;
                    if(i >= s.length()) {
                        break;
                    }
                    output [j] = output[j].concat(String.valueOf(s.charAt(i)));
                    j--;
                }

            } else{
                output [j] = output[j].concat(String.valueOf(s.charAt(i)));
                j++;
            }

            System.out.println(Arrays.toString(output));
            System.out.println("******");
        }

        String str = String.join("",output);
        return str;
    }

    public static String convert3(String s, int numRows){
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int group = 2 * numRows - 2;
        for (int i = 1; i <= numRows; i++) {
            int interval = i == numRows ? group : 2 * numRows - 2 * i;
            int idx = i - 1;
            System.out.println("interval: " + interval + "; idx: " + idx);
            while (idx < s.length()) {
                ans.append(s.charAt(idx));
                idx += interval;
                interval = group - interval;
                System.out.print(interval + " ;; " + idx);
                //System.out.println("; Group: " + group);
                if (interval == 0) {
                    interval = group;
                }
            }
            System.out.println("****************************");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;

        //System.out.println(convert2("ABCDE",4));
        //System.out.println(convert2(s,numRows));
        //System.out.println(s.length());
        System.out.println(convert2(s,numRows));
        System.out.println(convert4(s,numRows));


    }

    // ***************** 1st Method ******************
    // Approach 4: Calculate step = 2 * numRows - 2;
    // at first row (i=0) & last row (i=numRows-1), every char at i & i+step
    // in middle row, s1 = 2 * (numRows - 1 - i), s2 = step - s1
    // downward => copyI += s1, upward => copyI += s2;
    // Runtime  : 2ms           -> + 99.74%
    // Memory   : 44.40 MB      -> + 33.89%
    public static String convert4(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder stringBuilder = new StringBuilder();
        int step = 2 * numRows - 2;

        for(int i=0; i<numRows; i++) {
            if(i == 0 || i == numRows-1) {
                int start = i;
                while(start < s.length()) {
                    stringBuilder.append(s.charAt(start));
                    start += step;
                }
            } else {
                boolean downward = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                int start = i;

                while(start < s.length()) {
                    stringBuilder.append(s.charAt(start));
                    if(downward) {
                        start += step1;
                    } else {
                        start += step2;
                    }
                    downward = !downward;
                }
            }
        }

        return stringBuilder.toString();
    }
}
