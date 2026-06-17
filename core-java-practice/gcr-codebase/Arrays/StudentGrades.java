import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        int[] physics = new int[number];
        int[] chemistry = new int[number];
        int[] maths = new int[number];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ":");
            physics[i] = readPositiveMark(sc, "  Physics mark: ");
            chemistry[i] = readPositiveMark(sc, "  Chemistry mark: ");
            maths[i] = readPositiveMark(sc, "  Maths mark: ");
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            grade[i] = getGrade(percentage[i]);
        }

        System.out.println("\nStudent  Physics  Chemistry  Maths  Percentage  Grade");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d        %d        %d          %d     %.2f       %s%n",
                    i + 1,
                    physics[i],
                    chemistry[i],
                    maths[i],
                    percentage[i],
                    grade[i]);
        }
        sc.close();
    }

    private static int readPositiveMark(Scanner sc, String prompt) {
        int mark;
        do {
            System.out.print(prompt);
            mark = sc.nextInt();
            if (mark < 0) {
                System.out.println("  Please enter a positive mark.");
            }
        } while (mark < 0);
        return mark;
    }

    private static String getGrade(double percentage) {
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        if (percentage >= 60) return "D";
        return "F";
    }
}
