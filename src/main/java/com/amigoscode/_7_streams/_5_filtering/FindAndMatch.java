package com.amigoscode._7_streams._5_filtering;

import java.util.List;
import java.util.Optional;

/**
 * Exercise: Find and Match Operations
 *
 * Learn how to use findFirst(), findAny(), allMatch(), anyMatch(),
 * and noneMatch() - short-circuiting terminal operations that don't
 * need to process all elements.
 */
public class FindAndMatch {

    record Product(String name, double price, String category) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10, 11, 12, 14);
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");
        List<Product> products = List.of(
                new Product("Laptop", 999.99, "Electronics"),
                new Product("Mouse", 29.99, "Electronics"),
                new Product("Desk", 299.99, "Furniture"),
                new Product("Chair", 199.99, "Furniture"),
                new Product("Monitor", 449.99, "Electronics"),
                new Product("Lamp", 49.99, "Furniture")
        );
        List<Integer> evenNumbers = List.of(2, 4, 6, 8, 10);
        Integer greaterThanSeven = numbers.stream()
                .filter(n -> n > 7)
                .findFirst()
                .orElse(0);
        System.out.println(greaterThanSeven);

        System.out.println(names.parallelStream().filter(s -> "AEIOU".contains(s.subSequence(0,1))).findAny().get());
        System.out.println(names.parallelStream().filter(s -> "AEIOU".contains(s.subSequence(0,1))).findAny().get());


        System.out.println(evenNumbers.stream().allMatch(n -> n % 2 == 0));

        System.out.println(products.stream().anyMatch(p -> p.price() > 500));
        System.out.println(products.stream().noneMatch(p -> p.price() < 0));


        Optional<Product> furniture = products.stream()
                .filter(p -> p.category().equals("Furniture"))
                .findFirst();
        furniture.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("products of furniture category not found")
        );

        System.out.println(products.stream()
                .filter(p -> p.price() >= 100 && p.price <= 300)
                .map(Product::name)
                .findFirst()
                .orElse("Not found"));

    }
}
