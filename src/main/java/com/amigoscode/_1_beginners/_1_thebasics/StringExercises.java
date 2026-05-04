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

        System.out.println(message.length());


        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());


        System.out.println(message.substring(0, 5));


        System.out.println("Does message contain 'Amigoscode'? " + message.contains("Amigoscode"));


        System.out.println(message.replace("Amigoscode", "Java"));


        System.out.println(padded.trim());


        String[] strings = csv.split(",");
        for (String s : strings) {
            System.out.println(s);
        }

        String s1 = "amigoscode";
        String s2 = "amigoscode";
        System.out.println(s1.equals(s2));
        /** you should use equals for equality while working with strings because two string may have the
        * same value but reference different objects in the string pool
         */
    }
}
