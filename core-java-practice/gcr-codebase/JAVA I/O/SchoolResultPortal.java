import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SchoolResultPortal {
    private static final String INPUT_FILE = "student-results.txt";
    private static final String OUTPUT_FILE = "report-card.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE, true))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.out.println("Skipping invalid record: " + line);
                    continue;
                }

                String name = parts[0].trim();
                int mark1 = Integer.parseInt(parts[1].trim());
                int mark2 = Integer.parseInt(parts[2].trim());
                int mark3 = Integer.parseInt(parts[3].trim());
                double average = (mark1 + mark2 + mark3) / 3.0;

                writer.println("Name: " + name);
                writer.println("Marks: " + mark1 + ", " + mark2 + ", " + mark3);
                writer.printf("Average: %.2f%n", average);
                writer.println("------------------------------");
            }

            System.out.println("Report card updated in " + OUTPUT_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + INPUT_FILE);
        } catch (IOException e) {
            System.out.println("Error while reading or writing file.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in input file.");
        }
    }
}
