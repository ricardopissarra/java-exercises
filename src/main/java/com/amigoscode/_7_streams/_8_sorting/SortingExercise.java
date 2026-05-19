package com.amigoscode._7_streams._8_sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise: Sorting Streams
 *
 * Learn how to sort stream elements using sorted(), Comparator.comparing(),
 * reverse order, and multi-criteria sorting with thenComparing().
 */
public class SortingExercise {

    record Person(String name, int age, String city) {}

    public static void main(String[] args) {
        List<String> fruits = List.of("Banana", "Apple", "Cherry", "Date", "Elderberry", "Fig", "Grape");

        List<Person> people = List.of(
                new Person("Charlie", 30, "London"),
                new Person("Alice", 25, "Paris"),
                new Person("Bob", 30, "Berlin"),
                new Person("Diana", 22, "London"),
                new Person("Eve", 25, "Paris"),
                new Person("Frank", 35, "Berlin"),
                new Person("Grace", 22, "London")
        );

        List<String> words = List.of("Java", "Go", "Python", "C", "JavaScript", "Rust", "Kotlin");

        System.out.println(fruits.stream().sorted(Comparator.naturalOrder()).toList());

        System.out.println(words.stream().sorted(Comparator.comparingInt(String::length)).toList());

        System.out.println(people.stream().sorted(Comparator.comparingInt(Person::age)).toList());

        System.out.println(fruits.stream().sorted(Comparator.reverseOrder()).toList());

        System.out.println(people.stream().sorted(Comparator.comparingInt(Person::age).thenComparing(Person::name)).toList());

        people.stream().sorted(Comparator.comparing(Person::city))
                .forEach(p -> System.out.println("Name: %s, city: %s".formatted(p.name(), p.city())));


        System.out.println(people.stream().sorted(Comparator.comparing(Person::city).thenComparing(Comparator.comparingInt(Person::age).reversed())).toList());

    }
}
