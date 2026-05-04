package com.amigoscode._2_developers._7_dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Date and Time Exercises
 *
 * Practice using the java.time API (introduced in Java 8). These classes are
 * immutable and thread-safe. LocalDate represents a date without time,
 * LocalDateTime represents a date with time.
 */
public class DateExercises {

    /**
     * Returns today's date.
     *
     * @return today's date as a LocalDate
     */
    public static LocalDate getToday() {
        return LocalDate.now();
    }

    /**
     * Creates a specific date: July 4, 1776.
     *
     * @return the date July 4, 1776
     */
    public static LocalDate getIndependenceDay() {
        return LocalDate.of(1776, Month.JULY, 4);
    }

    /**
     * Returns the current date and time.
     *
     * @return the current date and time as a LocalDateTime
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Takes a date and adds the specified days, months, and years to it.
     *
     * @param date   the starting date
     * @param days   number of days to add
     * @param months number of months to add
     * @param years  number of years to add
     * @return the new date after adding the specified amounts
     */
    public static LocalDate addToDate(LocalDate date, int days, int months, int years) {
        return date.plusDays(days)
                .plusMonths(months)
                .plusYears(years);
    }

    /**
     * Checks the relationship between two dates.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return "before" if date1 is before date2, "after" if after, "equal" if same
     */
    public static String compareDates(LocalDate date1, LocalDate date2) {
        return date1.isBefore(date2) ? "before" : date1.isAfter(date2) ? "after" : "equal";
    }

    /**
     * Formats a date using the given pattern.
     * Example patterns: "dd/MM/yyyy", "MMMM d, yyyy", "yyyy-MM-dd"
     *
     * @param date    the date to format
     * @param pattern the format pattern
     * @return the formatted date as a String
     */
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return date.format(dtf);
    }

    /**
     * Parses a date string in the format "dd-MM-yyyy" and returns a LocalDate.
     * Example: "25-12-2025" -> LocalDate of December 25, 2025
     *
     * @param dateString the date string in "dd-MM-yyyy" format
     * @return the parsed LocalDate
     */
    public static LocalDate parseDate(String dateString) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, dtf);
    }

    public static void main(String[] args) {
        System.out.println("=== Today's Date ===");
        System.out.println("Today: " + getToday());

        System.out.println("\n=== Specific Date ===");
        System.out.println("Independence Day: " + getIndependenceDay());

        System.out.println("\n=== Current Date and Time ===");
        System.out.println("Now: " + getCurrentDateTime());

        System.out.println("\n=== Date Arithmetic ===");
        LocalDate today = LocalDate.now();
        System.out.println("Today + 10 days, 2 months, 1 year: " + addToDate(today, 10, 2, 1));

        System.out.println("\n=== Compare Dates ===");
        LocalDate past = LocalDate.of(2020, 1, 1);
        LocalDate future = LocalDate.of(2030, 12, 31);
        System.out.println("2020-01-01 vs 2030-12-31: " + compareDates(past, future));
        System.out.println("2030-12-31 vs 2020-01-01: " + compareDates(future, past));

        System.out.println("\n=== Format Date ===");
        System.out.println("dd/MM/yyyy: " + formatDate(today, "dd/MM/yyyy"));
        System.out.println("MMMM d, yyyy: " + formatDate(today, "MMMM d, yyyy"));

        System.out.println("\n=== Parse Date ===");
        System.out.println("Parsed '25-12-2025': " + parseDate("25-12-2025"));
    }
}
