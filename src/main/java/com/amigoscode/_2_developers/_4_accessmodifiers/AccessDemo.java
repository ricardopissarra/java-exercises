package com.amigoscode._2_developers._4_accessmodifiers;

/**
 * Access Modifiers Demo
 *
 * Demonstrates how different access modifiers behave when accessing members
 * from another class in the SAME package. Complete the AccessModifiers class first.
 */
public class AccessDemo {

    public static void main(String[] args) {
        AccessModifiers instance = new AccessModifiers();

        System.out.println("=== Calling Public Method ===");
        System.out.println(instance.publicGreeting());

        System.out.println("\n=== Calling Package-Private Method ===");
        System.out.println(instance.packageGreeting());

        System.out.println("\n=== Accessing Private Field Through Getter ===");
        instance.setSecret("supersecret");
        System.out.println(instance.getSecret());

        System.out.println("\n=== Why Direct Private Access Won't Work ===");
        //  // instance.secret = "trying direct access";
        //  secret is private and it is only accessible from within the class that is belongs

        System.out.println(instance.demonstrateInternalAccess());
    }
}
