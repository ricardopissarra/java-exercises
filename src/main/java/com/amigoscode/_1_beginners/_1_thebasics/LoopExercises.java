package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Loops
 *
 * Learn how to use for, while, and do-while loops to repeat code.
 * Loops are fundamental for iterating over data and performing repetitive tasks.
 */
public class LoopExercises {

    public static void main(String[] args) {

        // TODO: 1 - Write a for loop to print numbers 1 to 10
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i);
        }

        // TODO: 2 - Write a while loop to print numbers 10 down to 1 (countdown)
        // Hint: Declare a variable before the loop, use a condition, and decrement inside the loop.
        int num = 10;
        for (int i = num; i > 0 ; i--) {
            System.out.println(i);
        }

        // TODO: 3 - Write a do-while loop that runs at least once
        do {
            System.out.println("This runs at least once!");
        } while (false);

        // TODO: 4 - Write a for loop to print only even numbers from 1 to 20
        // Hint: Use an if statement with the modulus operator (%) inside the loop,
        //       or increment by 2 starting from 2.
        for (int i = 1; i <= 20 ; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }


        // TODO: 5 - Write a for loop to calculate the factorial of 5 (5! = 120)
        // Declare a variable called factorial and initialize it to 1.
        // Multiply factorial by each number from 1 to 5.
        // Print the result.
        int factorial = 1;
        int numToCalculate = 5;
        for (int i = 2; i <= numToCalculate; i++) {
            factorial *= i;
        }
        System.out.println(factorial);

        // TODO: 6 - Use an enhanced for loop (for-each) to iterate over a String array
        // Declare a String array called fruits with at least 4 fruit names.
        // Use an enhanced for loop to print each fruit.
        String[] fruits = {"apple", "pear", "banana", "kiwi"};
        for (String s : fruits) {
            System.out.println(s);
        }

        // TODO: 7 - Write a nested for loop to print a 3x3 multiplication table
        // The output should look like:
        //   1  2  3
        //   2  4  6
        //   3  6  9
        // Hint: Use System.out.print() for values on the same row,
        //       and System.out.println() to move to the next row.
        int[][] numsMatrix = {{1, 2, 3},
                {2, 4, 6},
                {3, 6, 9}};

        for (int i = 0; i < numsMatrix.length; i++) {
            for (int j = 0; j < numsMatrix[i].length; j++) {
                System.out.print(numsMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // TODO: 8 - Use break and continue in a loop
        // Write a for loop from 1 to 10:
        //   - Use 'continue' to skip the number 5 (do not print it)
        //   - Use 'break' to stop the loop when you reach 8
        // Print each number that is not skipped.
        for (int i = 1; i <= 10 ; i++) {
            if (i == 5) continue;
            if (i == 8) break;
            System.out.println(i);
        }
    }
}
