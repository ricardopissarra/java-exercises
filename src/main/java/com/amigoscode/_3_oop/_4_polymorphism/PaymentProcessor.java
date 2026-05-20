package com.amigoscode._3_oop._4_polymorphism;

import java.util.List;

/**
 * Exercise: Polymorphism - Payment Processing
 *
 * Build a payment processing system using interfaces and polymorphism.
 * Multiple payment methods implement the same interface, allowing
 * the processor to handle any payment type without knowing the details.
 *
 * Key concepts:
 * - Defining interfaces
 * - Multiple classes implementing the same interface
 * - Runtime polymorphism (method dispatch)
 * - Programming to an interface, not an implementation
 * - Default methods in interfaces
 */

interface Payment {
    boolean processPayment(double amount);
    String getPaymentMethod();

    default void printReceipt(double amount) {
        System.out.println("Receipt: $%f paid via %s".formatted(amount, getPaymentMethod()));
    }
}

class CreditCardPayment implements Payment {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of $%.2f with card %s".formatted(amount, cardNumber));
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

class PayPalPayment implements Payment {

    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $%.2f from email %s".formatted(amount, email));
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}

class BankAccountPayment implements Payment {

    private String bankAccountId;

    public BankAccountPayment(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing bank transfer of $%.2f from account %s".formatted(amount, bankAccountId));
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}

public class PaymentProcessor {

    public void processAllPayments(List<Payment> payments, double amount) {
        payments.stream()
                .forEach(p -> {
                    p.processPayment(amount);
                    p.printReceipt(amount);
                });
    }
}



class PaymentDemo {
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment("123A");
        Payment payPal = new PayPalPayment("user@email.com");
        Payment bankTransfer = new BankAccountPayment("ABC176987");
        List<Payment> paymentList = List.of(creditCard, payPal, bankTransfer);
        new PaymentProcessor()
                .processAllPayments(paymentList, 10);

        // Demonstrate runtime polymorphism:
         Payment payment = new CreditCardPayment("1234-5678");
         payment.processPayment(100.0);
         payment = new PayPalPayment("user@email.com");
         payment.processPayment(200.0);
         payment = new BankAccountPayment("132DSAD312");
         payment.processPayment(50.0);

    }
}
