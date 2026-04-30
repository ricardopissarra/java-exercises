package com.amigoscode._1_beginners._1_thebasics;

import java.util.Arrays;

/**
 * Exercise: Arrays
 *
 * Learn how to declare, initialize, and work with arrays in Java.
 * Arrays are fixed-size containers that hold elements of the same type.
 */
public class ArrayExercises {

    public static void main(String[] args) {

        // TODO: 1 - Declare and initialize an int array called 'numbers' with 5 values
        int[] numbers = {1, 2, 3, 4, 5};

        // TODO: 2 - Access and print the first and last elements of the array
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length-1]);


        // TODO: 3 - Change the value of the third element (index 2) to 99 and print it
        numbers[2] = 50;

        // TODO: 4 - Get the length of the array and print it
        System.out.println(numbers.length);

        // TODO: 5 - Loop through the array using a standard for loop and print each element
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // TODO: 6 - Loop through the array using an enhanced for loop (for-each) and print each element
        for (int num : numbers) {
            System.out.println(num);
        }


        // TODO: 7 - Find the sum of all elements in the array and print it
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
    }
}
