import java.util.Scanner;

public class SimpleIntrest {
    public static double simpleIntrest(double principle, double rate, double time) {
        return (principle * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principle: ");
        double principle = sc.nextDouble();

        System.out.print("Enter rate: ");
        double rate = sc.nextDouble();

        System.out.print("Enter time: ");
        double time = sc.nextDouble();

        double si = simpleIntrest(principle, rate, time);

        System.out.println(
            "The simple interest is " + si +
            " for principle " + principle +
            ", interest rate is " + rate +
            ", for time " + time
        );

        sc.close();
    }
}
