import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProductInventoryChecker {
    private static final String FILE_NAME = "inventory.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("-");
                if (parts.length < 2) {
                    continue;
                }

                String product = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());

                if (quantity == 0) {
                    System.out.println(product + " is out of stock");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error reading inventory file.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity in inventory file.");
        }
    }
}
