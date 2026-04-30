package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Strings
 *
 * Learn how to work with Strings in Java.
 * Strings are objects that represent sequences of characters and come with
 * many useful built-in methods.
 */
public class StringExercises {

    public static void main(String[] args) {

        String message = "Hello, Welcome to Amigoscode!";
        String padded = "   Hello World   ";
        String csv = "apple,banana,cherry,date,elderberry";

        // TODO: 1 - Get the length of the 'message' string and print it
        System.out.println(message.length());


        // TODO: 2 - Convert 'message' to uppercase and lowercase, and print both
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());


        // TODO: 3 - Get a substring of 'message' containing the first 5 characters and print it
        System.out.println(message.substring(0, 5));


        // TODO: 4 - Check if 'message' contains the word "Amigoscode" and print the result
        System.out.println("Does message contain 'Amigoscode'? " + message.contains("Amigoscode"));


        // TODO: 5 - Replace "Amigoscode" with "Java" in 'message' and print the new string
        System.out.println(message.replace("Amigoscode", "Java"));


        // TODO: 6 - Trim the whitespace from the 'padded' string and print the result
        System.out.println(padded.trim());


        // TODO: 7 - Split the 'csv' string by commas into a String array and print each element
        String[] strings = csv.split(",");
        for (String s : strings) {
            System.out.println(s);
        }


        // TODO: 8 - Check if two strings are equal using .equals() (not ==)
        // Create two String variables with the same text content and compare them.
        // Print the result of .equals() and explain why == may not work for Strings.
        String s1 = "amigoscode";
        String s2 = "amigoscode";
        System.out.println(s1.equals(s2));
        /** you should use equals for equality while working with strings because two string may have the
        * same value but reference different objects in the string pool
         */
    }
}
