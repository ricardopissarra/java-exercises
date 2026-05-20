package com.amigoscode._5_generics._3_genericclasses;

/**
 * Exercise: Generic Box Class
 *
 * This exercise has you build a generic Box<T> class that can store
 * a single item of any type. Think of it as a container that can hold
 * exactly one object.
 *
 * Complete the TODOs below.
 */
public class Box<T> {

    private T content;

    public void put(T item) {
        this.content = item;
    }

    public T get() {
        return this.content;
    }

    public boolean isEmpty() {
        return this.content == null;
    }

    @Override
    public String toString() {
        return "Box={content=%s}".formatted(content);
    }


    public static void main(String[] args) {

        Box<String> box1 = new Box<>();
        box1.put("Hello Generics");
        System.out.println(box1.isEmpty());

        Box<Double> box2 = new Box<>();
        box2.put(3.14);
        System.out.println(box2.get());
        Box<Double> box3 = new Box<>();
        System.out.println(box3.isEmpty());
        System.out.println(box3);

    }
}
