package com.amigoscode._7_streams._11_understanding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercise: Lazy Evaluation and Stream Behavior
 *
 * Understand how streams are lazily evaluated, how short-circuiting works,
 * why streams can only be consumed once, and how operation ordering
 * affects performance.
 */
public class LazyStreams {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve", "Frank");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(
                names.stream()
                .peek(n -> System.out.println("Processing: " +n))
                .filter(n -> n.length() > 3)
                .peek(n -> System.out.println("After filter: " +n))
                .findFirst()
        );

        System.out.println(
                numbers.stream()
                        .peek(n -> System.out.println("Checking: " + n))
                        .filter(n -> n > 5)
                        .findFirst()
        );

        long count = names.stream().count();
        try {
            names.stream().count();//.count();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(
                numbers.stream()
                        .filter(n -> n > 5)
                        .peek(n -> System.out.println("Mapping " + n))
                        .map(n -> n * n)
                        .toList()
        );
        System.out.println(
                numbers.stream()
                        .peek(n -> System.out.println("Mapping " + n))
                        .map(n -> n * n)
                        .filter(n -> n > 25)
                        .toList()
        );

        names.stream().filter(s -> s.length() > 3).peek(n -> System.out.println("This should NOT print"));
        names.stream().filter(s -> s.length() > 3).peek(n -> System.out.println("This SHOULD print")).toList();

    }
}
