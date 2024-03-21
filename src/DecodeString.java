public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";  // "accaccacc"

        System.out.println(decodeString(s));
    }
    // num,[,char,] -> 4*n-1
    // 8-1=7
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            StringBuilder tmp = new StringBuilder();
            char cur = s.charAt(i);
            int next = i+2;
            if(Character.isDigit(cur)) {
                System.out.println("cur = " + cur);
                // skip 1 to get char
                if(Character.isAlphabetic(s.charAt(next))) {
                    tmp.append(next++);
                } else {
                    tmp.append(decodeString(s.substring(next)));
                }
                System.out.println("repeat => " + Character.getNumericValue(cur));
                sb.append(String.valueOf(tmp).repeat(Math.max(0, Character.getNumericValue(cur))));
            }
            i += next-1;
            System.out.println(sb);
            System.out.println("********\n");
        }
        return sb.toString();
    }
}
