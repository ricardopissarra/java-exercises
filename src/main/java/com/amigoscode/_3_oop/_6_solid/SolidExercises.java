package com.amigoscode._3_oop._6_solid;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: SOLID Principles
 *
 * Practice all five SOLID principles by refactoring problematic code
 * into clean, well-structured designs.
 *
 * S - Single Responsibility Principle (SRP)
 * O - Open/Closed Principle (OCP)
 * L - Liskov Substitution Principle (LSP)
 * I - Interface Segregation Principle (ISP)
 * D - Dependency Inversion Principle (DIP)
 */
public class SolidExercises {

    // =========================================================================
    // SRP - Single Responsibility Principle
    // "A class should have only one reason to change."
    //
    // PROBLEM: UserManager below does THREE things — validation, persistence,
    // and notification. If any one of these changes, the whole class changes.
    // =========================================================================

    // This is the BROKEN version. Do not modify it — write the fix below.
    static class UserManagerBroken {

        void createUser(String name, String email) {
            // Validates

            // Saves to database
            System.out.println("Saving user " + name + " to database...");
            // Sends welcome email
            System.out.println("Sending welcome email to " + email + "...");
        }
    }

    static class UserValidator {
        public void validate(String name, String email) {
            if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
            if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
        }
    }

    static class UserRepository {
        public void save(String name, String email) {
            System.out.println("Saving user %s to database....".formatted(name));
        }
    }

    static class UserNotifier{
        public void sendWelcome(String email) {
            System.out.println("Sending welcome email to " + email + "...");
        }
    }

    static class UserManager {

        private final UserValidator userValidator;
        private final UserRepository userRepository;
        private final UserNotifier userNotifier;

        UserManager(UserValidator userValidator, UserRepository userRepository, UserNotifier userNotifier) {
            this.userValidator = userValidator;
            this.userRepository = userRepository;
            this.userNotifier = userNotifier;
        }

        void createUser(String name, String email) {
            // Validates
            userValidator.validate(name, email);
            // Saves to database
            userRepository.save(name, email);
            // Sends welcome email
            userNotifier.sendWelcome(email);
        }
    }

