package com.amigoscode._7_streams._2_intstreams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Exercise: IntStream Basics
 *
 * Learn how to use IntStream, a specialized stream for int primitives.
 * IntStream avoids boxing overhead and provides useful numeric operations
 * like sum(), average(), min(), and max().
 */
public class IntStreamBasics {

    public static void main(String[] args) {

        IntStream.range(1, 11).forEach(System.out::println);

        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);

        System.out.println(IntStream.rangeClosed(1, 5).boxed().toList());

        IntStream.of(10, 20, 30, 40, 50).forEach(System.out::println);

        System.out.println(IntStream.of(85, 90, 78, 92, 88).average().getAsDouble());


        System.out.println(IntStream.of(15, 3, 42, 7, 28).summaryStatistics().toString());

    }
}
