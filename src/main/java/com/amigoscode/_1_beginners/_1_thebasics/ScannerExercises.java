package com.amigoscode._1_beginners._1_thebasics;

import java.util.Scanner;

/**
 * Exercise: Scanner (User Input)
 *
 * Learn how to read user input from the console using the Scanner class.
 * Scanner allows your programs to be interactive by accepting input at runtime.
 */
public class ScannerExercises {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Hello, %s! You are %d years old.".formatted(name, age));

        System.out.print("Enter first number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter second number: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Sum: " + (firstNumber + secondNumber));
        // TODO: 6 - Close the scanner to free resources
        scanner.close();

    }
}
