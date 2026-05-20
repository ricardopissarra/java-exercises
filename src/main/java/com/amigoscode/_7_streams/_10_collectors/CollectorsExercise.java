package com.amigoscode._7_streams._10_collectors;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Exercise: Advanced Collectors
 *
 * Practice using advanced collectors including toMap(), toUnmodifiableList(),
 * partitioningBy(), collectingAndThen(), and teeing().
 */
public class CollectorsExercise {

    record Person(String name, int age, String city) {}

    record Product(String name, double price, String category) {}

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");

        List<Person> people = List.of(
                new Person("Alice", 30, "London"),
                new Person("Bob", 25, "Paris"),
                new Person("Charlie", 35, "London"),
                new Person("Diana", 22, "Berlin"),
                new Person("Eve", 28, "Paris")
        );

        List<Product> products = List.of(
                new Product("Laptop", 999.99, "Electronics"),
                new Product("Mouse", 29.99, "Electronics"),
                new Product("Desk", 299.99, "Furniture"),
                new Product("Chair", 199.99, "Furniture"),
                new Product("Keyboard", 79.99, "Electronics")
        );

        List<Person> peopleWithDuplicateCities = List.of(
                new Person("Alice", 30, "London"),
                new Person("Bob", 25, "London"),
                new Person("Charlie", 35, "Paris")
        );

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<String> unmodifiableList = names.stream().toList();
        try {
            unmodifiableList.add("Alex");
        } catch (UnsupportedOperationException e) {
            System.err.println("We cannot add elements to an unmodifiable list");
        }

        System.out.println(people.stream().collect(Collectors.toMap(Person::name, Person::age)));

        System.out.println(peopleWithDuplicateCities.stream().collect(Collectors.toMap(Person::city, Person::name, (name1, name2) -> name1 + ", " + name2)));


        ConcurrentMap<String, String> peopleMap = people.stream().collect(Collectors.toConcurrentMap(Person::name, Person::city));
        System.out.println(peopleMap);
        System.out.println(peopleMap.getClass());


        System.out.println(numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0)));

        System.out.println(names.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size)).intValue());

        Double avg = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.counting(),
                        (sum, count) -> sum / count)).doubleValue();

        System.out.println(avg);

    }
}
