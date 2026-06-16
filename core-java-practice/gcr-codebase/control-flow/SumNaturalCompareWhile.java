import java.util.Scanner;

public class SumNaturalCompareWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            long formula = (long) n * (n + 1) / 2;
            long sum = 0;
            int i = 1;
            while (i <= n) {
                sum += i;
                i++;
            }
            System.out.println("Formula = " + formula + ", While-sum = " + sum + ", equal? " + (formula == sum));
        }
        sc.close();
    }
}