    // =========================================================================
    // OCP - Open/Closed Principle
    // "Open for extension, closed for modification."
    //
    // PROBLEM: Adding a new discount type requires modifying the existing
    // calculateDiscount method with another if/else branch.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class DiscountCalculatorBroken {
        double calculateDiscount(String type, double price) {
            if ("SEASONAL".equals(type)) return price * 0.10;
            if ("CLEARANCE".equals(type)) return price * 0.50;
            // To add a new type, you must modify THIS method — violates OCP!
            return 0;
        }
    }

    interface Discount {
        double apply(double price);
    }

    static class SeasonalDiscount implements Discount {

        private static final double DISCOUNT = 0.1;

        @Override
        public double apply(double price) {
            return price * (1 - DISCOUNT);
        }
    }

    static class ClearanceDiscount implements Discount {

        private static final double DISCOUNT = 0.5;

        @Override
        public double apply(double price) {
            return price * (1 - DISCOUNT);
        }
    }

    static class DiscountCalculator {
        public double calculate(Discount discount, double price) {
            return discount.apply(price);
        }
    }


    // =========================================================================
    // LSP - Liskov Substitution Principle
    // "Subtypes must be substitutable for their base types."
    //
    // PROBLEM: MutableSquare extends MutableRectangle but breaks the contract.
    // Setting width on a square also changes height, which surprises code
    // that expects normal rectangle behavior.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class MutableRectangleBroken {
        protected int width;
        protected int height;
        void setWidth(int w) { this.width = w; }
        void setHeight(int h) { this.height = h; }
        int area() { return width * height; }
    }

    static class MutableSquareBroken extends MutableRectangleBroken {
        @Override void setWidth(int w) { this.width = w; this.height = w; }
        @Override void setHeight(int h) { this.width = h; this.height = h; }
        // BUG: rect.setWidth(5); rect.setHeight(3); rect.area() -> 9, not 15!
    }

    interface LspShape {
        int area();
    }

    static class ImmutableRectangle implements LspShape {
        private final int width;
        private final int height;

        ImmutableRectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int area() {
            return width * height;
        }
    }

    static class ImmutableSquare implements LspShape {
        private final int side;

        ImmutableSquare(int side) {
            this.side = side;
        }

        @Override
        public int area() {
            return side * side;
        }
    }
    // =========================================================================
    // ISP - Interface Segregation Principle
    // "No client should be forced to depend on methods it does not use."
    //
    // PROBLEM: Robot is forced to implement eat() and sleep() even though
    // robots don't eat or sleep.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    interface WorkerBroken {
        void work();
        void eat();
        void sleep();
    }

    static class HumanWorkerBroken implements WorkerBroken {
        public void work()  { System.out.println("Human working"); }
        public void eat()   { System.out.println("Human eating"); }
        public void sleep() { System.out.println("Human sleeping"); }
    }

    static class RobotWorkerBroken implements WorkerBroken {
        public void work()  { System.out.println("Robot working"); }
        public void eat()   { /* Robots don't eat — forced to implement! */ }
        public void sleep() { /* Robots don't sleep — forced to implement! */ }
    }

    interface Workable {
        void work();
    }

    interface Eatable {
        void eat();
    }

    interface Sleepable {
        void sleep();
    }

    static class HumanWorker implements Workable, Eatable, Sleepable {

        @Override
        public void eat() {
            System.out.println("Human eating");
        }

        @Override
        public void sleep() {
            System.out.println("Human sleeping");
        }

        @Override
        public void work() {
            System.out.println("Human working");
        }
    }

    static class RobotWorker implements Workable {

        @Override
        public void work() {
            System.out.println("Robot working");
        }
    }

    // =========================================================================
    // DIP - Dependency Inversion Principle
    // "Depend on abstractions, not on concretions."
    //
    // PROBLEM: ReportGenerator directly creates MySQLDatabase inside itself.
    // It is tightly coupled to MySQL and cannot work with any other database.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class MySQLDatabaseBroken {
        String query(String sql) {
            return "MySQL result for: " + sql;
        }
    }

    static class ReportGeneratorBroken {
        private MySQLDatabaseBroken database = new MySQLDatabaseBroken(); // tight coupling!
        String generateReport() {
            return database.query("SELECT * FROM reports");
        }
    }

    interface Database {
        String query(String sql);
    }

    static class MySQLDatabase implements Database {

        @Override
        public String query(String sql) {
            return "MySQL result for: " + sql;
        }
    }

    static class PostgreSQLDatabase implements Database {

        @Override
        public String query(String sql) {
            return "PostgreSQL result for: " + sql;
        }
    }

    static class ReportGenerator {
        private final Database database;

        ReportGenerator(Database database) {
            this.database = database;
        }

        String generateReport() {
            return database.query("SELECT * FROM reports");
        }
    }

    // =========================================================================
    // Main method to test all exercises
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("=== SOLID Exercises ===\n");

        UserValidator userValidator = new UserValidator();
        UserRepository userRepository = new UserRepository();
        UserNotifier userNotifier = new UserNotifier();
        UserManager um = new UserManager(userValidator, userRepository, userNotifier);
        um.createUser("Alice", "alice@test.com");

        Discount discount1 = new SeasonalDiscount();
        Discount discount2 = new ClearanceDiscount();
        DiscountCalculator dc = new DiscountCalculator();
        System.out.println(dc.calculate(discount1, 100.0));
        System.out.println(dc.calculate(discount2, 100.0));

        Database mysql = new MySQLDatabase();
        Database psql = new PostgreSQLDatabase();

        ReportGenerator rgm = new ReportGenerator(mysql);
        ReportGenerator rgp = new ReportGenerator(psql);

        System.out.println(rgm.generateReport());
        System.out.println(rgp.generateReport());
    }
}
