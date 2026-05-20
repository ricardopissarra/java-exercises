package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Exercise: Grouping and Counting
 *
 * Practice advanced grouping scenarios including finding the most common
 * element, partitioning, and using downstream collectors like mapping() and maxBy().
 */
public class GroupingAndCounting {

    record Student(String name, int grade, String subject) {}

    public static void main(String[] args) {
        List<String> wordsWithRepeats = List.of(
                "java", "streams", "lambda", "java", "streams",
                "java", "functional", "lambda", "streams", "api",
                "java", "lambda", "functional", "api", "streams"
        );

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        List<Student> students = List.of(
                new Student("Alice", 92, "Math"),
                new Student("Bob", 85, "Science"),
                new Student("Charlie", 78, "Math"),
                new Student("Diana", 95, "Science"),
                new Student("Eve", 88, "Math"),
                new Student("Frank", 72, "Science"),
                new Student("Grace", 91, "Math"),
                new Student("Henry", 83, "Science")
        );

        Map<String, Long> occurrences = wordsWithRepeats.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(occurrences);

        System.out.println(occurrences.entrySet().stream().max(Map.Entry.comparingByValue()).get());


        Map<Boolean, List<Integer>> booleanListMap = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(booleanListMap);

        System.out.println(students.stream().collect(Collectors.partitioningBy(s -> s.grade() >= 85)));


        System.out.println(students.stream().collect(Collectors.groupingBy(Student::subject, Collectors.mapping(Student::name, Collectors.toList()))));

        System.out.println(students.stream().collect(Collectors.groupingBy(Student::subject, Collectors.maxBy(Comparator.comparingDouble(Student::grade)))));

    }
}
