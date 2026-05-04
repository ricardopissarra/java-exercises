package com.amigoscode._2_developers._4_accessmodifiers;

/**
 * Access Modifiers Exercises
 *
 * Practice declaring fields and methods with private, public, protected,
 * and package-private (default) access levels. Implement getters/setters
 * and demonstrate encapsulation.
 */
public class AccessModifiers {

    private String secret;

    public String publicGreeting() {
        return "Hello from a public method!";
    }

    protected String protectedGreeting() {
        return "Hello from a protected method!";
    }

    String packageGreeting() {
        return "Hello from a package-private method!";
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String demonstrateInternalAccess() {
        this.secret = "Internal access works!";

        return getSecret() + "\n" +
                publicGreeting() + "\n" +
                protectedGreeting() + "\n" +
                packageGreeting();
    }

}
