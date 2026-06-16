import java.util.Scanner;

public class SumUntilNonPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double v = sc.nextDouble();
            if (v <= 0.0) break;
            total += v;
        }
        System.out.println("Total = " + total);
        sc.close();
    }
}
