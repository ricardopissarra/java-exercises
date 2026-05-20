package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Methods
 *
 * Learn how to define and call methods in Java.
 * Methods allow you to organize code into reusable blocks, each performing a specific task.
 */
public class MethodExercises {

    public static void greet(String name) {
        System.out.println("Hello, %s!".formatted(name));
    }


    public static int add(int a, int b) {
        return a + b;
    }


    public static boolean isEven(int num) {
        return num % 2 == 0;
    }


    public static int max(int a, int b) {
        return a > b ? a : b;
    }


    public static long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num ; i++) {
            result *= i;
        }
        return result;
    }


    // Overloading means having multiple methods with the same name but different parameters.
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b + c;
    }


    public static void main(String[] args) {

        // - Call greet with your name
        greet("Ricardo");
        // - Call add with two numbers and print the result
        System.out.println(add(1,2));
        // - Call isEven with a number and print whether it is even
        System.out.println(isEven(3));
        // - Call max with two numbers and print the larger one
        System.out.println(max(1, 2));
        // - Call factorial with 5 and print the result
        System.out.println(factorial(5));
        // - Call both multiply methods and print their results
        System.out.println(multiply(1, 2));
        System.out.println(multiply(1 ,2, 3));

    }
}
