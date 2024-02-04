import java.util.*;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        String[] domains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        System.out.println(subdomainVisits(domains));
    }

    // ***************** 1st Method ******************
    // Approach 1: Split each string in the array by blank space or . -> String[] sb
    // sb[0] will be number, sb[sb.len-1] is top-level domain, sb[sb.len-2] is main domain
    // If sb.len = 4, there will be top-level domain & main domain to keep track of occurrence
    // If sb.len = 3, consider only the top-level domain like (com) & full address
    // Map those strings to sb[0] => map. Then get data from map to list<string>
    // Runtime  : 36ms        -> + 10.17%
    // Memory   : 46.11MB     -> + 6.00%
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ls = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for(String s : cpdomains) {
            String[] sb = s.split("\\s|\\.");

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
    //  ***************** End of 1st Method ******************

}
