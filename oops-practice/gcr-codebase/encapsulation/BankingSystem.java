public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber("SB101");
        savingsAccount.setHolderName("Rahul");
        savingsAccount.setBalance(10000);
        savingsAccount.setInterestRate(4.5);
        savingsAccount.deposit(2000);
        savingsAccount.withdraw(1500);
        savingsAccount.displayAccountDetails();
        System.out.println("Interest: " + savingsAccount.calculateInterest());

        System.out.println();

        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber("CA201");
        currentAccount.setHolderName("Anita");
        currentAccount.setBalance(15000);
        currentAccount.setMonthlyBonusRate(2.0);
        currentAccount.deposit(3000);
        currentAccount.withdraw(1000);
        currentAccount.displayAccountDetails();
        System.out.println("Interest: " + currentAccount.calculateInterest());
    }
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double monthlyBonusRate;

    public double getMonthlyBonusRate() {
        return monthlyBonusRate;
    }

    public void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}
