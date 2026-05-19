package com.amigoscode._6_functionalinterfaces._1_gettingstarted;

/**
 * Exercise: Functional Interface Basics
 *
 * Learn how to define a functional interface, implement it using anonymous classes
 * and lambda expressions, and pass it as a method parameter.
 *
 * A functional interface is an interface with exactly one abstract method.
 * The @FunctionalInterface annotation helps the compiler enforce this rule.
 */
public class FunctionalInterfaceBasics {

    @FunctionalInterface
    interface Greeting {
        void greet(String name);
    }


    public static void main(String[] args) {

        Greeting greeting = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Hello, %s!".formatted(name));
            }
        };

        Greeting greeting1 = (name) -> {System.out.println("Hello, %s!".formatted(name));};

        Greeting greeting2 = name -> System.out.println("Hello, %s!".formatted(name));

        greeting.greet("Alice");
        greeting1.greet("Alice");
        greeting2.greet("Alice");


        printGreeting(greeting2, "Bob");

    }

     /**
      * A helper method that accepts a Greeting functional interface and a name,
      * then invokes greet on the given name.
      */
     static void printGreeting(Greeting greeting, String name) {
         greeting.greet(name);
     }
}
