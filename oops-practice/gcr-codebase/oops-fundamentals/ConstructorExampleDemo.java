public class ConstructorExampleDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Shreya", 28, "Developer");
        Employee employee2 = new Employee("Amit", 32);

        employee1.displayEmployeeDetails();
        employee2.displayEmployeeDetails();
    }
}

class Employee {
    String name;
    int age;
    String role;

    Employee(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    Employee(String name, int age) {
        this(name, age, "Trainee");
    }

    void displayEmployeeDetails() {
        System.out.println("Name: " + name + ", Age: " + age + ", Role: " + role);
    }
}
