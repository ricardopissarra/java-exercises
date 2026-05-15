package com.amigoscode._5_generics._2_typeparameters;

/**
 * Exercise: Type Parameter Basics
 *
 * This exercise introduces generic type parameters.
 * You will create a simple generic Container class that can hold
 * any type of object while maintaining type safety.
 *
 * Complete the TODOs below to build and test your generic Container.
 */
public class TypeParameterBasics {


    static class Container<T> {
        private T value;

        public Container(T t) {
            this.value = t;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Container{value=" + value + "}";
        }
    }


    public static void main(String[] args) {

        Container<String> stringContainer = new Container<>("Java Generics");
        Container<Integer> integerContainer = new Container<>(2026);
        System.out.println(stringContainer);
        System.out.println(integerContainer);
        /*
           stringContainer.setValue(123);
            The compiler rejects this set, because stringContainer can only take Strings
         */
        stringContainer.setValue("Valid String");
        System.out.println(stringContainer);

    }
}
