package com.amigoscode._6_functionalinterfaces._4_callbacks;

import java.util.function.Consumer;

/**
 * Exercise: Callbacks with Functional Interfaces
 *
 * Callbacks are functions passed as arguments to other functions, to be called
 * at a later time (e.g., on success or failure). In Java, functional interfaces
 * like Consumer and Runnable make excellent callback types.
 *
 * This exercise simulates asynchronous-style programming patterns using
 * callbacks for success/failure handling and task completion notification.
 */
public class CallbackExercise {

    public static void main(String[] args) {

        fetchData(
                true,
                s -> System.out.println("Data received: %s".formatted(s)),
                s -> System.out.println("Error occurred: %s".formatted(s))
         );
        fetchData(
                false,
                s -> System.out.println("Data received: %s".formatted(s)),
                s -> System.out.println("Error occurred: %s".formatted(s))
         );

        processAsync(
                () -> System.out.println("Processing data..."),
                () -> System.out.println("Processing complete!")
                );

        performSteps(
                () -> System.out.println("Step 1: Loading"),
                () -> System.out.println("Step 2: Transforming"),
                () -> System.out.println("Step 3: Saving")
        );

    }

    static void fetchData(boolean simulatesSuccess, Consumer<String> onSuccess, Consumer<String> onFailure) {
        System.out.println("Fetching data...");
        if(simulatesSuccess) {
            onSuccess.accept("{ \"id\": 1, \"name\": \"Alice\" }");
        } else {
            onFailure.accept("Connection timed out");
        }
    }

    static void processAsync(Runnable task, Runnable onComplete) {
        System.out.println("Starting process");
        task.run();
        onComplete.run();
        System.out.println("Done.");
    }


    /**
     * Executes three steps in sequence using Runnable callbacks.
     */
    static void performSteps(Runnable step1, Runnable step2, Runnable step3) {
        System.out.println("=== Beginning multi-step operation ===");
        step1.run();
        step2.run();
        step3.run();
        System.out.println("=== All steps completed ===");
    }
}
