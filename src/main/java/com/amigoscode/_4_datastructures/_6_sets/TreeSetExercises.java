package com.amigoscode._4_datastructures._6_sets;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExercises {

    public static void main(String[] args) {

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(50);
        numbers.add(20);
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(60);
        numbers.add(15);
        numbers.add(45);

        System.out.println(numbers);

        System.out.println(numbers.first());
        System.out.println(numbers.last());

        SortedSet<Integer> subSet = numbers.subSet(20, 45);
        System.out.println(subSet);

        SortedSet<Integer> headSet = numbers.headSet(30);
        SortedSet<Integer> tailSet = numbers.tailSet(30);
        System.out.println(headSet);
        System.out.println(tailSet);

        numbers.forEach(System.out::println);
    }
}
