package com.amigoscode._3_oop._3_abstractclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SplittableRandom;

/**
 * Exercise: Abstract Classes - Employee Hierarchy
 *
 * Build an employee hierarchy using abstract classes. The abstract Employee
 * defines common behavior, while FullTimeEmployee and ContractEmployee
 * provide different pay calculation strategies.
 *
 * Key concepts:
 * - Abstract class with both abstract and concrete methods
 * - Multiple subclasses with different implementations
 * - Polymorphism with a List of the abstract type
 * - Inner classes (classes defined in the same file)
 */

abstract class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();

    public String getDetails() {
        return String.format("%s - Pay: $%.2f", this.name, calculatePay());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return this.baseSalary;
    }
}

class ContractEmployee extends Employee {

    private double hourlyRate;
    private int workedHours;

    public ContractEmployee(String name, double hourlyRate, int workedHours) {
        super(name, 0.0);
        this.hourlyRate = hourlyRate;
        this.workedHours = workedHours;
    }

    @Override
    public double calculatePay() {
        return this.hourlyRate * this.workedHours;
    }
}


// TODO: 6 - In the EmployeeDemo class below, complete the main method:
//   - Create a List<Employee> with at least one FullTimeEmployee
//     and one ContractEmployee
//   - Iterate over the list and print getDetails() for each employee

// TODO: 7 - Add a method in EmployeeDemo: static Employee getHighestPaid(List<Employee> employees)
//   that returns the employee with the highest calculatePay() value.
//   Call it from main and print the result.

class EmployeeDemo {
    public static void main(String[] args) {
        // Complete TODOs 6 and 7 here
        Employee employee1 = new FullTimeEmployee("James", 1200.0);
        Employee employee2 = new FullTimeEmployee("Alex", 900.0);
        Employee employee3 = new ContractEmployee("Jamila", 30.0, 120);
        Employee employee4 = new ContractEmployee("Tom", 24.0, 100);
        List<Employee> employeeList = List.of(employee1, employee2, employee3, employee4);
        employeeList.forEach(
                e -> System.out.println(e.getDetails())
        );

        System.out.println(getHighestPaid(employeeList));
    }

    static Employee getHighestPaid(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::calculatePay).reversed())
                .findFirst()
                .get();
    }
}
