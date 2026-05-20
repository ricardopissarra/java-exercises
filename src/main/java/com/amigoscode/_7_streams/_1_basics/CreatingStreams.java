package com.amigoscode._7_streams._1_basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Exercise: Creating Streams
 *
 * Learn the different ways to create streams in Java.
 * Streams can be created from collections, arrays, individual values,
 * strings, and even generated infinitely.
 */
public class CreatingStreams {

    public static void main(String[] args) {
        // Setup data
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
        String sentence = "Hello";

        names.stream().forEach(System.out::println);

        Arrays.stream(fruits).forEach(System.out::println);
        Stream.of("Red", "Green", "Blue").forEach(System.out::println);

        System.out.println(Stream.empty().count());

        sentence.chars().mapToObj(c -> (char) c).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
