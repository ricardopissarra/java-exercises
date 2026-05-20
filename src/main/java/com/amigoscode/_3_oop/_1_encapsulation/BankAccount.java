package com.amigoscode._3_oop._1_encapsulation;

/**
 * Exercise: Encapsulation with BankAccount
 *
 * Learn how to protect data using private fields, provide controlled access
 * through getters, and enforce business rules in methods.
 *
 * Key concepts:
 * - Private fields to hide internal state
 * - Public methods to provide controlled access
 * - Validation logic inside setters/methods
 * - Private helper methods
 */
public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }


    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
        logTransaction("%s deposited %.2f€ into the account %s".formatted(
                this.ownerName, amount, this.accountNumber
        ));
        return this.balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        this.balance -= amount;

        logTransaction("%s withdraw %.2f€ from the account %s".formatted(
                this.ownerName, amount, this.accountNumber
        ));
        return this.balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

    private void logTransaction(String message) {
        System.out.println("[Transaction Log] %s".formatted(message));
    }


    public static void main(String[] args) {
         // Uncomment and test after completing the TODOs:
         BankAccount account = new BankAccount("ACC-001", "Alice", 1000.0);
         System.out.println(account);
         System.out.println("Balance: " + account.getBalance());

         account.deposit(500.0);
         System.out.println("After deposit: " + account.getBalance());

         account.withdraw(200.0);
         System.out.println("After withdrawal: " + account.getBalance());

         // These should throw exceptions:
//          account.deposit(-100);
//          account.withdraw(999999);
    }
}
