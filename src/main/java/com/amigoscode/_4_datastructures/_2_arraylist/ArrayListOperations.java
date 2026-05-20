package com.amigoscode._4_datastructures._2_arraylist;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListOperations {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(34);
        numbers.add(56);
        numbers.add(23);
        numbers.add(89);
        numbers.add(67);
        numbers.add(11);
        numbers.add(90);

        Collections.sort(numbers);
        System.out.println(numbers);

        Collections.reverse(numbers);
        System.out.println(numbers);


        System.out.println(Collections.max(numbers));

        List<Integer> subList= numbers.subList(0, 4);
        System.out.println(subList);

        Integer[] arr = subList.toArray(subList.toArray(new Integer[0]));
        System.out.println(arr.length);


        subList.clear();
        System.out.println(subList.isEmpty());
    }
}
