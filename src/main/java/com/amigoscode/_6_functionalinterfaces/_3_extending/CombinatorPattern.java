package com.amigoscode._6_functionalinterfaces._3_extending;

import java.util.function.Function;

/**
 * Exercise: Combinator Pattern
 *
 * The Combinator Pattern uses functional interfaces to build complex validation
 * logic by combining small, reusable validation functions. Each validator is a
 * function that takes an object and returns a validation result. Validators can
 * be chained using an and() method to create comprehensive validation pipelines.
 *
 * This pattern is powerful because:
 *   - Each validator is a simple, testable unit
 *   - Validators are composable (combine them freely)
 *   - New validators can be added without modifying existing code
 */
public class CombinatorPattern {

    enum ValidationResult {
        SUCCESS, EMAIL_NOT_VALID, NOT_ADULT, NAME_EMPTY
    }

    record Customer(String name, String email, int age) {}

    @FunctionalInterface
    interface CustomerValidator extends Function<Customer, ValidationResult> {

        static CustomerValidator isEmailValid() {
            return customer -> customer.email().contains("@")
                      ? ValidationResult.SUCCESS
                      : ValidationResult.EMAIL_NOT_VALID;
        }

        static CustomerValidator isAdult() {
            return customer -> customer.age() >= 18
                    ? ValidationResult.SUCCESS
                    : ValidationResult.NOT_ADULT;
        }

        static CustomerValidator isNameNotEmpty() {
            return customer -> customer.name != null && !customer.name.isEmpty()
                    ? ValidationResult.SUCCESS
                    : ValidationResult.NAME_EMPTY;
        }

        default CustomerValidator and(CustomerValidator validator) {
            return customer -> {
                ValidationResult result = this.apply(customer);

                return result.equals(ValidationResult.SUCCESS) ? validator.apply(customer) : result;
            };
        }
    }


    public static void main(String[] args) {

          CustomerValidator fullValidator = CustomerValidator.isEmailValid()
              .and(CustomerValidator.isAdult())
              .and(CustomerValidator.isNameNotEmpty());

          Customer customer = new Customer("Alice", "alice@example.com", 25);
          Customer customer2 = new Customer("Bob", "bob-no-email", 30);
          Customer customer3 = new Customer("", "young@email.com", 16) ;
          Customer customer4 = new Customer("", "valid@email.com", 25);
        System.out.println(fullValidator.apply(customer));
        System.out.println(fullValidator.apply(customer2));
        System.out.println(fullValidator.apply(customer3));
        System.out.println(fullValidator.apply(customer4));

    }
}
