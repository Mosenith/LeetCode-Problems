import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReformatDate {
    public static void main(String[] args) {
        String date = "26th May 1960";  // "2052-10-20"

//        System.out.println(date.substring());
        System.out.println(reformatDate2(date));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use StringBuilder to store date, month, year
    // if date.len == 1, add 0 in the front
    // Use map to store month (Jan 01 - Dec 12), map key to value
    // Before return ans, add '-' in the between
    // Runtime  : 1ms            -> + 94.94%
    // Memory   : 40.74MB        -> + 59.52%
    public static String reformatDate(String date) {
        Map<String, String> month = new HashMap<>();
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");

        StringBuilder dateForm = new StringBuilder();
        StringBuilder monthForm = new StringBuilder();
        StringBuilder yearForm = new StringBuilder();

        StringBuilder ans = new StringBuilder();
        int index = 0;

        while(date.charAt(index) != ' ' && !Character.isLetter(date.charAt(index))) {
            dateForm.append(date.charAt(index++));
        }

        if(dateForm.length() == 1) {
            StringBuilder tmp = dateForm;
            dateForm = new StringBuilder("0");
            dateForm.append(tmp);
        }

        index += 3;
        monthForm.append(month.get(date.substring(index, index+3)));
        index += 3;
        yearForm.append(date.substring(index+1, date.length()));

        ans.append(yearForm + "-").append(monthForm + "-").append(dateForm);
        return ans.toString();
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Split given string upon encounter ' ' => var
    // Date -> substring(s[0], s[0].len-2) cos date is either len 3 or 4
    // All months are stored in a string begin with space at 0 and proceed with all months
    // s[1] will return 3 chars month & /3 will give a corresponding position in the list
    // Adjusts it to a 1-based month value (+1) i.e. Jan 1, Feb 2, Mar 3
    // Runtime  : 1ms            -> + 94.94%
    // Memory   : 40.74MB        -> + 59.52%
    public static String reformatDate2(String date) {
        var s = date.split(" ");

        System.out.println(Arrays.toString(s));

        String months = " JanFebMarAprMayJunJulAugSepOctNovDec";
        int day = Integer.parseInt(s[0].substring(0, s[0].length() - 2));

        System.out.println(months.indexOf(s[1])/3 + 1);

        int month = months.indexOf(s[1]) / 3 + 1;
        return String.format("%s-%02d-%02d", s[2], month, day);
    }
    // ***************** End of 2nd Method ******************

}
