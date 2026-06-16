import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        boolean res = (n % 5 == 0);
        System.out.println("Is the number " + n + " divisible by 5? " + res);
        sc.close();
    }
}
