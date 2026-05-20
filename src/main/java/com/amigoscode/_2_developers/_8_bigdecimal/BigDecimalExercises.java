package com.amigoscode._2_developers._8_bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal Exercises
 *
 * Practice using BigDecimal for precise decimal arithmetic. BigDecimal avoids
 * the floating-point rounding errors that plague double and float. Essential
 * for financial calculations.
 */
public class BigDecimalExercises {

    /**
     * Creates a BigDecimal from a String representation.
     * IMPORTANT: Always use the String constructor, not the double constructor!
     *
     * @param value the decimal value as a string (e.g., "19.99")
     * @return a BigDecimal representing the value
     */
    public static BigDecimal createFromString(String value) {
        return new BigDecimal(value);
    }

    /**
     * Adds two BigDecimal values.
     *
     * @param a first value
     * @param b second value
     * @return the sum
     */
    public static BigDecimal addValues(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    /**
     * Multiplies two BigDecimal values.
     *
     * @param a first value
     * @param b second value
     * @return the product
     */
    public static BigDecimal multiplyValues(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    /**
     * Divides a by b with the specified scale (decimal places) and HALF_UP rounding.
     *
     * @param a     the dividend
     * @param b     the divisor
     * @param scale the number of decimal places
     * @return the quotient rounded to the specified scale
     */
    public static BigDecimal divideValues(BigDecimal a, BigDecimal b, int scale) {
        return a.divide(b, scale,RoundingMode.HALF_UP);
    }

    /**
     * Compares two BigDecimal values.
     * IMPORTANT: Use compareTo(), not equals()!
     * BigDecimal.equals() considers scale, so new BigDecimal("2.0").equals(new BigDecimal("2.00"))
     * returns false! compareTo() compares numeric value only.
     *
     * @param a first value
     * @param b second value
     * @return -1 if a < b, 0 if equal, 1 if a > b
     */
    public static int compareValues(BigDecimal a, BigDecimal b) {
        return a.compareTo(b);
    }

    /**
     * Demonstrates why new BigDecimal(double) is problematic.
     * Prints the difference between BigDecimal created from double vs String.
     */
    public static void demonstrateDoubleProblem() {
        BigDecimal fromDouble = new BigDecimal(0.1);
        BigDecimal fromString = new BigDecimal("0.1");
        System.out.println("fromDouble: " + fromDouble);
        System.out.println("fromString: " + fromString);
        //  Print a message explaining why the String constructor should be preferred.
        System.out.println("""
                The String constructor should be preferred, because in Java and many other languages,
                when working with doubles can not accurately represent the base 10 multiples we use for 'money'
                (problems with precision)
                """);
    }

    public static void main(String[] args) {
        System.out.println("=== Create from String ===");
        BigDecimal price = createFromString("19.99");
        System.out.println("Price: " + price);

        System.out.println("\n=== Addition ===");
        BigDecimal a = new BigDecimal("10.50");
        BigDecimal b = new BigDecimal("3.75");
        System.out.println("10.50 + 3.75 = " + addValues(a, b));

        System.out.println("\n=== Multiplication ===");
        BigDecimal quantity = new BigDecimal("3");
        System.out.println("19.99 * 3 = " + multiplyValues(price, quantity));

        System.out.println("\n=== Division with Rounding ===");
        BigDecimal ten = new BigDecimal("10");
        BigDecimal three = new BigDecimal("3");
        System.out.println("10 / 3 (2 decimals): " + divideValues(ten, three, 2));
        System.out.println("10 / 3 (5 decimals): " + divideValues(ten, three, 5));

        System.out.println("\n=== Comparison ===");
        BigDecimal val1 = new BigDecimal("2.0");
        BigDecimal val2 = new BigDecimal("2.00");
        System.out.println("2.0 compareTo 2.00: " + compareValues(val1, val2));
        System.out.println("2.0 equals 2.00: " + val1.equals(val2) + " (WRONG way to compare!)");

        System.out.println("\n=== Double Problem ===");
        demonstrateDoubleProblem();
    }
}
