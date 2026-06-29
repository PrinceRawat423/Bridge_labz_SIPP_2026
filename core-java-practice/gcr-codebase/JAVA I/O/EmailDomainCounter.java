import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class EmailDomainCounter {
    private static final String FILE_NAME = "emails.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            ArrayList<String> emails = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    emails.add(line.trim());
                }
            }

            String[] domains = new String[emails.size()];
            for (int i = 0; i < emails.size(); i++) {
                String email = emails.get(i);
                int atIndex = email.lastIndexOf('@');
                domains[i] = atIndex >= 0 ? email.substring(atIndex + 1).toLowerCase() : "invalid";
            }

            Map<String, Integer> counts = new LinkedHashMap<>();
            for (String domain : domains) {
                counts.put(domain, counts.getOrDefault(domain, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Email file not found: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error reading email file.");
        }
    }
}
