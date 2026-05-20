package com.amigoscode._2_developers._12_classes;

import java.util.Arrays;

/**
 * Enum Exercises
 *
 * Practice creating and using enums in Java. Enums are special classes that
 * represent a fixed set of constants. They can have fields, constructors,
 * and methods just like regular classes.
 */
public class EnumExercises {

    static enum Season {
        SPRING("Flowers bloom"),
        SUMMER("Sun shines"),
        AUTUM("Leaves fall"),
        WINTER("Snow falls");

        private final String description;

        private Season(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    static enum Priority {
        LOW(1),
        MEDIUM(2),
        HIGH(3);

        private final int level;

        private Priority(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }


    public static void main(String[] args) {
        System.out.println("=== Season Switch ===");
        Season season = Season.SUMMER;
        switch (season) {
            case AUTUM -> System.out.println("%s: %s".formatted(Season.AUTUM, Season.AUTUM.getDescription()));
            case SUMMER -> System.out.println("%s: %s".formatted(Season.SUMMER, Season.SUMMER.getDescription()));
            case SPRING -> System.out.println("%s: %s".formatted(Season.SPRING, Season.SPRING.getDescription()));
            case WINTER -> System.out.println("%s: %s".formatted(Season.WINTER, Season.WINTER.getDescription()));
            default -> System.out.println("Invalid season!");
        }


        System.out.println("\n=== Iterate Over Enum Values ===");
        Arrays.stream(Season.values())
                .forEach(s -> System.out.println("%d: %s - %s".formatted(s.ordinal(), s, s.getDescription())));

        Arrays.stream(Priority.values())
                .forEach(p -> System.out.println("%s, level: %d".formatted(p, p.getLevel())));
    }
}
