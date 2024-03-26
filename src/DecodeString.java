import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        String s1 = "3[a2[c]]";  // "accaccacc"
        String s2 = "2[abc]3[cd]ef";    // "abcabccdcdcdef"
        String s3 = "3[a]2[bc]";    // "aaabcbc"
        String s4 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        System.out.println(decodeString2(s1));
    }

    // ***************** 1st Method ******************
    // Approach : Use 2 stack, one for counting the repeated times, when encounters ']' add count to countStack
    // Another one for storing already cal chars, when encounters '[' add currentString & reset currentString and count
    // When encounter ']', pop from stringStack and append to currentString with countStack.pop() times
    // Otherwise, append ch to currentString
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.35 MB   -> + 69.14%
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int count = 0;
        StringBuilder currentString = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // get number of repeated times
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // without repeated time
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Using recursion start from 0 to s.len-1
    // Check if numeric, get numeric and using loop to iterate until we get to ']'
    // Then call recursion from prevI to i-1 => we'll get the inner char btw []
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.02MB     -> + 94.62%
    // 3[a2[c]]
    public static String decodeString2(String s) {
        return helper(s,0,s.length()-1);
    }
    private static String helper(String s, int l , int r){
        if(l>r) return "";
        StringBuilder sb=new StringBuilder();
        for(int i=l;i<=r;i++){
            char c=s.charAt(i);
            if(c>='0' && c<='9'){
                int k=0;
                // this is necessary when numeric >=10
                while(i<s.length() && s.charAt(i)<='9' && s.charAt(i)>='0'){
                    k*=10;
                    k+=s.charAt(i)-'0';
                    i++;
                }
                int cnt=0;
                int start=i+1;
                while(i<s.length()){
                    c=s.charAt(i);
                    if(c=='[') cnt++;   // make sure we get until the inner of '['
                    else if(c==']') cnt--;
                    if(cnt==0) break;
                    i++;
                }
                String str=helper(s,start,i-1); // then we get the char between inner of []
                sb.append(str.repeat(Math.max(0, k))); // repeat it k times
            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    //  ***************** End of 2nd Method ******************
}
