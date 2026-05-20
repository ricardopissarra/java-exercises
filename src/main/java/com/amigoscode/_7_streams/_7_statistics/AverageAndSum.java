package com.amigoscode._7_streams._7_statistics;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Exercise: Average and Sum
 *
 * Learn to calculate averages and sums using both stream primitive
 * specializations (mapToInt, mapToDouble) and Collectors.
 */
public class AverageAndSum {

    record Student(String name, int score) {}

    record Product(String name, double price, int quantity) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 92),
                new Student("Bob", 85),
                new Student("Charlie", 78),
                new Student("Diana", 95),
                new Student("Eve", 88)
        );

        List<Product> products = List.of(
                new Product("Widget A", 10.0, 5),
                new Product("Widget B", 20.0, 3),
                new Product("Widget C", 15.0, 8),
                new Product("Widget D", 25.0, 2)
        );

        List<Student> emptyStudents = List.of();

        System.out.println(students.stream().mapToInt(Student::score).sum());

        System.out.println(students.stream().mapToDouble(Student::score).average().orElse(0.0));


        System.out.println(students.stream().collect(Collectors.summingInt(Student::score)));

        System.out.println(products.stream().collect(Collectors.averagingDouble(Product::price)));


        double numerator = products.stream().mapToDouble(p -> p.price() * p.quantity()).sum();
        int denominator = products.stream().mapToInt(Product::quantity).sum();
        System.out.println(numerator/denominator);

        System.out.println(emptyStudents.stream().mapToDouble(Student::score).average().orElse(0.0));

    }
}
