import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        String s1 = "3[a2[c]]";  // "accaccacc"
        String s2 = "2[abc]3[cd]ef";    // "abcabccdcdcdef"
        String s3 = "3[a]2[bc]";    // "aaabcbc"
        String s4 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        System.out.println(decodeString(s2));
    }
    // 3[z]- 2[ 2[y]-pq- 4[2[jk]e1[f]]]ef
    // yypq -
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int count = 0;
        StringBuilder currentString = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
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
                currentString.append(ch);
            }
            System.out.println("*****************\n");
        }
        return currentString.toString();
    }

    // using recursion
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
                while(i<s.length() && s.charAt(i)<='9' && s.charAt(i)>='0'){
                    k*=10;
                    k+=s.charAt(i)-'0';
                    i++;
                }
                int cnt=0;
                int start=i+1;
                while(i<s.length()){
                    c=s.charAt(i);
                    if(c=='[') cnt++;
                    else if(c==']') cnt--;
                    if(cnt==0) break;
                    i++;
                }
                String str=helper(s,start,i-1);
                for(int j=0;j<k;j++){
                    sb.append(str);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
