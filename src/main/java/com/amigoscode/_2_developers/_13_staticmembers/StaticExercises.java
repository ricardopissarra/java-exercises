package com.amigoscode._2_developers._13_staticmembers;

/**
 * Static Members Exercises
 *
 * Practice using static fields, static methods, and understanding the difference
 * between static (class-level) and instance (object-level) members.
 * Static members belong to the class itself, not to any specific instance.
 */
public class StaticExercises {

    private static int counter = 0;

    // An instance field for comparison (already provided)
    private String instanceName;

    public StaticExercises(String name) {
        instanceName = name;
        counter++;
    }

    public static int getCount() {
        return counter;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public String getInfo() {
        return String.format("Instance: %s, Total instances: %d", instanceName, counter);
    }

    public static StaticExercises createDefault() {
        return new StaticExercises("Default");
    }


    public static void main(String[] args) {
         System.out.println("=== Static Counter ===");
         System.out.println("Count before creating instances: " + getCount());

         StaticExercises obj1 = new StaticExercises("First");
         StaticExercises obj2 = new StaticExercises("Second");
         StaticExercises obj3 = new StaticExercises("Third");

         System.out.println("Count after creating 3 instances: " + StaticExercises.getCount());

         System.out.println("\n=== Static Utility Method ===");
         System.out.println("0°C = " + celsiusToFahrenheit(0) + "°F");
         System.out.println("100°C = " + celsiusToFahrenheit(100) + "°F");
         System.out.println("37°C = " + celsiusToFahrenheit(37) + "°F");

         System.out.println("\n=== Static vs Instance ===");
         System.out.println(obj1.getInfo());
         System.out.println(obj2.getInfo());
//         Note: getCount() is called on the class, getInfo() is called on an instance
//         StaticExercises.getCount() works, but StaticExercises.getInfo() does NOT compile

         System.out.println("\n=== Static Factory Method ===");
         StaticExercises defaultObj = StaticExercises.createDefault();
         System.out.println(defaultObj.getInfo());
    }
}
