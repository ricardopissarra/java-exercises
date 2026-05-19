package com.amigoscode._6_functionalinterfaces._2_functionalinterfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Exercise: Consumer<T> and BiConsumer<T, U>
 *
 * Consumer represents an operation that accepts a single input and returns no
 * result (void). It is used for side effects such as printing or modifying state.
 * Key methods:
 *   - void accept(T t)
 *   - andThen(Consumer after) chains another consumer after this one
 *
 * BiConsumer is similar but takes two arguments.
 */
public class ConsumerExercise {

    public static void main(String[] args) {

        Consumer<String> greeter = s -> System.out.println("Hello, %s!".formatted(s));

        Consumer<String> shouter = s -> System.out.println(s.toUpperCase());


        Consumer<String> greetThenShout = greeter.andThen(shouter);
        greetThenShout.accept("Alice");

        BiConsumer<String, Integer> printNameAge = (s, n) -> System.out.println("%s is %d years old.".formatted(s, n));
        printNameAge.accept("Bob", 25);


        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");
        names.forEach(greeter);

        processAll(shouter, names);

        Map<String, Integer> scores = new HashMap<>();
        BiConsumer<String, Integer> addToMap = scores::put;
        addToMap.accept("Alice", 95);
        addToMap.accept("Bob", 87);
        addToMap.accept("Charlie", 92);
        System.out.println(scores);

    }

    /**
     * Applies the given consumer to each element in the list.
     *
     * @param consumer the consumer to apply
     * @param items    the list of items
     * @param <T>      the type of items
     */
    static <T> void processAll(Consumer<T> consumer, List<T> items) {
        for (T item : items) {
            consumer.accept(item);
        }
    }
}
