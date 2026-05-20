package com.amigoscode._7_streams._7_statistics;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Exercise: GroupingBy
 *
 * Learn how to use Collectors.groupingBy() to group stream elements
 * into a Map. Practice with downstream collectors for counting, summing,
 * and multi-level grouping.
 */
public class GroupingBy {

    record Person(String name, int age, String city) {}

    record Order(String product, double amount, String status) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 30, "London"),
                new Person("Bob", 25, "Paris"),
                new Person("Charlie", 35, "London"),
                new Person("Diana", 22, "Berlin"),
                new Person("Eve", 28, "Paris"),
                new Person("Frank", 45, "Berlin"),
                new Person("Grace", 19, "London"),
                new Person("Henry", 33, "Paris")
        );

        List<Order> orders = List.of(
                new Order("Laptop", 999.99, "COMPLETED"),
                new Order("Mouse", 29.99, "PENDING"),
                new Order("Keyboard", 79.99, "COMPLETED"),
                new Order("Monitor", 449.99, "SHIPPED"),
                new Order("Headset", 59.99, "PENDING"),
                new Order("Webcam", 39.99, "COMPLETED"),
                new Order("Cable", 9.99, "SHIPPED")
        );

        List<String> words = List.of(
                "apple", "banana", "avocado", "blueberry", "cherry",
                "apricot", "blackberry", "coconut", "cranberry", "almond"
        );
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::city)));

        System.out.println(orders.stream().collect(Collectors.groupingBy(Order::status)));

        System.out.println(words.stream().collect(Collectors.groupingBy(w -> w.charAt(0))));

        System.out.println(orders.stream().collect(Collectors.groupingBy(
                Order::status,
                Collectors.counting()
        )));

        System.out.println(orders.stream().collect(Collectors.groupingBy(
                Order::status,
                Collectors.summingDouble(Order::amount)
        )));


        System.out.println(people.stream().collect(Collectors.groupingBy(Person::city, Collectors.mapping(Person::name, Collectors.toSet()))));

        System.out.println(people.stream().collect(Collectors.groupingBy(Person::city, Collectors.groupingBy(p -> getAgeRange(p.age())))));

    }

    private static String getAgeRange(int age) {
        if (age < 25) return "Young";
        if (age <= 35) return "Adult";
        return "Senior";
    }
}
