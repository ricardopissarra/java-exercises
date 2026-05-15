package com.amigoscode._5_generics._1_classcastexception;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: ClassCastException Problem
 *
 * This exercise demonstrates why Java generics were introduced.
 * Before generics, collections used raw types and stored Objects,
 * which led to ClassCastException at runtime.
 *
 * Complete the TODOs below to see the problem firsthand.
 */
public class ClassCastProblem {

    public static void main(String[] args) {

        List list = new ArrayList<>();
        list.add("Hello");
        list.add(42);

        for (int i = 0; i < list.size(); i++) {
            try {
                System.out.println((String) list.get(i));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }


        /*
          (a) Why did the ClassCastException occur?
          An Integer cannot be cast to String
          (b) How do generics (e.g., List<String>) prevent this problem?
          Because if list was List<String> we would have a compile-time error when trying to add 42
          (c) At what stage (compile-time or runtime) do generics catch type errors?
           answered in b
         */

    }
}
