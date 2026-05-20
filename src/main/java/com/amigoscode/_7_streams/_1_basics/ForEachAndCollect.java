package com.amigoscode._7_streams._1_basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Exercise: forEach and collect
 *
 * Learn the two most common terminal operations: forEach for performing
 * an action on each element, and collect for gathering results into
 * a collection.
 */
public class ForEachAndCollect {

    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Python", "JavaScript", "Go", "Rust", "Java", "Python");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        languages.forEach(System.out::println);

        numbers.forEach(System.out::println);

        System.out.println(numbers.stream().filter(n -> n%2 == 0).toList());

        System.out.println(languages.stream().collect(Collectors.toSet()));

        List<Integer> integerList = numbers.stream().collect(Collectors.toUnmodifiableList());

        LinkedList<String> stringLinkedList = languages.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(stringLinkedList);
        System.out.println(stringLinkedList.getClass());
    }
}
