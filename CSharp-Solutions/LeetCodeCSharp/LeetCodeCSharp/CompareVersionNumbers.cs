namespace LeetCodeCSharp;

public class CompareVersionNumbers {
    public static int CompareVersion(string version1, string version2) {
        int l1 = version1.Length;
        int l2 = version2.Length;

        for (int i = 0, j = 0; i < l1 || j < l2; i++, j++) {
            int a = 0, b = 0;
            while (i < l1 && version1[i] != '.') {
                a = a * 10 + (version1[i++] - '0');
            }

            while (j < l2 && version2[j] != '.') {
                b = b * 10 + (version2[j++] - '0');
            }

            if (a != b) {
                return a > b ? 1 : -1;
            }
        }

        return 0;
    }
}