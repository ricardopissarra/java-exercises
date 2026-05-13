package com.amigoscode._4_datastructures._4_queues;

// Exercise: Queue Operations
// Learn how to use Queue and PriorityQueue - First In, First Out (FIFO) and priority-based ordering.

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExercises {

    public static void main(String[] args) {

        // --- Basic Queue Operations ---
        System.out.println("--- Basic Queue (LinkedList) ---");

        Queue<String> queue = new LinkedList<>();

        queue.offer("Task1");
        queue.offer("Task2");
        queue.offer("Task3");
        queue.offer("Task4");
        queue.offer("Task5");

        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);

        for (String s : queue) {
            System.out.println(s);
        }


        // --- PriorityQueue ---
        System.out.println("\n--- PriorityQueue ---");

        Queue<Integer> integers = new PriorityQueue<>();
        integers.offer(50);
        integers.offer(20);
        integers.offer(40);
        integers.offer(10);
        integers.offer(30);
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());

        // --- Print Queue Simulation ---
        System.out.println("\n--- Print Queue Simulation ---");
        Queue<String> printer = new LinkedList<>();
        printer.offer("Report.pdf");
        printer.offer("Photo.jpg");
        printer.offer("Letter.docx");
        printer.offer("Slides.pptx");

        while (!printer.isEmpty()) {
            System.out.println("Printing: %s".formatted(printer.poll()));
        }

    }
}
