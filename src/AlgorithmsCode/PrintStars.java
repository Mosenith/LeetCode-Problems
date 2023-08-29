package AlgorithmsCode;

public class PrintStars {
    public static void main(String[] args) {
        int n = 10;

        for(int i=0; i<n; i++) {
            for(int j=n-(i+1); j>0; j--) {
                System.out.print(" ");
            }

            int star = i + 1;
            while(star > 0) {
                System.out.print("* ");
                star--;
            }
            System.out.println();
        }
    }
}
