import java.util.Scanner;

public class BMIWithArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ":");
            do {
                System.out.print("  Enter weight in kg: ");
                weight[i] = sc.nextDouble();
                if (weight[i] <= 0) {
                    System.out.println("  Please enter a positive weight.");
                }
            } while (weight[i] <= 0);

            do {
                System.out.print("  Enter height in meters: ");
                height[i] = sc.nextDouble();
                if (height[i] <= 0) {
                    System.out.println("  Please enter a positive height.");
                }
            } while (height[i] <= 0);

            bmi[i] = weight[i] / (height[i] * height[i]);
            status[i] = getBmiStatus(bmi[i]);
        }

        System.out.println("\nPerson  Height(m)  Weight(kg)  BMI      Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d       %.2f       %.2f       %.2f   %s%n",
                    i + 1, height[i], weight[i], bmi[i], status[i]);
        }
        sc.close();
    }

    private static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal weight";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
}
