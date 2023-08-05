import java.util.Arrays;

public class updateMileage {

    static void updateMileage_counter2(int[] a, int miles) {
        int sum = a[0] + miles;

        if(sum >= 10) {
            a[0] = sum % 10;
            for(int i=0; i < a.length - 1; i++) {
                a[i] = sum % 10;
                sum = (sum / 10) + a[i+1];

            }
            a[a.length - 1] = sum % 10;
        } else {
            a[0] += miles;
        }

        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int n = 13;		//return 06000

        updateMileage_counter2(arr,n);

    }
}
