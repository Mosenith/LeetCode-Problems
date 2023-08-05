import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // ***************** 1st Method ******************
    // Worked but Takes too long
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++) {
            List<String> inner = new ArrayList<>();
            String curKey = strs[i];

            System.out.println("curKey : " + curKey);

            if(checkMap(map, curKey)) {
                System.out.println("Check True!");
                continue;
            }

            inner.add(curKey);
            for(int j=i+1; j<strs.length; j++) {
                if(curKey.length() == strs[j].length() && isAnagrams(curKey,strs[j])) {
                    inner.add(strs[j]);
                }
            }

            map.put(curKey, inner);
//            System.out.println("current key : " + map.keySet());
//            System.out.println("current value : " + map.values());
            System.out.println("current map : " + map);
            System.out.println("*******************************************");
        }

        return new ArrayList<>(map.values());
    }

    private static boolean checkMap(HashMap<String, List<String>> map, String curKey) {
        System.out.println("+++++++++++++++");
        for(Map.Entry<String, List<String>> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            if(e.getValue().contains(curKey)) {
                System.out.println("+++++++ " + e.getKey().contains(curKey) + " ++++++++");
                return true;
            }
        }
        System.out.println("+++++++++++++++");
        return false;
    }

    private static boolean isAnagrams(String mainStr, String compStr) {
        List<Character> splitStr = mainStr.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        for(int i=0; i<compStr.length(); i++) {
            Character curChar = compStr.charAt(i);
            if(!splitStr.contains(curChar)) {
                return false;
            }
            splitStr.remove(curChar);
        }
        return splitStr.size() == 0;
    }

    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 7ms        -> + 79.19%
    // Memory   : 45.8MB      -> + 48.37%
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String currentString : strs) {
            System.out.println("Main String : " + currentString);
            char[] arrayCurString = currentString.toCharArray();
            Arrays.sort(arrayCurString);
            String sortCurString = String.valueOf(arrayCurString);

            System.out.println(Arrays.toString(arrayCurString));
            System.out.println(sortCurString);

            map.computeIfAbsent(sortCurString, key -> new ArrayList<>()).add(currentString);
            System.out.println(map.entrySet());
            System.out.println("*******************************************");
        }
        return new ArrayList<>(map.values());
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Runtime  : 6ms        -> + 98.9%
    // Memory   : 45.8MB      -> + 48.37%
    public static List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
            System.out.println(map.entrySet());
            System.out.println("*******************************************");
        }
        return new ArrayList<>(map.values());
    }
    //  ***************** End of 3rd Method ******************


    public static void main(String[] args) {
        // out : [["bat"],["nat","tan"],["ate","eat","tea"]]
        String[] strs = {"eat","tea","tan","ate","nat","bat", "tea"};

        // out : [[eat, tea], [but, tub], [its, sit], [era]]
//        String[] strs = {"eat", "but", "its","era", "tub", "sit", "tea"};

        // out : [[ddddddddddg], [dgggggggggg]]
//        String[] strs = {"ddddddddddg","dgggggggggg"};

        // out : [["b"],["",""]]
//        String[] strs = {"","b",""};

//        String[] strs = {"ac","c"};

//        List<String> myList = checkContainAlpha(strs, 2, getAplhabet(strs[2]));
//        System.out.println(myList);

        System.out.println("Final : " + groupAnagrams3(strs));
//        System.out.println("final size : " + groupAnagrams(strs).size());

//        System.out.println(isAnagrams("",""));
    }
}
