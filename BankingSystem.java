import java.util.Scanner;

// Abstract class representing a generic Bank Account.
abstract class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters and Setters (Encapsulation)
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Abstract method for specific account operations
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}

// Inheritance: SavingAccount extends BankAccount
class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(String accountHolderName, String accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    // Polymorphism: Overriding deposit method
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Polymorphism: Overriding withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal.");
        }
    }
}

// Inheritance: CurrentAccount extends BankAccount
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountHolderName, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Polymorphism: Overriding deposit method
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Polymorphism: Overriding withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit >= amount)) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Exceeds overdraft limit or invalid amount.");
        }
    }
}

// Main class to demonstrate the program
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a Saving Account
        System.out.println("Enter details for Saving Account:");
        System.out.print("Account Holder Name: ");
        String savingName = scanner.nextLine();
        System.out.print("Account Number: ");
        String savingAccountNumber = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double savingBalance = scanner.nextDouble();
        System.out.print("Interest Rate: ");
        double interestRate = scanner.nextDouble();
        SavingAccount savingAccount = new SavingAccount(savingName, savingAccountNumber, savingBalance, interestRate);

        System.out.println("\nSaving Account Holder: " + savingAccount.getAccountHolderName());
        System.out.print("Enter amount to deposit: ");
        double savingDeposit = scanner.nextDouble();
        savingAccount.deposit(savingDeposit);

        System.out.print("Enter amount to withdraw: ");
        double savingWithdraw = scanner.nextDouble();
        savingAccount.withdraw(savingWithdraw);
        System.out.println("Balance after interest: " + (savingAccount.getBalance() + savingAccount.calculateInterest()));

        System.out.println("---------------------------");

        // Creating a Current Account
        scanner.nextLine(); // Consume leftover newline
        System.out.println("Enter details for Current Account:");
        System.out.print("Account Holder Name: ");
        String currentName = scanner.nextLine();
        System.out.print("Account Number: ");
        String currentAccountNumber = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double currentBalance = scanner.nextDouble();
        System.out.print("Overdraft Limit: ");
        double overdraftLimit = scanner.nextDouble();
        CurrentAccount currentAccount = new CurrentAccount(currentName, currentAccountNumber, currentBalance, overdraftLimit);

        System.out.println("\nCurrent Account Holder: " + currentAccount.getAccountHolderName());
        System.out.print("Enter amount to deposit: ");
        double currentDeposit = scanner.nextDouble();
        currentAccount.deposit(currentDeposit);

        System.out.print("Enter amount to withdraw: ");
        double currentWithdraw = scanner.nextDouble();
        currentAccount.withdraw(currentWithdraw);

        System.out.println("Final Balance in Current Account: " + currentAccount.getBalance());
    }
}
