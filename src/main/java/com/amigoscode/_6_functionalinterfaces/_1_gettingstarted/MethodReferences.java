package com.amigoscode._6_functionalinterfaces._1_gettingstarted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Exercise: Method References
 *
 * Method references are a shorthand for lambdas that simply call an existing
 * method. There are four kinds:
 *   1. Static method reference:           ClassName::staticMethod
 *   2. Instance method on a specific object: instance::method
 *   3. Instance method on the parameter:  ClassName::instanceMethod
 *   4. Constructor reference:             ClassName::new
 */
public class MethodReferences {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Function<Integer, String> converter = String::valueOf;
        System.out.println(converter.apply(42));

        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello from method ref!");

        Function<String, String> toUpperFunction = String::toUpperCase;
        System.out.println(toUpperFunction.apply("hello"));

        Supplier<ArrayList<String>> arrayListSupplier = ArrayList::new;
        System.out.println(arrayListSupplier.get());
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.forEach(System.out::println);

        Function<String, Integer> withLambda = s -> s.length();
        Function<String, Integer> withMethodRef = String::length;
        System.out.println(withLambda.apply("hello"));
        System.out.println(withMethodRef.apply("hello"));

    }
}
