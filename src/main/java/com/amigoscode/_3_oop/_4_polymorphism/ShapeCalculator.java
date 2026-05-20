package com.amigoscode._3_oop._4_polymorphism;

import com.amigoscode._3_oop._3_abstractclasses.Circle;
import com.amigoscode._3_oop._3_abstractclasses.Rectangle;
import com.amigoscode._3_oop._3_abstractclasses.Shape;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Exercise: Polymorphism - Shape Calculator
 *
 * Use polymorphism to write methods that work with any Shape.
 * Because Circle and Rectangle both extend Shape, a single method
 * can handle both — and any future Shape subclass — without modification.
 *
 * Key concepts:
 * - Methods that accept a supertype parameter
 * - Polymorphic collections (List<Shape>)
 * - instanceof with pattern matching (Java 16+)
 * - Open/closed principle in practice
 *
 * Prerequisites: Complete Shape.java, Circle.java, and Rectangle.java first.
 */
public class ShapeCalculator {

    public static void printShapeArea(Shape shape) {
        System.out.println("The %s has an area of %.2f".formatted(
                shape.getClass().getSimpleName(),
                shape.area()));
    }

    public static double totalArea(List<Shape> shapes) {
        return shapes.stream()
                .mapToDouble(Shape::area)
                .sum();
    }

    public static Shape largestShape(List<Shape> shapes) {
        if (shapes.isEmpty()) return null;

        return shapes.stream()
                .sorted(Comparator.comparingDouble(Shape::area).reversed())
                .findFirst()
                .get();
    }

    public static String describeShape(Shape shape) {
        if (shape instanceof Circle c) {
            return "Circle detected with area: " + c.area();
        } else if (shape instanceof Rectangle r) {
            return "Rectangle detected with area: " + r.area();
        }
        return "Unknown shape with area: " + shape.area();
    }

    public static String formatSummary(List<Shape> shapes) {
        return "Summary: %d shapes, total area: %.2f, largest area: %.2f".formatted(
                shapes.size(),
                totalArea(shapes),
                largestShape(shapes).area()
        );
    }


    public static void main(String[] args) {
        Shape circle1 = new Circle(10.0);
        Shape circle2 = new Circle(5.0);
        Shape rectangle1 = new Rectangle(10.0, 10.0);
        Shape rectangle2 = new Rectangle(15.0, 10.0);

        List<Shape> shapes = List.of(circle1, circle2, rectangle1, rectangle2);

        printShapeArea(circle1);
        printShapeArea(rectangle1);
        System.out.println("Total area: " + totalArea(shapes));
        System.out.println("Largest shape when empty: " + largestShape(List.of()));
        System.out.println("Largest shape: " + largestShape(shapes));
        describeShape(rectangle1);
        describeShape(circle1);
        System.out.println(formatSummary(shapes));
    }
}
