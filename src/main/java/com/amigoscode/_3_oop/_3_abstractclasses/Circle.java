package com.amigoscode._3_oop._3_abstractclasses;

/**
 * Exercise: Abstract Classes - Circle
 *
 * Implement a concrete Circle class that extends the abstract Shape.
 * You must implement all abstract methods declared in Shape.
 *
 * Key concepts:
 * - Extending an abstract class
 * - Implementing abstract methods
 * - Using Math.PI for calculations
 */


public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be positive");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }


    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
         Circle circle = new Circle(5.0);
         System.out.println("Area: " + circle.area());
         System.out.println("Perimeter: " + circle.perimeter());
         circle.describe();   // inherited concrete method from Shape
         System.out.println(circle);
    }
}
