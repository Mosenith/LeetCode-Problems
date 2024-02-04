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
            if(sb.length == 4) {
                map.computeIfPresent(sb[3], (k,v) -> v + Integer.valueOf(sb[0]));
                map.computeIfAbsent(sb[3], v -> Integer.valueOf(sb[0]));

                map.computeIfPresent(sb[2] + "." + sb[3], (k,v) -> v + Integer.valueOf(sb[0]));
                map.computeIfAbsent(sb[2] + "." + sb[3], v -> Integer.valueOf(sb[0]));

                map.computeIfPresent(sb[1] + "." + sb[2] + "." + sb[3], (k,v) -> v + Integer.valueOf(sb[0]));
                map.computeIfAbsent(sb[1] + "." + sb[2] + "." + sb[3], v -> Integer.valueOf(sb[0]));
            } else {
                // last element: i.e com
                map.computeIfPresent(sb[2], (k,v) -> v + Integer.valueOf(sb[0]));
                map.computeIfAbsent(sb[2], v -> Integer.valueOf(sb[0]));

                // all combine
                map.computeIfPresent(sb[1] + "." + sb[2], (k,v) -> v + Integer.valueOf(sb[0]));
                map.computeIfAbsent(sb[1] + "." + sb[2], v -> Integer.valueOf(sb[0]));
            }

            System.out.println(map);
            System.out.println("*********\n");
        }


        // Iterate over the entries of the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // Concatenate key and value into a string
            String combined = entry.getValue() + " " + entry.getKey();

            // Add the combined string to the list
            ls.add(combined);
        }


        return ls;
    }
}
