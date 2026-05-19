package com.amigoscode._7_streams._6_transformations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Exercise: FlatMap
 *
 * Learn how to use flatMap() to flatten nested structures.
 * flatMap transforms each element into a stream and then merges
 * all those streams into a single flat stream.
 */
public class FlatMapExercise {

    record Department(String name, List<Employee> employees) {}

    record Employee(String name, double salary) {}

    public static void main(String[] args) {
        List<List<String>> nestedLists = List.of(
                List.of("Java", "Kotlin"),
                List.of("Python", "Ruby"),
                List.of("JavaScript", "TypeScript")
        );

        String[][] arrayOfArrays = {
                {"Red", "Green"},
                {"Blue", "Yellow"},
                {"Black", "White"}
        };

        List<String> words = List.of("Hello", "World", "Java");

        List<Optional<String>> optionals = List.of(
                Optional.of("Alice"),
                Optional.empty(),
                Optional.of("Bob"),
                Optional.empty(),
                Optional.of("Charlie")
        );

        List<Department> departments = List.of(
                new Department("Engineering", List.of(
                        new Employee("Alice", 95000),
                        new Employee("Bob", 88000)
                )),
                new Department("Marketing", List.of(
                        new Employee("Charlie", 72000),
                        new Employee("Diana", 78000)
                )),
                new Department("Sales", List.of(
                        new Employee("Eve", 68000)
                ))
        );

        int[][] nestedInts = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};

        System.out.println(nestedLists.stream().flatMap(List::stream).toList());

        System.out.println(Arrays.stream(arrayOfArrays).flatMap(Arrays::stream).toList());

        words.stream()
                .flatMap(word -> word.chars()
                        .mapToObj(c -> (char) c)
                )
                        .forEach(c -> System.out.print(c + " "));

        System.out.println();

        System.out.println(optionals.stream().flatMap(Optional::stream).toList());

        departments.stream()
                .flatMap(department -> Stream.of(department.employees))
                .flatMap(List::stream)
                .forEach(e -> System.out.println("Name: %s, salary: %.2f".formatted(e.name(), e.salary())));

        System.out.println(Arrays.stream(nestedInts).flatMapToInt(Arrays::stream).sum());

        System.out.println(
                departments.stream().flatMap(
                department -> Stream.of(department.employees)
                )
                .flatMap(List::stream)
                .filter(e -> e.salary() > 7500)
                .map(Employee::name)
                .toList()
        );
    }
}
