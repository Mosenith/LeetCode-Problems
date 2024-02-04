import java.util.*;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        String[] domains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        System.out.println(subdomainVisits(domains));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ls = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for(String s : cpdomains) {
            System.out.println("Curr => " + s);
            String[] sb = s.split("\\s|\\.");
            System.out.println(Arrays.toString(sb));

            StringBuilder tmp = new StringBuilder();
            for(int i=1; i<sb.length; i++) {
                if(i > 1) {
                    map.computeIfPresent(sb[i], (k,v) -> v + Integer.valueOf(sb[0]));
                    map.computeIfAbsent(sb[i], v -> Integer.valueOf(sb[0]));
                }
                tmp.append(sb[i] + ".");
            }

            System.out.println(tmp);
            System.out.println(map);
            System.out.println("*********\n");
        }
        return ls;
    }
}
