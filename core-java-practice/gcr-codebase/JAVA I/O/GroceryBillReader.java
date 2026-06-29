import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    private static final String FILE_NAME = "bill.txt";

    public static void main(String[] args) {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            System.out.println("Total lines = " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("Bill file not found: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error reading bill file.");
        }
    }
}
