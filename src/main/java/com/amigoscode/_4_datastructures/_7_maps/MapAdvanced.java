package com.amigoscode._4_datastructures._7_maps;

// Exercise: Advanced Map Operations (Java 8+)
// Learn modern Map methods: getOrDefault, putIfAbsent, computeIfAbsent, merge, replaceAll, and immutable maps.

import java.util.HashMap;
import java.util.Map;

public class MapAdvanced {

    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 78);
        System.out.println("Initial map: " + scores);

        System.out.println(scores.getOrDefault("Diana", 0));
        System.out.println(scores.getOrDefault("Alice", 0));

        scores.putIfAbsent("Bob", 100);
        scores.putIfAbsent("Diana", 92);
        System.out.println(scores);

        scores.computeIfAbsent("Eve", k -> k.length() * 10);
        System.out.println(scores);

        scores.merge("Charlie", 5, Integer::sum);
        scores.merge("Fank", 88, Integer::sum);
        System.out.println(scores);

        scores.replaceAll((k, v) -> v + 10);
        System.out.println(scores);

        Map<String, Integer> immutable = Map.of(
                "Math", 95,
                "English", 92
        );

        System.out.println(immutable);
        /**
            immutable.put("test", 0); throws UnsupportedOperationException
         */

    }
}
