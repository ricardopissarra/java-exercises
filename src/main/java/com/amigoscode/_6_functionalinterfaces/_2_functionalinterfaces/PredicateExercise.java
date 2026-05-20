package com.amigoscode._6_functionalinterfaces._2_functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Exercise: Predicate<T> and BiPredicate<T, U>
 *
 * Predicate represents a boolean-valued function of one argument. It is commonly
 * used for filtering and conditional logic. Key methods:
 *   - boolean test(T t)
 *   - and(Predicate other)    logical AND
 *   - or(Predicate other)     logical OR
 *   - negate()                logical NOT
 *
 * BiPredicate takes two arguments and returns a boolean.
 */
public class PredicateExercise {

    public static void main(String[] args) {

        Predicate<Integer> isPositive = n -> n > 0;

        Predicate<String> isNotEmpty = s -> s != null && !s.isEmpty();

        Predicate<Integer> isEven = n -> n % 2 == 0;

        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
        System.out.println(isPositiveAndEven.test(4));
        System.out.println(isPositiveAndEven.test(-2));
        System.out.println(isPositiveAndEven.test(3));
        System.out.println(isPositiveAndEven.test(0));

        Predicate<Integer> isMultipleOf3 = n -> n % 3 == 0;
        Predicate<Integer> isEvenOrMultipleOf3 = isEven.or(isMultipleOf3);
        System.out.println(isEvenOrMultipleOf3.test(4));
        System.out.println(isEvenOrMultipleOf3.test(9));
        System.out.println(isEvenOrMultipleOf3.test(7));
        System.out.println(isEvenOrMultipleOf3.test(6));

        Predicate<Integer> isNotPositive = isPositive.negate();
        System.out.println(isNotPositive.test(5));
        System.out.println(isNotPositive.test(-3));
        System.out.println(isNotPositive.test(0));


        List<Integer> numbers = Arrays.asList(-5, -2, 0, 1, 3, 6, 8, 11, 15, -7);

        List<Integer> filteredList = numbers.stream()
                .filter(isPositiveAndEven)
                .toList();
        System.out.println(filteredList);

        BiPredicate<String, Integer> hasLength = (s, n) -> s.length() == n;
        System.out.println(hasLength.test("hello", 5));
        System.out.println(hasLength.test("hi", 3));

    }
}
