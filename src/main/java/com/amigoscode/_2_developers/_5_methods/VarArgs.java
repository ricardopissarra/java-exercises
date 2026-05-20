package com.amigoscode._2_developers._5_methods;

import java.util.Arrays;

/**
 * Variable Arguments (Varargs) Exercises
 *
 * Practice using the varargs syntax (Type... name) which allows methods to accept
 * zero or more arguments of the same type. Internally, varargs are treated as arrays.
 */
public class VarArgs {

    public int sum(int... numbers) {
        if (numbers.length == 0) return 0;
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public String concatenate(String... strings) {
        if (strings.length == 0) return "";
        return String.join(" ", strings);
    }

    public int findMax(int... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("At least one number required");
        int max = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public void printAll(Object... items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(String.format("[%d] %s", i , items[i]));
        }
    }

    public String format(String prefix, int... numbers) {
       return String.format("%s: %s", prefix, Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        VarArgs va = new VarArgs();

        System.out.println("=== Sum ===");
        System.out.println(va.sum());
        System.out.println(va.sum(5));
        System.out.println(va.sum(1, 2, 3, 4));


        System.out.println("\n=== Concatenate ===");
        System.out.println(va.concatenate("Java", "is", "awesome"));
        System.out.println(va.concatenate());

        System.out.println("\n=== Find Max ===");
        System.out.println(va.findMax(3, 7, 2, 9, 1));

        System.out.println("\n=== Print All ===");
        va.printAll("Hello", 42, true, 3.14);

        System.out.println("\n=== Mixed Params ===");
        System.out.println(va.format("Values", 1, 2, 3, 4));
        System.out.println(va.format("Values", 1));

    }


}
