package com.amigoscode._3_oop._1_encapsulation;

/**
 * Exercise: Immutability
 *
 * Learn how to create an immutable class — an object whose state cannot
 * be changed after creation. Immutable objects are thread-safe and
 * easier to reason about.
 *
 * Key concepts:
 * - Private final fields
 * - No setters
 * - "with" methods that return new instances instead of modifying state
 * - Defensive copying (when applicable)
 */
public final class ImmutablePerson {

    private final String name;
    private final int age;
    private final String email;

    public ImmutablePerson(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }


    public ImmutablePerson withName(String newName) {
        return new ImmutablePerson(newName, getAge(), getEmail());
    }

    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(getName(), newAge, getEmail());
    }


    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
         ImmutablePerson person = new ImmutablePerson("Alice", 30, "alice@example.com");
         System.out.println(person);

         // withName returns a NEW object — original is unchanged
         ImmutablePerson renamed = person.withName("Bob");
         System.out.println("Original: " + person);
         System.out.println("Renamed:  " + renamed);

         // withAge returns a NEW object — original is unchanged
         ImmutablePerson aged = person.withAge(31);
         System.out.println("Original: " + person);
         System.out.println("Aged:     " + aged);
    }
}
