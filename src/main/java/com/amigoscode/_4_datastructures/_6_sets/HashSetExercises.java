package com.amigoscode._4_datastructures._6_sets;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExercises {

    public static void main(String[] args) {

        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");
        fruits.add("Date");
        fruits.add("Banana");
        System.out.println(fruits);

        System.out.println(fruits.contains("Cherry"));

        fruits.remove("Date");
        System.out.println(fruits);
        System.out.println(fruits.size());


        fruits.forEach(System.out::println);

        // --- Removing Duplicates from a List ---
        System.out.println("\n--- Removing Duplicates ---");
        List<String> listWithDuplicates = new ArrayList<>(
                Arrays.asList("Java", "Python", "Java", "C++", "Python", "Go", "Java")
        );
        System.out.println("Original list: " + listWithDuplicates);

        System.out.println("Set from list: %s".formatted(new HashSet<>(listWithDuplicates)));

    }
}
