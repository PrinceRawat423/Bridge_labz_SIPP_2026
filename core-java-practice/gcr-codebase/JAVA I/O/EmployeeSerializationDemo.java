import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class EmployeeSerializationDemo {
    private static final String FILE_NAME = "employee.ser";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter employee ID: ");
            int employeeId = Integer.parseInt(reader.readLine().trim());

            System.out.print("Enter name: ");
            String name = reader.readLine().trim();

            System.out.print("Enter department: ");
            String department = reader.readLine().trim();

            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(reader.readLine().trim());

            System.out.print("How many skill scores? ");
            int size = Integer.parseInt(reader.readLine().trim());
            int[] skillScores = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Enter skill score " + (i + 1) + ": ");
                skillScores[i] = Integer.parseInt(reader.readLine().trim());
            }

            Employee employee = new Employee(employeeId, name, department, salary, skillScores);
            saveEmployee(employee);

            Employee recovered = loadEmployee();
            if (recovered != null) {
                System.out.println("\nRecovered Employee Information");
                System.out.println(recovered);
            }
        } catch (IOException e) {
            System.out.println("Error while reading input.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        }
    }

    private static void saveEmployee(Employee employee) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employee);
            System.out.println("Employee saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error while saving employee.");
        }
    }

    private static Employee loadEmployee() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Employee) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading employee.");
            return null;
        }
    }

    private static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        private final int employeeId;
        private final String name;
        private final String department;
        private final double salary;
        private final int[] skillScores;

        private Employee(int employeeId, String name, String department, double salary, int[] skillScores) {
            this.employeeId = employeeId;
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.skillScores = skillScores;
        }

        @Override
        public String toString() {
            return "Employee ID: " + employeeId + System.lineSeparator()
                    + "Name: " + name + System.lineSeparator()
                    + "Department: " + department + System.lineSeparator()
                    + "Salary: " + salary + System.lineSeparator()
                    + "Skill Scores: " + Arrays.toString(skillScores);
        }
    }
}
