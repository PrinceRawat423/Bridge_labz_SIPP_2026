import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        int goodCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter feedback " + i + ": ");
                String feedback = reader.readLine();

                if (feedback != null && feedback.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }

            System.out.println("Good Feedback Count = " + goodCount);
        } catch (IOException e) {
            System.out.println("Error reading feedback.");
        }
    }
}
