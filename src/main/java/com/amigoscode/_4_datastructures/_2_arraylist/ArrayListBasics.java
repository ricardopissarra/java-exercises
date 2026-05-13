package com.amigoscode._4_datastructures._2_arraylist;

// Exercise: ArrayList Basics
// Learn the fundamental operations of ArrayList - Java's resizable array implementation.

import java.util.ArrayList;
import java.util.List;

public class ArrayListBasics {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");
        names.add("Eve");

        System.out.println(names.get(2));

        System.out.println(names.contains("Bob"));

        names.remove("Diana");
        System.out.println(names);
        System.out.println(names.size());

        for (String name : names) {
            System.out.println("Name: %s".formatted(name));
        }

    }
}
