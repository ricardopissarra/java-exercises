package com.amigoscode._7_streams._6_transformations;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise: Map Transformations
 *
 * Practice using map(), mapToInt(), and mapToDouble() to transform
 * stream elements. Learn to chain map operations and use method references.
 */
public class MapExercise {

    record Person(String name, int age, String email) {}

    record PersonDTO(String name, String email) {}

    record Product(String name, double price, int quantity) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 30, "alice@example.com"),
                new Person("Bob", 25, "bob@example.com"),
                new Person("Charlie", 35, "charlie@example.com"),
                new Person("Diana", 28, "diana@example.com")
        );

        List<Product> products = List.of(
                new Product("Laptop", 999.99, 2),
                new Product("Mouse", 29.99, 10),
                new Product("Keyboard", 79.99, 5),
                new Product("Monitor", 449.99, 3)
        );

        List<String> sentences = List.of(
                "Hello World",
                "Java Streams",
                "Functional Programming"
        );

        System.out.println(people.stream().map(Person::name).toList());

        System.out.println(people.stream().map(p -> new PersonDTO(p.name(), p.email())).toList());

        System.out.println(people.stream().mapToInt(Person::age).sum());

        System.out.println(products.stream().mapToDouble(Product::price).sum());

        sentences.stream()
                .map(String::toLowerCase)
                .map(s -> s.split(" ")[0])
                .forEach(System.out::println);

        System.out.println(sentences.stream().map(String::toUpperCase).toList());
    }
}
