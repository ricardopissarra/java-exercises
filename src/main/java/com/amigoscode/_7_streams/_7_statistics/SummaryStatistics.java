package com.amigoscode._7_streams._7_statistics;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise: Summary Statistics
 *
 * Learn how to use IntSummaryStatistics, DoubleSummaryStatistics,
 * and LongSummaryStatistics to compute multiple aggregate values
 * (count, sum, min, max, average) in a single pass.
 */
public class SummaryStatistics {

    record Sale(String product, double amount, int unitsSold) {}

    public static void main(String[] args) {
        List<Integer> scores = List.of(85, 92, 78, 95, 88, 73, 91, 82, 97, 76);

        List<Sale> sales = List.of(
                new Sale("Product A", 150.0, 10),
                new Sale("Product B", 200.0, 5),
                new Sale("Product C", 75.0, 20),
                new Sale("Product D", 300.0, 3),
                new Sale("Product E", 125.0, 12)
        );

        List<Integer> batch1 = List.of(10, 20, 30, 40, 50);
        List<Integer> batch2 = List.of(60, 70, 80, 90, 100);

        IntSummaryStatistics intSummaryStatistics = scores.stream()
                .mapToInt(a -> a)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);

        System.out.println(sales.stream().collect(Collectors.summarizingInt(Sale::unitsSold)));
        System.out.println(sales.stream().mapToDouble(Sale::amount).summaryStatistics());


        IntSummaryStatistics batch1Summary = batch1.stream().mapToInt(a -> a).summaryStatistics();
        IntSummaryStatistics batch2Summary = batch2.stream().mapToInt(a -> a).summaryStatistics();
        batch1Summary.combine(batch2Summary);
        System.out.println(batch1Summary);

    }
}
