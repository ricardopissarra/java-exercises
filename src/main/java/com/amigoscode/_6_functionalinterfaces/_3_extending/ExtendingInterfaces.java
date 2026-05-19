package com.amigoscode._6_functionalinterfaces._3_extending;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Exercise: Extending Functional Interfaces
 *
 * You can create your own functional interfaces that extend existing ones.
 * A Transformer<T> extends Function<T, T> so that input and output share the
 * same type -- useful for chaining transformations on the same data type.
 *
 * You will also add default methods to your functional interface, which is
 * allowed as long as there is still exactly one abstract method.
 */
public class ExtendingInterfaces {


    @FunctionalInterface
    interface Transformer<T> extends Function<T, T> {
        default Transformer<T> andThenTransform(Transformer<T> after) {
            return input -> after.apply(this.apply(input));
        }
    }




    public static void main(String[] args) {

        Transformer<String> trimmer = String::trim;
        Transformer<String> lowerCase = String::toLowerCase;


        Transformer<String> cleanUp = trimmer.andThenTransform(lowerCase);

        System.out.println(cleanUp.apply("  HELLO WORLD  "));


        List<String> messyStrings = Arrays.asList(
                "  Alice  ", "BOB", "  Charlie ", " DIANA  "
        );
        List<String> cleanedUpStrings = messyStrings.stream()
                .map(cleanUp)
                .toList();
        System.out.println(cleanedUpStrings);

    }
}
