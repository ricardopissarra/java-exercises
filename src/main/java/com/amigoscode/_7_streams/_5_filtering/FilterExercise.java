package com.amigoscode._7_streams._5_filtering;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Exercise: Advanced Filtering
 *
 * Practice more complex filtering scenarios including chaining filters,
 * using Predicate variables, and combining conditions.
 */
public class FilterExercise {

    record Person(String name, int age, String city) {}

    record Order(String product, double amount, String status) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 25, "London"),
                new Person("Bob", 17, "Paris"),
                new Person("Charlie", 30, "London"),
                new Person("Diana", 15, "Berlin"),
                new Person("Eve", 22, "Paris"),
                new Person("Frank", 45, "Berlin"),
                new Person("Grace", 12, "London")
        );

        List<Order> orders = List.of(
                new Order("Laptop", 999.99, "COMPLETED"),
                new Order("Mouse", 29.99, "PENDING"),
                new Order("Keyboard", 149.99, "COMPLETED"),
                new Order("Monitor", 399.99, "SHIPPED"),
                new Order("Headset", 79.99, "PENDING"),
                new Order("Webcam", 59.99, "COMPLETED")
        );

        List<String> emails = List.of(
                "user@example.com",
                "invalid-email",
                "admin@company.co.uk",
                "not-an-email",
                "hello@world.org",
                "test@test.com"
        );

        people.stream()
                .filter(p -> p.age() > 18)
                .forEach(p -> System.out.println("%s %s".formatted(p.name(), p.age())));

        orders.stream()
                .filter(o -> o.amount() > 100)
                .forEach(o -> System.out.println("%s %s".formatted(o.product(), o.amount())));

        emails.stream()
                .filter(s -> s.matches(".+@.+\\..+"))
                .forEach(System.out::println);


        people.stream()
                .filter(p -> p.age() > 18)
                .filter(p -> p.city().equals("London"))
                .forEach(System.out::println);

        Predicate<Order> isExpensive = order -> order.amount() >= 100;
        orders.stream()
                .filter(isExpensive)
                .forEach(System.out::println);

        people.stream()
                .filter(p -> p.city().equals("Paris") || p.age() < 18)
                .forEach(System.out::println);

        System.out.println(orders.stream().filter(o -> o.status.equals("COMPLETED")).count());

    }
}
