import java.util.Scanner;

public class SumNaturalCompareFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            long formula = (long) n * (n + 1) / 2;
            long sum = 0;
            for (int i = 1; i <= n; i++) sum += i;
            System.out.println("Formula = " + formula + ", For-sum = " + sum + ", equal? " + (formula == sum));
        }
        sc.close();
    }
}
