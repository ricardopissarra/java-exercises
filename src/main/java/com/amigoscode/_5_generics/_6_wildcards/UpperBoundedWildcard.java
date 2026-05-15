package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Wildcards (? extends T)
 *
 * An upper bounded wildcard <? extends Number> accepts Number and all its
 * subclasses. This is useful when you want to READ from a generic structure
 * but do not need to WRITE to it.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list PRODUCES values (you read from it), use "extends".
 *
 * Complete the TODOs below.
 */
public class UpperBoundedWildcard {

    static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    static void copyToNumberList(List<? extends Number> source, List<Number> destination) {
        for (Number number : source) {
            destination.add(number);
        }
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        List<Long> longs = Arrays.asList(100L, 200L, 300L);
        System.out.println(sumOfList(integers));
        System.out.println(sumOfList(doubles));
        System.out.println(sumOfList(longs));

         List<? extends Number> numbers = new ArrayList<Integer>();
         /*
                    numbers.add(1);       // Why doesn't this compile?
                    numbers.add(1.0);     // Why doesn't this compile?
                    The compiler doesn't know the actual type. The list could be
                    List<Integer>, List<Double>, or any other Number subclass.
          */



        List<Number> numbers1 = new ArrayList<>();
        copyToNumberList(integers, numbers1);
        System.out.println(numbers1);


    }
}
