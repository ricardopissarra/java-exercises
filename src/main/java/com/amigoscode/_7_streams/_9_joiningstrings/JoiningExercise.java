package com.amigoscode._7_streams._9_joiningstrings;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise: Joining Strings
 *
 * Learn how to use Collectors.joining() to concatenate stream elements
 * into a single string with optional separators, prefixes, and suffixes.
 */
public class JoiningExercise {

    record Person(String firstName, String lastName) {}

    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Cherry", "Date", "Elderberry");

        List<Person> people = List.of(
                new Person("Alice", "Smith"),
                new Person("Bob", "Johnson"),
                new Person("Charlie", "Brown"),
                new Person("Diana", "Williams")
        );

        List<String> headers = List.of("Name", "Age", "City", "Email");
        List<String> values = List.of("Alice", "30", "London", "alice@example.com");

        System.out.println(fruits.stream().collect(Collectors.joining(", ")));
        System.out.println(fruits.stream().collect(Collectors.joining(", ", "[", "]")));

        System.out.println(people.stream().map(p -> p.firstName() + " " + p.lastName()).collect(Collectors.joining(" | ")));


        System.out.println(fruits.stream().collect(Collectors.joining("\n")));
        System.out.println();
        System.out.println(headers.stream().collect(Collectors.joining(",")));
        System.out.println(values.stream().collect(Collectors.joining(",")));

    }
}
