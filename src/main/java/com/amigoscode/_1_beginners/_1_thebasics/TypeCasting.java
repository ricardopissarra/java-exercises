package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Type Casting
 *
 * Learn how to convert between different data types in Java.
 * Widening (implicit): smaller type -> larger type (e.g., int -> double)
 * Narrowing (explicit): larger type -> smaller type (e.g., double -> int)
 */
public class TypeCasting {

    public static void main(String[] args) {

        int a = 10;
        double b = a;
        System.out.println(a);
        System.out.println(b);


        double c = 9.78;
        int d = (int) c;
        System.out.println(c);
        System.out.println(d);


        int e = 65;
        char f = (char) e;
        System.out.println(e);
        System.out.println(f);

        char g = 'Z';
        int h = g;
        System.out.println(g);
        System.out.println(h);

        String number = "42";
        int i = Integer.parseInt(number);
        System.out.println(i);

        String number2 = String.valueOf(i);
        System.out.println(number2);
    }
}
