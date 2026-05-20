package com.amigoscode._7_streams._1_basics;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Exercise: Reduce Basics
 *
 * Learn how to use the reduce() terminal operation to combine all elements
 * of a stream into a single result. Reduce is one of the most powerful
 * stream operations and can express many computations.
 */
public class ReduceBasics {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> factors = List.of(2, 3, 4, 5);
        List<String> words = List.of("Java", "Streams", "Are", "Awesome");

        Integer sum = numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(sum);

        Integer factor = factors.stream()
                .reduce((integer, integer2) -> integer * integer2)
                .orElse(0);
        System.out.println(factor);

        String phrase = words.stream()
                .reduce((s, s2) -> s + " " + s2)
                .orElse(null);
        System.out.println(phrase);

        Integer sumWithIdentity = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sumWithIdentity);

        String longest = words.stream()
                .reduce((s, s2) -> s.length() >= s2.length() ? s : s2)
                .orElse(null);
        System.out.println(longest);

        BinaryOperator<Integer> integerBinaryOperator = (i, j) -> Integer.sum(i, j*j);
        Integer squaredSum = numbers.stream()
                .reduce(0, integerBinaryOperator);

        System.out.println(squaredSum);

    }
}
