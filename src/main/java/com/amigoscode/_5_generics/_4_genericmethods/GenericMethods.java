package com.amigoscode._5_generics._4_genericmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Generic Methods
 *
 * This exercise focuses on writing static generic methods.
 * Generic methods declare their own type parameters independently
 * of any generic class. The type parameter appears before the return type.
 *
 * Complete the TODOs below.
 */
public class GenericMethods {

    static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    static <T> T getFirst(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    static <T> List<T> filterNulls(List<T> list) {
        List<T> filtered = new ArrayList<>();
        for (T t : list) {
            if (t != null)
                filtered.add(t);
        }
        return filtered;
    }

    static <T> boolean contains(T[] array, T target) {
        for (T t : array) {
            if (t != null && t.equals(target))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String[] names = {"Alice", "Alex", "Bob"};
        Integer[] numbers = {1, 2, 3};
        printArray(names);
        printArray(numbers);

        System.out.println(getFirst(List.of("Alice", "Alex", "Bob")));
        System.out.println(getLast(List.of("Alice", "Alex", "Bob")));
        List<String> namesWithNull = new ArrayList<>();
        namesWithNull.add("Alice");
        namesWithNull.add(null);
        namesWithNull.add("Alex");
        namesWithNull.add(null);
        namesWithNull.add("Bob");
        namesWithNull.add(null);
        System.out.println(filterNulls(namesWithNull));

        System.out.println(contains(names, "Alice"));
        System.out.println(contains(numbers, 4));

    }
}
