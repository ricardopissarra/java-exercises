package com.amigoscode._7_streams._1_basics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Exercise: Filter Basics
 *
 * Learn how to use the filter() intermediate operation to select
 * elements from a stream that match a given condition (predicate).
 */
public class FilterBasics {

    public static void main(String[] args) {
        List<String> words = List.of("stream", "api", "lambda", "collection", "filter", "map", "reduce");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> cities = List.of("Amsterdam", "Berlin", "Athens", "Barcelona", "Copenhagen", "Auckland");
        List<String> withNulls = Arrays.asList("Hello", null, "World", null, "Java", "Streams", null);

        words.stream().filter(s -> s.length() > 5).forEach(System.out::println);

        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        cities.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);

        words.stream()
                .filter(s -> s.length() > 3)
                .filter(s -> s.contains("a"))
                .forEach(System.out::println);

        withNulls.stream().filter(Objects::nonNull).forEach(System.out::println);

        List<Integer> greaterThanFive = numbers.stream().filter(n -> n > 5).toList();

    }
}
