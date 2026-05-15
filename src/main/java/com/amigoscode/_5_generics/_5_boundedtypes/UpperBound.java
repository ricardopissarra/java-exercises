package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Type Parameters
 *
 * This exercise demonstrates bounded type parameters using "extends".
 * When you write <T extends Number>, T can only be Number or its subclasses
 * (Integer, Double, Long, etc.). This lets you call Number methods like
 * doubleValue() on values of type T.
 *
 * Complete the TODOs below.
 */
public class UpperBound {

    static <T extends Number> double sum(List<T> list) {
        double sum = 0;
        for (T t : list) {
            sum += t.doubleValue();
        }
        return sum;
    }


    static <T extends Number> T findMax(List<T> list) {
        if (list.isEmpty()) return null;
        T result = null;
        double tempMax = Double.MIN_VALUE;
        for (T t : list) {
            if (Double.compare(t.doubleValue(), tempMax) > 0) {
                result = t;
            }
        }
        return result;
    }

    static class NumberBox<T extends Number> {
        private T number;

        public NumberBox(T number) {
            this.number = number;
        }

        public boolean isPositive() {
            return number.doubleValue() > 0;
        }

        public int toInt() {
            return number.intValue();
        }

        public double toDouble() {
            return number.doubleValue();
        }
    }


    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
        System.out.println(sum(intList));
        System.out.println(sum(doubleList));
        System.out.println(findMax(intList));
        System.out.println(findMax(doubleList));
        //  Print the results for each.
        //  Also create a NumberBox<Integer> and NumberBox<Double> and test
        //  isPositive(), toInt(), and toDouble().

        NumberBox<Integer> integerNumberBox = new NumberBox<>(10);
        NumberBox<Double> doubleNumberBox = new NumberBox<>(-10.0);
        System.out.println(integerNumberBox.isPositive());
        System.out.println(integerNumberBox.toInt());
        System.out.println(integerNumberBox.toDouble());
        System.out.println(doubleNumberBox.isPositive());
        System.out.println(doubleNumberBox.toInt());
        System.out.println(doubleNumberBox.toDouble());
        /*
         List<String> strings = Arrays.asList("a", "b");
         double result = sum(strings);  // Why does this not compile?
            Because string does not extend Number
         */

    }
}
