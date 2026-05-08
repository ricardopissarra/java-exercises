package com.amigoscode._3_oop._3_abstractclasses;

/**
 * Exercise: Abstract Classes - Shape
 *
 * Create an abstract Shape class that defines a contract for all shapes.
 * Abstract classes can have both abstract methods (no body — subclasses
 * must implement) and concrete methods (with a body — shared behavior).
 *
 * Key concepts:
 * - Abstract class declaration
 * - Abstract methods (no implementation)
 * - Concrete methods in abstract classes
 * - Forcing subclasses to provide implementations
 */

public abstract class Shape {

    public abstract double area();

    public abstract double perimeter();

    public void describe() {
        System.out.println("This shape has area: %.2f and perimeter: %.2f".formatted(area(), perimeter()));
    }

    @Override
    public String toString() {
        return "Shape{area=%.2f, perimeter=%.2f}".formatted(area(), perimeter());
    }

}
