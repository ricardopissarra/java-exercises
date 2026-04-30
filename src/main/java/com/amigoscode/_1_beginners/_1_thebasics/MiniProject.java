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

        // TODO: 1 - Create a Scanner for user input
        Scanner in = new Scanner(System.in);


        // TODO: 2 - Display a menu with the following options:
        System.out.println("""
                === Simple Calculator ===
                1. Add
                2. Subtract
                3. Multiply
                4. Divide
                Choose an operation (1-4):
                """);


        // TODO: 3 - Read the user's choice into an int variable
        int choice = in.nextInt();

        // TODO: 4 - Prompt and read two double numbers from the user
        System.out.println("Enter first number: ");
        int first = in.nextInt();
        System.out.println("Enter second number: ");
        int second = in.nextInt();


        // TODO: 5 - Use a switch statement to perform the chosen operation and print the result
        // TODO: 6 - Inside case 4, handle division by zero with an if statement
        // If the second number is 0, print "Error: Cannot divide by zero"
        // Otherwise, print the result of the division
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
