package com.amigoscode._4_datastructures._7_maps;


import java.util.TreeMap;

public class TreeMapExercises {

    public static void main(String[] args) {

        TreeMap<String, Double> productPrices = new TreeMap<>();

        productPrices.put("Laptop", 999.99);
        productPrices.put("Phone", 699.99);
        productPrices.put("Tablet", 449.99);
        productPrices.put("Headphone", 149.99);
        productPrices.put("Mouse", 29.99);

        System.out.println(productPrices.firstEntry());
        System.out.println(productPrices.lastKey());

        System.out.println(productPrices.subMap("Laptop", "Phone"));

        productPrices.entrySet().forEach(p -> System.out.println("%s: $%f".formatted(p.getKey(), p.getValue())));
        System.out.println();
        productPrices.descendingMap().forEach((k, v) -> System.out.println("%s: $%f".formatted(k, v)));


    }
}
