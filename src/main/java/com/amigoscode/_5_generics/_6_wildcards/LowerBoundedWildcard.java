package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Lower Bounded Wildcards (? super T)
 *
 * A lower bounded wildcard <? super Integer> accepts Integer and all its
 * supertypes (Number, Object). This is useful when you want to WRITE to
 * a generic structure.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list CONSUMES values (you write to it), use "super".
 *
 * Complete the TODOs below.
 */
public class LowerBoundedWildcard {


    static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    static <T> void moveElements(List<? extends T> source, List<? super T> destination) {
        for (T t : source) {
            destination.add(t);
        }
    }

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        addNumbers(integerList);
        addNumbers(numbers);
        addNumbers(objects);
        System.out.println(integerList);
        System.out.println(numbers);
        System.out.println(objects);

       /*
        // Why doesn't this compile even though list holds Numbers?
        List<? super Integer> list = new ArrayList<Number>();
        list.add(3.15);
        Because Double is not and Integer or super class of integer
        */

        moveElements(integerList, numbers);
        System.out.println(numbers);

    }
}
