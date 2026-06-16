import java.util.Scanner;

public class NumbersAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }
        for (int v : a) {
            if (v > 0) {
                System.out.print(v + " is positive and ");
                System.out.println((v % 2 == 0) ? "even" : "odd");
            } else if (v < 0) System.out.println(v + " is negative");
            else System.out.println(v + " is zero");
        }
        int first = a[0], last = a[a.length - 1];
        if (first == last) System.out.println("First and last elements are equal");
        else if (first > last) System.out.println("First element is greater than last element");
        else System.out.println("First element is less than last element");
        sc.close();
    }
}
