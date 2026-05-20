package com.amigoscode._6_functionalinterfaces._2_functionalinterfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Exercise: Supplier<T>
 *
 * Supplier represents a supplier of results. It takes no arguments and returns
 * a value of type T. It is commonly used for lazy initialization, factories,
 * and deferred computation. Key method:
 *   - T get()
 */
public class SupplierExercise {

    public static void main(String[] args) {

        Supplier<String> helloSupplier = () -> "Hello World";
        System.out.println(helloSupplier.get());

        Supplier<Double> randomSupplier = Math::random;
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());



        Supplier<List<String>> listFactory = ArrayList::new;
        List<String> first = listFactory.get();
        List<String> second = listFactory.get();
        first.add("A");
        System.out.println(first);
        System.out.println(second);

        Supplier<String> expensiveOperation = () -> {
            System.out.println("Computing... ");

            return "Result";
        };
        System.out.println("Before get() " + expensiveOperation.get() + " After get()");

        Supplier<LocalDateTime> now = LocalDateTime::now;
        System.out.println(now.get());

        List<Double> doubles = generateMultiple(randomSupplier, 5);
        System.out.println(doubles);
    }

    /**
     * Calls the supplier's get() method the specified number of times and
     * collects the results into a list.
     *
     * @param supplier the supplier to call
     * @param count    how many times to call get()
     * @param <T>      the type of supplied values
     * @return a list containing the supplied values
     */
    static <T> List<T> generateMultiple(Supplier<T> supplier, int count) {
        List<T> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(supplier.get());
        }
        return results;
    }
}
