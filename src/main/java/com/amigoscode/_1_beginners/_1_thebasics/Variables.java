package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Variables and Data Types
 *
 * Learn how to declare and use variables of different types in Java.
 * Java is a statically-typed language, meaning every variable must have a declared type.
 */
public class Variables {

    public static void main(String[] args) {

        int age = 25;

        double price = 9.99;

        boolean isJavaFun = true;

        String name = "Ricardo";

        char grade = 'A';

        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Is java fun?: " + isJavaFun);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);


        final int MAX_SCORE = 100;
        System.out.println(MAX_SCORE);
    }
}
