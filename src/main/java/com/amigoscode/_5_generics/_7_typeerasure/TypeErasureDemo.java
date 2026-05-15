package com.amigoscode._5_generics._7_typeerasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Type Erasure
 *
 * Java generics use "type erasure" -- the compiler enforces type safety at
 * compile time, then removes (erases) all generic type information at runtime.
 * This means List<String> and List<Integer> are both just List at runtime.
 *
 * This exercise explores the consequences and limitations of type erasure.
 *
 * Complete the TODOs below.
 */
public class TypeErasureDemo {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("One", "Two", "Three");
        List<Integer> intList = Arrays.asList(1, 2, 3);

        System.out.println(stringList.getClass() == intList.getClass());
        System.out.println(stringList.getClass());
        System.out.println(intList.getClass());

        /*
            class java.util.Arrays$ArrayList
            class java.util.Arrays$ArrayList
          do the class names include <String> or <Integer>? Why not?
          they do not include <String> or <Integer> because of type eraser
         */



         if (stringList instanceof ArrayList<String>) {
             System.out.println(true);
         }  // Does this compile? yes

          if (stringList instanceof ArrayList) {
              System.out.println(true);
          }
        //  Add a comment explaining why you cannot use instanceof with generics.


        /*
         public static <T> T[] createArray(int size) {
             return new T[size];  // Why doesn't this compile?
         }

          Since T is erased at runtime, the JVM would not know
          what type of array to create. What workaround exists?
         */

    }
}
