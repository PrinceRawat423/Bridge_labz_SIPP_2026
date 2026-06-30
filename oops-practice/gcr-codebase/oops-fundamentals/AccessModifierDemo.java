public class AccessModifierDemo {
    public static void main(String[] args) {
        Student student = new Student("Aman", 19, 89.5);
        student.displayInfo();

        BankAccount account = new BankAccount("Aman", 5000);
        account.deposit(1500);
        account.withdraw(2000);
        System.out.println("Balance: " + account.getBalance());
    }
}

class Student {
    public String name;
    protected int age;
    double percentage;
    private String grade;

    Student(String name, int age, double percentage) {
        this.name = name;
        this.age = age;
        this.percentage = percentage;
        this.grade = calculateGrade();
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
    }

    private String calculateGrade() {
        if (percentage >= 90) return "A";
        if (percentage >= 75) return "B";
        if (percentage >= 60) return "C";
        return "D";
    }
}

class BankAccount {
    public String owner;
    protected double balance;
    double interestRate;
    private String pin = "1234";

    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.interestRate = 4.5;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited.");
        }
    }

    protected void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn.");
        }
    }

    double calculateInterest() {
        return balance * interestRate / 100;
    }

    private String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }
}
