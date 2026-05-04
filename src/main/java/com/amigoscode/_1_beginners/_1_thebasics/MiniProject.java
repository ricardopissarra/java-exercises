package com.amigoscode._1_beginners._1_thebasics;

import java.util.Scanner;

/**
 * Mini Project: Simple Calculator
 *
 * Put together everything you have learned so far to build a simple calculator.
 * The calculator should display a menu, read the user's choice and two numbers,
 * perform the chosen operation, and print the result.
 */
public class MiniProject {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        System.out.println("""
                === Simple Calculator ===
                1. Add
                2. Subtract
                3. Multiply
                4. Divide
                Choose an operation (1-4): """);


        int choice = in.nextInt();

        System.out.println("Enter first number: ");
        int first = in.nextInt();
        System.out.println("Enter second number: ");
        int second = in.nextInt();


        switch (choice) {
            case 1 -> System.out.println("Result: %d".formatted((first + second)));
            case 2 -> System.out.println("Result: %d".formatted((first - second)));
            case 3 -> System.out.println("Result: %d".formatted((first * second)));
            case 4 -> {
                if (second == 0) {
                    System.out.println("Error: Cannot divide by zero");
                } else {
                    System.out.println("Result: %d".formatted((first / second)));
                }
            }
            default -> System.out.println("Invalid choice");
        }

        in.close();
    }
}
