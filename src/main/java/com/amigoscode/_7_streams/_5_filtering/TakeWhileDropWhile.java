package com.amigoscode._7_streams._5_filtering;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise: takeWhile and dropWhile
 *
 * Learn how to use takeWhile() and dropWhile() (Java 9+) to process
 * elements from ordered streams. Unlike filter(), these operations
 * are order-dependent and stop/start based on when the predicate changes.
 */
public class TakeWhileDropWhile {

    public static void main(String[] args) {
        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> unsortedNumbers = List.of(1, 3, 2, 5, 4, 7, 6, 8);
        List<String> logLevels = List.of("DEBUG", "DEBUG", "INFO", "INFO", "WARN", "ERROR", "ERROR");
        List<String> words = List.of("apple", "avocado", "apricot", "banana", "blueberry", "cherry");
        System.out.println("Take while n < 5");
        sortedNumbers.stream().takeWhile(n -> n < 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Drop while n < 5");
        sortedNumbers.stream().dropWhile(n -> n < 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println(sortedNumbers.stream().takeWhile(n -> n < 7).filter(n -> n % 2 == 0).toList());

        System.out.println("Take while word starts with a");
        words.stream().takeWhile(s -> s.startsWith("a")).forEach(s -> System.out.print(s + " "));
        System.out.println();

        System.out.println("TakeWhile vs filter on unsortedNumbers");
        unsortedNumbers.stream().takeWhile(n -> n < 5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        unsortedNumbers.stream().filter(n -> n < 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println(logLevels.stream().dropWhile(s -> s.equals("DEBUG")).toList());
    }
}
