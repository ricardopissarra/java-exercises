package com.amigoscode._4_datastructures._7_maps;


import java.util.*;

public class HashMapWordCount {

    public static void main(String[] args) {

        String sentence = "the cat sat on the mat and the cat ate the rat on the mat";

        // TODO: 1 - Split the sentence into an array of words using split(" ")
        String[] arr = sentence.split(" ");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String s : arr) {
            wordCount.put(s, wordCount.getOrDefault(s, 0) +1);
        }

        wordCount.entrySet().forEach(
                e -> System.out.println("%s: %d".formatted(e.getKey(), e.getValue()))
        );

        int max = Integer.MIN_VALUE;
        String mostFrequent = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : wordCount.entrySet()) {
            if (max < stringIntegerEntry.getValue()) {
                mostFrequent = stringIntegerEntry.getKey();
                max = stringIntegerEntry.getValue();
            }
        }
        System.out.println(mostFrequent);

        List<String> countEqOne = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : wordCount.entrySet()) {
            if (stringIntegerEntry.getValue() == 1) {
                countEqOne.add(stringIntegerEntry.getKey());
            }
        }
        System.out.println(countEqOne);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println(list);

    }
}
