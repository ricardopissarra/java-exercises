package com.amigoscode._6_functionalinterfaces._2_functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Exercise: Function<T, R>
 *
 * The Function interface represents a function that takes one argument of type T
 * and returns a result of type R. Key methods:
 *   - R apply(T t)           applies the function
 *   - andThen(Function after) first this, then after
 *   - compose(Function before) first before, then this
 */
public class FunctionExercise {

    public static void main(String[] args) {

        Function<String, Integer> stringLengthFunc = String::length;

        Function<String, String> toUpperCaseFunc = String::toUpperCase;

        System.out.println(toUpperCaseFunc.andThen(stringLengthFunc).apply("Hello"));

        //  Note: compose applies the argument function FIRST.
        System.out.println(stringLengthFunc.compose(toUpperCaseFunc).apply("hello"));

        Function<Integer, String> intToWord = n -> switch (n) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4-> "four";
            case 5 -> "five";
            default -> "unknown";
        };

        System.out.println(intToWord.apply(2));
        System.out.println(intToWord.apply(7));
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<Integer> lengths = words.stream()
                .map(stringLengthFunc)
                .toList();
        System.out.println(lengths);

        System.out.println(applyFunction(stringLengthFunc, "Functional Programming"));
    }

    /**
     * Applies the given function to the input value and returns the result.
     *
     * @param function the function to apply
     * @param input    the input value
     * @param <T>      input type
     * @param <R>      result type
     * @return the result of applying the function
     */
    static <T, R> R applyFunction(Function<T, R> function, T input) {
        return function.apply(input);
    }
}
