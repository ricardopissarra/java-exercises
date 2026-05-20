package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Loops
 *
 * Learn how to use for, while, and do-while loops to repeat code.
 * Loops are fundamental for iterating over data and performing repetitive tasks.
 */
public class LoopExercises {

    public static void main(String[] args) {

        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i);
        }


        int num = 10;
        for (int i = num; i > 0 ; i--) {
            System.out.println(i);
        }

        do {
            System.out.println("This runs at least once!");
        } while (false);

        for (int i = 1; i <= 20 ; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        int factorial = 1;
        int numToCalculate = 5;
        for (int i = 2; i <= numToCalculate; i++) {
            factorial *= i;
        }
        System.out.println(factorial);

        String[] fruits = {"apple", "pear", "banana", "kiwi"};
        for (String s : fruits) {
            System.out.println(s);
        }


        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print((i*j) + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 10 ; i++) {
            if (i == 5) continue;
            if (i == 8) break;
            System.out.println(i);
        }
    }
}
