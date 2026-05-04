package com.amigoscode._2_developers._10_exceptions;

/**
 * Custom Exception Exercises
 *
 * Practice creating custom checked and unchecked exceptions, throwing them
 * from methods, catching them, and using exception chaining.
 */
public class CustomException {

    static class InsufficientFundsException extends Exception {
        private final double amount;

        public InsufficientFundsException(String message, double amount) {
            super(message);
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    static class InvalidAgeException extends RuntimeException {
        public InvalidAgeException(String message) {
            super(message);
        }
        public InvalidAgeException(String message, Throwable t) {
            super(message, t);
        }
    }

    static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount > balance) {
                throw new InsufficientFundsException("Unable to withdraw %f € from bank account, insufficient funds".formatted(amount), (amount - getBalance()));
            }
            balance -= amount;
        }
    }


    static void validateAge(int age) {
        if (age < 0 && age > 150) throw new InvalidAgeException("Age %d is invalid!".formatted(age));

        System.out.println("Age %d is valid".formatted(age));
    }


    public static void main(String[] args) {
        System.out.println("=== Custom Checked Exception (InsufficientFundsException) ===");

        BankAccount bankAccount = new BankAccount(100);

        try {
            bankAccount.withdraw(50);
            System.out.println(bankAccount.getBalance());
            bankAccount.withdraw(75);
            validateAge(25);
            validateAge(-5);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage() + " :: " + e.getAmount());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n=== Exception Chaining ===");
        try {
            try {
                Integer.parseInt("abc");
            } catch (NumberFormatException e) {
                throw new InvalidAgeException(e.getMessage(), e);
            }
        } catch (InvalidAgeException e) {
            System.out.println("Exception message: %s".formatted(e.getMessage()));
            System.out.println("Exception cause: %s".formatted(e.getCause()));
        }


    }
}
