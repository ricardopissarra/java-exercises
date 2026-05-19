package com.amigoscode._6_functionalinterfaces._4_callbacks;

import java.util.*;
import java.util.function.Consumer;

/**
 * Exercise: Event Processor with Functional Interfaces
 *
 * Build a simple event system where listeners (Consumer<String>) can be
 * registered for named events. When an event is emitted, all registered
 * listeners for that event are called with the event data.
 *
 * This pattern is widely used in UI frameworks, message brokers, and
 * reactive programming.
 */
public class EventProcessor {

    static Map<String, List<Consumer<String>>> listeners = new HashMap<>();

    static void addListener(String event, Consumer<String> listener) {
        listeners.computeIfAbsent(event, k -> new ArrayList<>()).add(listener);
    }

    static void emit(String event, String data) {
        List<Consumer<String>> consumers = listeners.getOrDefault(event, Collections.emptyList());
        if (consumers.isEmpty()) {
            System.out.println("No listeners for event: %s".formatted(event));
        } else {
            consumers.forEach(c -> c.accept(data));
        }
    }


    public static void main(String[] args) {

        addListener("onClick", s -> System.out.println("Button clicked! Data: %s".formatted(s)));
        addListener("onClick", s -> System.out.println("Logging click event: %s".formatted(s)));
        addListener("onClick", s -> System.out.println("Analytics: tracking click - %s".formatted(s)));

        addListener("onHover", s -> System.out.println("Hovering over: %s".formatted(s)));


        emit("onClick", "submit-button");
        emit("onClick", "cancel-button");
        emit("onHover", "menu-item");
        emit("onScroll", "page-down");
    }
}
