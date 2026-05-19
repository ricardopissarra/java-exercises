package com.amigoscode._7_streams._3_minmax;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Exercise: Min and Max
 *
 * Learn how to find minimum and maximum elements in a stream
 * using min(), max(), and reduce(). These operations return Optional
 * since the stream might be empty.
 */
public class MinMax {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(45, 12, 89, 3, 67, 34, 91, 23, 56);
        List<String> words = List.of("Java", "Streams", "Hi", "Programming", "API", "Go");
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Diana", 22),
                new Person("Eve", 28)
        );
        List<Integer> emptyList = List.of();

        System.out.println(numbers.stream().min(Integer::compareTo).orElse(0));
        System.out.println(numbers.stream().max(Integer::compareTo).orElse(0));

        System.out.println(words.stream().min(Comparator.comparingInt(String::length)).orElse(null));
        System.out.println(people.stream().min(Comparator.comparingInt(Person::age)).orElse(null));

        System.out.println(numbers.stream().reduce(Integer::max).orElse(0));
        System.out.println(emptyList.stream().min(Integer::compareTo).orElse(-1));


    }
}
