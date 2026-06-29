import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DailyExpenseLogger {
    private static final String FILE_NAME = "expenses.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(FILE_NAME, true)) {

            System.out.print("How many expenses do you want to add? ");
            int count = Integer.parseInt(reader.readLine().trim());

            for (int i = 1; i <= count; i++) {
                System.out.print("Enter expense name " + i + ": ");
                String expenseName = reader.readLine().trim();

                System.out.print("Enter amount for " + expenseName + ": ");
                int amount = Integer.parseInt(reader.readLine().trim());

                writer.write(expenseName + " - " + amount + System.lineSeparator());
            }

            System.out.println("Expenses saved in " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error while saving expenses.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        }
    }
}
