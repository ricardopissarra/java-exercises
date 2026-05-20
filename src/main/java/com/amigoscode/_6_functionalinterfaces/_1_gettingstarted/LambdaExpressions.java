package com.amigoscode._6_functionalinterfaces._1_gettingstarted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Exercise: Lambda Expressions
 *
 * Practice writing lambdas for various standard functional interfaces:
 * Comparator, Runnable, Callable, and BiFunction. Learn to simplify
 * multi-line lambdas and pass them directly to methods.
 */
public class LambdaExpressions {

    public static void main(String[] args) throws Exception {

        List<String> names = Arrays.asList("Charlie", "Al", "Bob", "Alexandra");

        Comparator<String> stringComparator = Comparator.comparingInt(String::length);
        names.sort(stringComparator);
        System.out.println("Sorted by length: " + names);

        Runnable runnable = () -> System.out.println("Running in lambda");
        runnable.run();

        Callable<String> callable = () -> "Result from callable";
        System.out.println(callable.call());

        BiFunction<Integer, Integer, Integer> sumVerbose = (Integer a, Integer b) -> {
            int result = a + b;
            return result;
        };
        System.out.println("Verbose sum: " + sumVerbose.apply(3, 4));
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println("sum: " + sum.apply(3, 4));

        BiFunction<String, String, String> concat = (String a, String b) -> "%s + %s".formatted(a, b);
        System.out.println("String concat: " + concat.apply("Hello", "World"));


        Function<String, String> append = s -> "%s!".formatted(s);
        System.out.println(append.apply("Hello"));
        System.out.println(append.apply("Goodbye"));

        System.out.println(processName("alex", s -> s.toUpperCase()));

    }

    /**
     * Applies the given function to the provided name and returns the result.
     *
     * @param name      the input name
     * @param processor a function that transforms the name
     * @return the transformed name
     */
    static String processName(String name, java.util.function.Function<String, String> processor) {
        return processor.apply(name);
    }
}
