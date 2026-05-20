package com.amigoscode._3_oop._2_inheritance;

/**
 * Exercise: Inheritance - Base Class
 *
 * Create a base Animal class that will serve as the parent for
 * specific animal types. This class defines common behavior
 * shared by all animals.
 *
 * Key concepts:
 * - Defining a base class with shared fields and behavior
 * - Protected vs private fields for inheritance
 * - Methods that subclasses can override
 */
public class Animal {

    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    public void eat(String food) {
        System.out.println("%s is eating %s".formatted(this.name, food));
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
         Animal animal = new Animal("Generic", 5);
         System.out.println(animal);
         animal.makeSound();
         animal.eat("food");
    }
}
