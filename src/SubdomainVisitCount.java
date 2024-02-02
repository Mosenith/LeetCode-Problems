import java.util.ArrayList;
import java.util.List;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        String[] domains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        System.out.println(subdomainVisits(domains));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ls = new ArrayList<>();

        for(String s : cpdomains) {
            System.out.println("Curr => " + s);
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()) {
                if(c == ' ')
                    break;
                sb.append(c);
            }
            System.out.println(sb);
            System.out.println("*********\n");
        }
        return ls;
    }
}
