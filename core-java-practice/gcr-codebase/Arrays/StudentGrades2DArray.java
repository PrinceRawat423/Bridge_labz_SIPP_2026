import java.util.Scanner;

public class StudentGrades2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        int[][] marks = new int[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ":");
            marks[i][0] = readPositiveMark(sc, "  Physics mark: ");
            marks[i][1] = readPositiveMark(sc, "  Chemistry mark: ");
            marks[i][2] = readPositiveMark(sc, "  Maths mark: ");
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            grade[i] = getGrade(percentage[i]);
        }

        System.out.println("\nStudent  Physics  Chemistry  Maths  Percentage  Grade");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d        %d        %d          %d     %.2f       %s%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
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
