package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

    public static void main(String[] args) {


        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, i);
        }
        long endTime = System.nanoTime();
        double totalTimeInMs = (endTime-startTime)/1_000_000;
        System.out.println("ArrayList time to add 10000 elements at index 0: %.2fms".formatted(totalTimeInMs));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        totalTimeInMs = (endTime-startTime)/1_000_000;
        System.out.println("LinkedList time to add 10000 elements at index 0: %.2fms".formatted(totalTimeInMs));


        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        totalTimeInMs = (endTime-startTime)/1_000_000;
        System.out.println("ArrayList time to add 10000 elements at end: %.2fms".formatted(totalTimeInMs));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        totalTimeInMs = (endTime-startTime)/1_000_000;
        System.out.println("LinkedList time to add 10000 elements at end: %.2fms".formatted(totalTimeInMs));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(arrayList.size()/2);
        }
        endTime = System.nanoTime();
        totalTimeInMs = (endTime-startTime)/1_000_000;
        System.out.println("ArrayList time to get middle element 10000 times: %.2fms".formatted(totalTimeInMs));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(linkedList.size()/2);
        }
        endTime = System.nanoTime();
        totalTimeInMs = (endTime-startTime)/1_000_000;
        System.out.println("LinkedList time to get middle element 10000 times: %.2fms".formatted(totalTimeInMs));


        System.out.println("""
                Why LinkedList is faster for insertions at the beginning? - LikedLists are faster because they just create a node and point the previous to null, 
                the next to head and make then assign the reference of the new node to head. In ArrayLists the elements need to shift in order to insert at index 0
                Why ArrayList is faster for random access? - Because we don't need to loop through the list to get and element at index X, while in the LinkedList we have to loop
                
                I'd choose LinkedList over ArrayList when insert/remove from end/start time matters, and ArrayList when random access is key to get elements fast
                """);


    }
}
