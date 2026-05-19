package com.amigoscode._7_streams._1_basics;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Exercise: Map Basics
 *
 * Learn how to use the map() intermediate operation to transform
 * each element of a stream into a different value or type.
 */
public class MapBasics {

    public static void main(String[] args) {
        List<String> names = List.of("alice", "bob", "charlie", "diana", "eve");
        List<String> words = List.of("Java", "Streams", "Are", "Powerful", "Tools");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> numberStrings = List.of("10", "20", "30", "40", "50");

        names.stream().map(String::toUpperCase).forEach(System.out::println);

        words.stream().mapToInt(String::length).forEach(System.out::println);

        numbers.stream().mapToInt(n -> n * n).forEach(System.out::println);

        Function<String, String> nameFormat = s ->  s.substring(0, 1).toUpperCase() + s.substring(1);
        Consumer<String> greeting = name -> System.out.println("Hello, %s".formatted(name));

        names.stream().map(nameFormat).forEach(greeting);

        numbers.stream().filter(n -> n % 2 == 0).mapToInt( n -> n * n * n).forEach(System.out::println);


        List<Integer> integers = numberStrings.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();


    }
}
