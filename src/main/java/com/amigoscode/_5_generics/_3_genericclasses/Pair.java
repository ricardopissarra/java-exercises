package com.amigoscode._5_generics._3_genericclasses;

import java.util.Objects;

/**
 * Exercise: Generic Pair Class
 *
 * This exercise has you build a generic Pair<K, V> class that holds
 * two related values of potentially different types, like a key-value pair.
 *
 * Complete the TODOs below.
 */
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Pair<K, V> swap(Pair<K, V> pair) {
        return new Pair(pair.getValue(), pair.getKey());
    }

    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }



    public static void main(String[] args) {

        Pair<String, Integer> person = new Pair<>("Alice", 30);
        Pair<String, Integer> swap = person.swap(person);
        System.out.println(swap);
        Pair<Integer, String> person2 = new Pair<>(30, "Alice");
        System.out.println(swap.equals(person2));
    }
}
