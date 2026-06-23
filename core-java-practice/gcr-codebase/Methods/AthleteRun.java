import java.util.Scanner;

public class AthleteRun {

    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static double calculateRounds(double perimeter) {
        double distance = 5000; // 5 km = 5000 meters
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1 (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side 2 (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter side 3 (in meters): ");
        double side3 = sc.nextDouble();

        double perimeter = calculatePerimeter(side1, side2, side3);
        double rounds = calculateRounds(perimeter);

        System.out.println("Perimeter of the park = " + perimeter + " meters");
        System.out.println("Number of rounds required to complete 5 km = " + rounds);

        sc.close();
    }
}
