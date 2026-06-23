import java.util.Scanner;

public class PowerRecursion {

    static long power(long x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x and n: ");
        long x = sc.nextLong();
        int n = sc.nextInt();
        System.out.println(power(x, n));
        sc.close();
    }
}
