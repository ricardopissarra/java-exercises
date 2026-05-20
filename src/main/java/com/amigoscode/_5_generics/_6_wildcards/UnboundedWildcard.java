package com.amigoscode._5_generics._6_wildcards;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Unbounded Wildcards (?)
 *
 * The unbounded wildcard <?> represents an unknown type.
 * A List<?> can refer to a list of any type, but you cannot add elements
 * to it (except null) because the compiler does not know the actual type.
 *
 * Complete the TODOs below.
 */
public class UnboundedWildcard {

    static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static int getSize(List<?> list) {
        return list.size();
    }

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Hello", "World");
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        printList(strings);
        printList(numbers);
        printList(doubles);

        System.out.println(getSize(strings));
        System.out.println(getSize(numbers));
        System.out.println(getSize(doubles));
         List<?> unknownList = Arrays.asList("a", "b", "c");
        /*
             unknownList.add("d");       // Why does this not compile? is expecting ? and we are providing String
             unknownList.add(1);         // Why does this not compile either? is expecting ? and we are providing Integer
         */
        System.out.println(getSize(unknownList));
        System.out.println(unknownList.isEmpty());
        printList(unknownList);
//        unknownList.remove(0); or .clear() throw UnsupportedOperationException
        System.out.println(unknownList);

    }
}
