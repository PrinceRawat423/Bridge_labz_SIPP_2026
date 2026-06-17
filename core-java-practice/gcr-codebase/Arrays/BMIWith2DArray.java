import java.util.Scanner;

public class BMIWith2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ":");
            double weight;
            double height;
            do {
                System.out.print("  Enter weight in kg: ");
                weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.println("  Please enter a positive weight.");
                }
            } while (weight <= 0);

            do {
                System.out.print("  Enter height in meters: ");
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("  Please enter a positive height.");
                }
            } while (height <= 0);

            double bmi = weight / (height * height);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;
            weightStatus[i] = getWeightStatus(bmi);
        }

        System.out.println("\nPerson  Weight(kg)  Height(m)  BMI      Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d       %.2f        %.2f      %.2f   %s%n",
                    i + 1,
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    weightStatus[i]);
        }
        sc.close();
    }

    private static String getWeightStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal weight";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
}
