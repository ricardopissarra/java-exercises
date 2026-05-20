package com.amigoscode._4_datastructures._7_maps;


import java.util.HashMap;
import java.util.Map;

public class HashMapExercises {

    public static void main(String[] args) {

        Map<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("Alice", 92);
        studentGrades.put("Charlie", 78);
        studentGrades.put("Diana", 95);
        studentGrades.put("Eve", 88);


        System.out.println(studentGrades.get("Charlie"));
        System.out.println(studentGrades.containsKey("Bob"));
        System.out.println(studentGrades.containsValue(95));
        studentGrades.remove("Eve");
        System.out.println(studentGrades);

        studentGrades.entrySet().forEach(e -> System.out.println("Student: %s, Grade: %d".formatted(e.getKey(), e.getValue())));


        studentGrades.keySet().forEach(System.out::println);
        studentGrades.values().forEach(System.out::println);

    }
}
