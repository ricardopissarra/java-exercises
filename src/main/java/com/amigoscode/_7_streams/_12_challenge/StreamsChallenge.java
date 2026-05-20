package com.amigoscode._7_streams._12_challenge;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Exercise: Streams Challenge
 *
 * Put everything together! This challenge uses a realistic Transaction model
 * and requires you to combine multiple stream operations to answer
 * business-style questions.
 */
public class StreamsChallenge {

    record Transaction(int id, double amount, String type, LocalDate date) {}

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(1, 500.00, "DEPOSIT", LocalDate.of(2024, 1, 15)),
                new Transaction(2, 200.00, "WITHDRAWAL", LocalDate.of(2024, 1, 20)),
                new Transaction(3, 1500.00, "DEPOSIT", LocalDate.of(2024, 2, 10)),
                new Transaction(4, 300.00, "WITHDRAWAL", LocalDate.of(2024, 2, 14)),
                new Transaction(5, 750.00, "TRANSFER", LocalDate.of(2024, 2, 28)),
                new Transaction(6, 200.00, "WITHDRAWAL", LocalDate.of(2024, 3, 5)),
                new Transaction(7, 1200.00, "DEPOSIT", LocalDate.of(2024, 3, 12)),
                new Transaction(8, 500.00, "TRANSFER", LocalDate.of(2024, 3, 18)),
                new Transaction(9, 100.00, "WITHDRAWAL", LocalDate.of(2024, 3, 22)),
                new Transaction(10, 2000.00, "DEPOSIT", LocalDate.of(2024, 4, 1)),
                new Transaction(11, 750.00, "TRANSFER", LocalDate.of(2024, 4, 10)),
                new Transaction(12, 300.00, "WITHDRAWAL", LocalDate.of(2024, 4, 15)),
                new Transaction(13, 1500.00, "DEPOSIT", LocalDate.of(2024, 5, 3)),
                new Transaction(14, 450.00, "TRANSFER", LocalDate.of(2024, 5, 8)),
                new Transaction(15, 100.00, "WITHDRAWAL", LocalDate.of(2024, 5, 20))
        );

        System.out.println("=== Streams Challenge ===\n");
        transactions.stream()
                .filter(t -> t.type().equalsIgnoreCase("deposit"))
                .forEach(t -> System.out.println("Id: %d, amount: %.2f".formatted(t.id(), t.amount())));


        System.out.println(transactions.stream().collect(Collectors.groupingBy(Transaction::type, Collectors.summingDouble(Transaction::amount))));

        transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .limit(3)
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .forEach(t -> System.out.println("Transaction={id=%d, amount=%.2f, type=%s}".formatted(t.id(), t.amount(), t.type())));


        System.out.println(transactions.stream().collect(Collectors.groupingBy(Transaction::type, Collectors.averagingDouble(Transaction::amount))));

        Map<Month, Long> groupByMonth = transactions.stream().collect(Collectors.groupingBy(t -> t.date().getMonth(), Collectors.counting()));
        System.out.println(
                groupByMonth.entrySet()
                        .stream()
                        .max(Comparator.comparingLong(Map.Entry::getValue))
                        .get()
        );

        long totalTransactions = transactions.stream().count();
        double totalAmount = transactions.stream().mapToDouble(Transaction::amount).sum();
        double averageAmount = transactions.stream().mapToDouble(Transaction::amount).average().orElse(0.0);
        System.out.println("Total transactions: %d | Total amount: $%.2f | Avg amount: $%.2f".formatted(totalTransactions, totalAmount, averageAmount));


        System.out.println(
                transactions.stream()
                        .collect(Collectors.groupingBy(Transaction::amount, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))

        );

        transactions.stream().sorted(Comparator.comparing(Transaction::date).thenComparing(Transaction::amount)).forEach(System.out::println);

    }
}
