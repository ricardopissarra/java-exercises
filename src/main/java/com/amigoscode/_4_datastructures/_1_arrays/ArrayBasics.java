package com.amigoscode._4_datastructures._1_arrays;


import java.util.Arrays;

public class ArrayBasics {

    public static void main(String[] args) {

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 10 + 10;
        }

        System.out.println(Arrays.toString(arr));

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.println("max: %d".formatted(max));
        System.out.println("min: %d".formatted(min));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr, 30));

    }
}
