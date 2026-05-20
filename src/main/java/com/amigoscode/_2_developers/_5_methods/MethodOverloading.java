package com.amigoscode._2_developers._5_methods;

/**
 * Method Overloading Exercises
 *
 * Practice creating overloaded methods — multiple methods with the same name
 * but different parameter lists. Java determines which version to call based
 * on the arguments you pass.
 */
public class MethodOverloading {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b +c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String format(String value) {
        return "[%s]".formatted(value);
    }

    public String format(int value) {
        return String.format("%05d", value);
    }

    public String format(String label, int value) {
        return String.format("%s: %d", label, value);
    }


    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();

        System.out.println("Calling method add with two int arguments");
        System.out.println(mo.add(2, 3));
        System.out.println("Calling method add with three int arguments");
        System.out.println(mo.add(1, 2, 3));
        System.out.println("Calling method add with two double arguments");
        System.out.println(mo.add(1.5, 2.5));
        System.out.println("Calling method format with a String argument");
        System.out.println(mo.format("hello"));
        System.out.println("Calling method format with an int argument");
        System.out.println(mo.format(42));
        System.out.println("Calling method format with a String and an int argument");
        System.out.println(mo.format("Score", 95));

    }
}
