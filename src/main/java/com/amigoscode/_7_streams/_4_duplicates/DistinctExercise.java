package com.amigoscode._7_streams._4_duplicates;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Exercise: Removing Duplicates
 *
 * Learn different ways to remove duplicate elements from a stream
 * using distinct(), collecting to a Set, and custom approaches.
 */
public class DistinctExercise {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Integer> numbersWithDuplicates = List.of(1, 2, 3, 2, 4, 5, 3, 6, 1, 7, 5, 8);
        List<String> mixedCaseNames = List.of("Alice", "bob", "ALICE", "Bob", "charlie", "CHARLIE", "alice");
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 30),
                new Person("Charlie", 35),
                new Person("Bob", 25)
        );
        List<String> fruits = List.of("banana", "apple", "cherry", "apple", "banana", "date", "cherry");

        System.out.println(numbersWithDuplicates.stream().distinct().toList());
        System.out.println(numbersWithDuplicates.stream().distinct().count());

        System.out.println(mixedCaseNames.stream().map(String::toLowerCase).distinct().toList());

        System.out.println(fruits.stream().collect(Collectors.toSet()));

        System.out.println(people.stream().distinct().toList());

        System.out.println(fruits.stream().collect(Collectors.toCollection(() -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER))));


    }
}
