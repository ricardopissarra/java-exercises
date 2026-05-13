package com.amigoscode._4_datastructures._5_linkedlists;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExercises {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        list.addFirst("First");
        System.out.println(list);
        list.addFirst("Second");
        System.out.println(list);
        list.addLast("Third");
        list.addLast("Fourth");
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        list.add(1, "Inserted");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
