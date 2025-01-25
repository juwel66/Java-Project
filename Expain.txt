The program is structured to demonstrate object-oriented programming (OOP) principles such as inheritance, polymorphism, encapsulation, and abstraction. Here's a breakdown:

1. BankAccount Class (Abstract Base Class):
Represents the base class for all account types.
Encapsulates common account details: accountHolderName, accountNumber, and balance.
Uses getters and setters to provide access to these private fields.
Declares two abstract methods: deposit() and withdraw() to be implemented by subclasses.
2. SavingAccount Class (Subclass):
Extends BankAccount and adds interestRate as a unique property.
Implements the deposit() and withdraw() methods with specific behavior for a savings account.
Includes a method calculateInterest() to compute interest based on the balance and interest rate.
3. CurrentAccount Class (Subclass):
Extends BankAccount and adds overdraftLimit as a unique property.
Implements deposit() and withdraw() methods, allowing withdrawals that exceed the balance up to the overdraft limit.
4. Main Class (BankingSystem):
Prompts the user to enter details for both a Savings Account and a Current Account.
Allows deposits and withdrawals for both accounts.
Displays the final balance and (for savings) includes interest calculation.
Key Enhancements:
Input and Output:

Users are prompted to input their account details (name, account number, initial balance, etc.).
After transactions, the updated balance is displayed for both account types.
Balance Printing:

For both Savings and Current accounts, the final balance is printed after transactions.
In the case of the savings account, the balance includes interest earned.
Overdraft Management:

In the CurrentAccount class, withdrawals are allowed up to the overdraft limit, demonstrating account-specific logic.
Error Handling:

Invalid deposit or withdrawal amounts (e.g., negative values) are rejected with appropriate messages.
