package AlgorithmsCode;

public class PatternSearchingNaiveAlgorithm {
//    Time Complexity: O(N2)
//    Auxiliary Space: O(1)
    static void search(String pat, String txt) {
        int patLen = pat.length();
        int txtLen = txt.length();
        int patIndex = 0, txtIndex = 0;

        for(; txtIndex < txtLen;) {
            if(txt.charAt(txtIndex) == pat.charAt(patIndex)) {
                txtIndex++;
                patIndex++;
            } else {
                txtIndex -= patIndex - 1;
                patIndex = 0;
            }

            if(patIndex == patLen) {
                System.out.println("Pattern found at index " + (txtIndex-patIndex));
                patIndex = 0;
            }
        }

    }

    // Driver's code
    public static void main(String args[])
    {
        String pat = "AABA";
        String txt = "AABAACAADAABAAABAA";
        // Function call
        search(pat, txt);
    }
}
