package com.amigoscode._3_oop._2_inheritance;

/**
 * Exercise: Inheritance - Subclass
 *
 * Create a Dog class that extends Animal. Practice using super()
 * to call the parent constructor, overriding methods, and adding
 * behavior specific to the subclass.
 *
 * Key concepts:
 * - Extending a parent class
 * - Calling super() in the constructor
 * - Overriding methods with @Override
 * - Adding subclass-specific fields and methods
 */

public class Dog extends Animal{

    private String breed;

    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("%s says: Woof! Woof".formatted(this.name));
    }

    public void fetch(String item) {
        System.out.println("%s fetches the %s".formatted(this.name, item));
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
         Dog dog = new Dog("Buddy", 3, "Golden Retriever");
         System.out.println(dog);
         dog.makeSound();
         dog.eat("kibble");       // inherited from Animal
         dog.fetch("tennis ball"); // specific to Dog

         // Polymorphism: a Dog IS-AN Animal
         Animal animal = new Dog("Rex", 5, "German Shepherd");
         animal.makeSound(); // calls Dog's overridden version
    }
}
