package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Operators
 *
 * Learn how to use arithmetic, comparison, logical, and other operators in Java.
 * Operators allow you to perform operations on variables and values.
 */
public class Operators {

    public static void main(String[] args) {

        int a = 10;
        int b = 3;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);

        int number = 7;
        System.out.println(number % 2);
        System.out.println(number % 2 == 0 ? "even" : "odd");

        int counter = 5;
        counter++;
        System.out.println(counter);
        counter--;
        System.out.println(counter);

        int score = 10;
        score += score;
        System.out.println(score);
        score -= score;
        System.out.println(score);
        score *= score;
        System.out.println(score);

        int x = 5;
        int y = 10;
        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y: " + (x > y));
        System.out.println("x < y: " + (x < y));
        System.out.println("x <= y: " + (x <= y));
        System.out.println("x >= y: " + (x >= y));


        boolean hasLicense = true;
        boolean hasInsurance = false;
        System.out.println(hasInsurance && hasLicense);
        System.out.println(hasInsurance || hasLicense);
        System.out.println(!hasLicense);


        int age = 21;
        String status = age >= 18 ? "adult" : "minor";
        System.out.println(status);
    }
}
