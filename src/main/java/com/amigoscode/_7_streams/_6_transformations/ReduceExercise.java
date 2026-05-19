package com.amigoscode._7_streams._6_transformations;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Exercise: Advanced Reduce
 *
 * Practice more complex reduce operations including building strings,
 * finding extremes, and using the three-argument reduce for parallel streams.
 */
public class ReduceExercise {

    record Order(String product, double price, int quantity) {}

    record Product(String name, double price) {}

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 999.99, 1),
                new Order("Mouse", 29.99, 3),
                new Order("Keyboard", 79.99, 2),
                new Order("Monitor", 449.99, 1),
                new Order("Headset", 59.99, 2)
        );

        List<String> tags = List.of("java", "streams", "functional", "programming", "lambda");

        List<Product> products = List.of(
                new Product("Widget A", 15.99),
                new Product("Widget B", 42.50),
                new Product("Widget C", 8.75),
                new Product("Widget D", 99.99),
                new Product("Widget E", 23.45)
        );

        System.out.println(orders.stream().mapToDouble(o -> o.price() * o.quantity()).reduce(0, Double::sum));

        System.out.println(tags.stream().reduce((a, b) -> a + ", " +b));

        products.stream().reduce((a, b) -> {
            if (Double.compare(a.price(), b.price()) > 0) {
                return a;
            }
            return b;
        })
        .ifPresent((p) -> System.out.println("Name: %s, price: %.2f".formatted(p.name(), p.price())));

         BinaryOperator<Order> higherValue = (order, order2) -> {
             if (Double.compare(order.price() * order.quantity(), order2.price() * order2.quantity()) > 0) {
                 return order;
             }
             return order2;
         };
         
        System.out.println(orders.stream().reduce(higherValue).get());

        System.out.println(orders.stream().reduce(0, (sum, order) -> sum + order.quantity, Integer::sum));

        System.out.println(orders.parallelStream().reduce(0.0, (sum, order) -> sum + (order.quantity() * order.price()), Double::sum));
    }
}
