package com.amigoscode._6_functionalinterfaces._2_functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Exercise: BiFunction<T, U, R>
 *
 * BiFunction takes two arguments of types T and U and returns a result of type R.
 * Key methods:
 *   - R apply(T t, U u)
 *   - andThen(Function after) chains a Function after the BiFunction
 *
 * Note: BiFunction does NOT have compose() because compose would need to produce
 * two values from one, which is not possible with a single function.
 */
public class BiFunctionExercise {

    public static void main(String[] args) {

        BiFunction<String, String, String> combiner = (s1, s2) -> "%s %s".formatted(s1, s2);

        BiFunction<Integer, Integer, Integer> max = Math::max;

        BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);

        Function<String, Integer> length = String::length;
        System.out.println(combiner.andThen(length).apply("hello", "world"));


        List<String> firstNames = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> ages = Arrays.asList(30, 25, 35);

        BiFunction<String, Integer, String> describe = (s, n) -> "%s is %d years old.".formatted(s, n);

        List<String> describeList = IntStream.range(0, firstNames.size())
                .mapToObj(i -> describe.apply(firstNames.get(i), ages.get(i)))
                .toList();
        System.out.println(describeList);
    }
}
