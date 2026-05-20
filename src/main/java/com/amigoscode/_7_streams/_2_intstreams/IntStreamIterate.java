package com.amigoscode._7_streams._2_intstreams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Exercise: IntStream.iterate and Specialized Streams
 *
 * Learn how to use IntStream.iterate() to generate sequences,
 * and explore LongStream and DoubleStream for other primitive types.
 */
public class IntStreamIterate {

    public static void main(String[] args) {

        IntStream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n < 100, n -> n + 7).forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).mapToInt(f -> f[0]).forEach(System.out::println);


        System.out.println(LongStream.of(1, 1_000_000).sum());

        DoubleStream.generate(Math::random).limit(5).forEach(d -> System.out.println("%.4f".formatted(d)));

    }
}
