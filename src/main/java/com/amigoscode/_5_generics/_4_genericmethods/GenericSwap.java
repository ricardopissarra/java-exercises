package com.amigoscode._5_generics._4_genericmethods;

import java.util.Arrays;

/**
 * Exercise: Generic Swap and Reverse
 *
 * This exercise practices generic methods by implementing swap and reverse
 * operations that work with arrays of any type.
 *
 * Complete the TODOs below.
 */
public class GenericSwap {

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <T> T[] reverse(T[] array) {
        int end = array.length-1;
        int start = 0;
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
        return array;
    }

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5};
        swap(numbers, 0, 4);
        System.out.println(Arrays.toString(numbers));

        String[] letters = {"A", "B", "C", "D"};
        swap(letters, 1, 2);
        System.out.println(Arrays.toString(letters));

        System.out.println(Arrays.toString(reverse(numbers)));
        System.out.println(Arrays.toString(reverse(letters)));

    }
}
