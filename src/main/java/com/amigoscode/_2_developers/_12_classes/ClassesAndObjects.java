package com.amigoscode._2_developers._12_classes;

import java.util.Objects;

/**
 * Classes and Objects Exercises
 *
 * Practice creating classes with fields, constructors, and methods.
 * Learn about constructor chaining, toString(), and equals().
 */
public class ClassesAndObjects {

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
            this("Unknown", 0);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Person person)) return false;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }



    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person();
        Person person3 = new Person("Alice", 30);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person1.equals(person3));
        System.out.println(person1.equals(person2));



        // The constructor chaining using the 'this' keyword is used to reutilize code,
        // avoid duplicate logic. In the static inner class Person I used constructor chaining
        // inside the no args constructor

    }
}
