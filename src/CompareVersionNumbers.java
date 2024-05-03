public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "1.0", version2 = "1.0.0";

        System.out.println(compareVersion(version1,version2));
    }

    public static int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();

        for(int i=0, j=0; i<v1.length && j<v2.length; i++, j++) {
            if(v1[i] > v2[j]) {
                while (j<v2.length && v2[j] == 0) {
                    j++;
                }
                return 1;
            } else if(v1[i] < v2[j]) {
                return -1;
            }
        }

        return 0;
    }
}
