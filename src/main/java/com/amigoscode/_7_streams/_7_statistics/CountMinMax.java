package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercise: Count, Min, and Max
 *
 * Learn to use counting operations and find minimum/maximum elements
 * using both stream methods and Collectors.
 */
public class CountMinMax {

    record Employee(String name, String department, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 95000),
                new Employee("Bob", "Engineering", 88000),
                new Employee("Charlie", "Marketing", 72000),
                new Employee("Diana", "Marketing", 78000),
                new Employee("Eve", "Sales", 68000),
                new Employee("Frank", "Engineering", 102000),
                new Employee("Grace", "Sales", 71000),
                new Employee("Henry", "Marketing", 82000)
        );

        System.out.println(employees.stream().filter(e -> e.salary() > 80000).count());

        System.out.println(employees.stream().min(Comparator.comparingDouble(Employee::salary)).get());

        System.out.println(employees.stream().max(Comparator.comparingDouble(Employee::salary)).get());


        System.out.println(employees.stream().collect(Collectors.counting()));

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting())));

        System.out.println(employees.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::salary))));
        System.out.println(employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::salary))));


    }
}
