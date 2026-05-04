package com.amigoscode._2_developers._9_userinput;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * User Input Exercises
 *
 * Practice reading and validating user input using java.util.Scanner.
 * Always validate user input — never trust it blindly!
 */
public class UserInputExercises {

    /**
     * Reads a single line of text from the user and returns it.
     *
     * @param scanner the Scanner to read from
     * @return the line entered by the user
     */
    public static String readString(Scanner scanner) {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    /**
     * Reads an integer from the user with validation.
     * If the user enters something that is not an integer, catches the exception
     * and returns -1.
     *
     * @param scanner the Scanner to read from
     * @return the integer entered, or -1 if input was invalid
     */
    public static int readIntSafely(Scanner scanner) {
        System.out.print("Enter a number: ");
        int result = -1;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input!");
        } finally {
            scanner.nextLine();
        }
        return result;
    }

    /**
     * Reads strings from the user in a loop until they type "quit".
     * Prints each entered string back to them.
     *
     * @param scanner the Scanner to read from
     */
    public static void readUntilQuit(Scanner scanner) {

        while (true) {
            System.out.print("Enter text (or 'quit' to stop): ");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            System.out.println("You entered: %s".formatted(input));
        }

    }

    /**
     * Validates that an age is between 0 and 150 (inclusive).
     *
     * @param age the age to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 150;
    }

    /**
     * Validates that an email address contains an "@" symbol.
     *
     * @param email the email to validate
     * @return true if valid (contains @), false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    /**
     * Runs a simple registration form that collects name, age, and email.
     * Validates each input and keeps asking until valid data is provided.
     *
     * @param scanner the Scanner to read from
     */
    public static void registrationForm(Scanner scanner) {

        String name = "";
        int age = 0;
        String email = "";
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            if (!name.isEmpty()) break;
        }

        while (true) {
            System.out.print("Enter your age: ");
            try {
                age = scanner.nextInt();
            } catch (InputMismatchException e) {
                age = -1;
            } finally {
                scanner.nextLine();
            }
            if (isValidAge(age)) break;
        }

        while (true) {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) break;
        }

        System.out.println("""
                Registration complete!
                Name: %s, Age: %d, Email: %s
                """.formatted(name,
                age,
                email));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Read String ===");
        String name = readString(scanner);
        System.out.println("Hello, " + name + "!");

        System.out.println("\n=== Read Int Safely ===");
        int number = readIntSafely(scanner);
        System.out.println("You entered: " + number);

        System.out.println("\n=== Read Until Quit ===");
        readUntilQuit(scanner);

        System.out.println("\n=== Validation ===");
        System.out.println("Age 25 valid? " + isValidAge(25));
        System.out.println("Age -5 valid? " + isValidAge(-5));
        System.out.println("Email 'test@mail.com' valid? " + isValidEmail("test@mail.com"));
        System.out.println("Email 'invalid' valid? " + isValidEmail("invalid"));

        System.out.println("\n=== Registration Form ===");
        registrationForm(scanner);

        scanner.close();
    }
}
