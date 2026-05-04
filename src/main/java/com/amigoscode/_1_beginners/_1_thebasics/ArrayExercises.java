package com.amigoscode._1_beginners._1_thebasics;


/**
 * Exercise: Arrays
 *
 * Learn how to declare, initialize, and work with arrays in Java.
 * Arrays are fixed-size containers that hold elements of the same type.
 */
public class ArrayExercises {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length-1]);


        numbers[2] = 50;

        System.out.println(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        for (int num : numbers) {
            System.out.println(num);
        }


        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
    }
}
