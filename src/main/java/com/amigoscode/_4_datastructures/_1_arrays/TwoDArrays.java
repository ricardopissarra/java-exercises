package com.amigoscode._4_datastructures._1_arrays;


import java.util.Arrays;

public class TwoDArrays {

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + 1) * (j +1);
            }
        }

        /*
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
         */


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println("sum: %d".formatted(sum));

        int sumRowOne = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i ==1) {
                    sumRowOne += matrix[i][j];
                }
            }
        }
        System.out.println("sum of row with index 1: %s".formatted(sumRowOne));

        int sumDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    sumDiagonal += matrix[i][j];
                }
            }
        }
        System.out.println("sum of diagonal of matrix: %d".formatted(sumDiagonal));
    }
}
