package com.amigoscode._3_oop._2_inheritance;

/**
 * Exercise: Inheritance - Vehicle Base Class
 *
 * Create a Vehicle base class representing any type of vehicle.
 * This will be extended by ElectricCar to demonstrate how
 * inheritance lets you build specialized types on top of
 * general ones.
 *
 * Key concepts:
 * - Defining reusable base class fields and behavior
 * - Methods designed to be overridden by subclasses
 */
public class Vehicle {

    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("%s %s engine is starting... Vroom!".formatted(this.make, this.model));
    }

    public String getInfo() {
        return String.format("%d %s %s", this.year, this.make, this.model);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
         Vehicle vehicle = new Vehicle("Toyota", "Camry", 2024);
         System.out.println(vehicle);
         vehicle.start();
         System.out.println(vehicle.getInfo());
    }
}
