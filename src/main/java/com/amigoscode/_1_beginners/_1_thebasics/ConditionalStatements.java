package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Conditional Statements
 *
 * Learn how to control the flow of your program using if/else and switch statements.
 * Conditional statements allow your program to make decisions based on conditions.
 */
public class ConditionalStatements {

    public static void main(String[] args) {


        int number = 7;
        if (number > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Not Positive");
        }

        number = 0;
        if (number > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Not Positive");
        }


        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }


        int day = 3;
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Invalid value");
        }


        String month = "February";
        switch (month) {
            case "January" -> System.out.println(31);
            case "February" -> System.out.println(28);
            case "March" -> System.out.println(31);
            case "April" -> System.out.println(30);
            default -> System.out.println("Not a valid month!");
        }


        int day2 = 3;
        String dayName = switch (day2) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid value";
        };

        System.out.println(dayName);


        int value = 8;
        if (value > 0) {
            if (value % 2 == 0) {
                System.out.println("Positive and even");
            } else {
                System.out.println("Positive and odd");
            }
        } else {
            System.out.println("Not Positive");
        }
    }
}
