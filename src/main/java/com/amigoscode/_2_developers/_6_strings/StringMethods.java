package com.amigoscode._2_developers._6_strings;

/**
 * String Methods Exercises
 *
 * Practice the most commonly used String methods in Java. Strings are immutable
 * in Java — every method returns a NEW string rather than modifying the original.
 */
public class StringMethods {

    /**
     * Checks if two strings are equal, first case-sensitive, then case-insensitive.
     * Returns a description of the comparison results.
     *
     * @param a first string
     * @param b second string
     * @return e.g., "equals: false, equalsIgnoreCase: true"
     */
    public static String compareEquality(String a, String b) {
        boolean isEqual = a.equals(b);
        boolean isEqualIgnoreCase = a.equalsIgnoreCase(b);
        return String.format("equals: %b, equalsIgnoreCase: %b", isEqual, isEqualIgnoreCase);
    }

    /**
     * Compares two strings lexicographically using compareTo().
     * Returns "before", "equal", or "after" depending on the result.
     *
     * @param a first string
     * @param b second string
     * @return "before", "equal", or "after"
     */
    public static String compareLexicographic(String a, String b) {
        int result = a.compareTo(b);
        return result == 0 ? "equal" : result < 0 ? "before" : "after";
    }

    /**
     * Checks if the text contains a keyword and returns both the contains result
     * and the index of the first occurrence.
     *
     * @param text    the text to search in
     * @param keyword the keyword to search for
     * @return e.g., "contains: true, indexOf: 7"
     */
    public static String searchString(String text, String keyword) {
        boolean isKeywordPresent = text.contains(keyword);
        int index = text.indexOf(keyword);
        return String.format("contains: %b, index: %d", isKeywordPresent, index);
    }

    /**
     * Replaces all occurrences of oldWord with newWord, then replaces all digits
     * with "#" using replaceAll with a regex.
     *
     * @param text    the original text
     * @param oldWord the word to replace
     * @param newWord the replacement word
     * @return the modified text with both replacements applied
     */
    public static String replaceDemo(String text, String oldWord, String newWord) {
        return text.replace(oldWord, newWord)
                .replaceAll("\\d", "#"); // replace all digits with "#"
    }

    /**
     * Splits the text using the given delimiter and returns the parts as a
     * formatted string showing each part on a new line with its index.
     *
     * @param text      the text to split
     * @param delimiter the delimiter to split on
     * @return formatted string showing parts
     */
    public static String splitDemo(String text, String delimiter) {
        String[] values = text.split(delimiter);
        String result = "";
        for (int i = 0; i < values.length; i++) {
            result = result.concat(String.format("[%d] %s%n", i, values[i]));
        }
        return result;
    }

    /**
     * Checks if the filename starts with a given prefix and ends with a given extension.
     *
     * @param filename  the filename to check
     * @param prefix    the expected prefix
     * @param extension the expected extension (e.g., ".java")
     * @return e.g., "startsWith 'Test': true, endsWith '.java': true"
     */
    public static String checkStartEnd(String filename, String prefix, String extension) {
        boolean hasPrefix = filename.startsWith(prefix);
        boolean hasExtension = filename.endsWith(extension);
        return String.format("startsWith '%s': %b, endsWith '%s': %b", prefix, hasPrefix, extension, hasExtension);
    }

    /**
     * Extracts a substring from the given text.
     *
     * @param text       the source text
     * @param beginIndex the start index (inclusive)
     * @param endIndex   the end index (exclusive)
     * @return the extracted substring
     */
    public static String substringDemo(String text, int beginIndex, int endIndex) {
        return text.substring(beginIndex, endIndex);
    }

    /**
     * Formats a receipt line with item name, quantity, and price.
     * Example: "  Apple       x3      $2.50"
     *
     * @param item     the item name
     * @param quantity the quantity
     * @param price    the price per item
     * @return a formatted receipt line
     */
    public static String formatReceipt(String item, int quantity, double price) {
        return String.format("%-15s x%-5d $%.2f", item, quantity, price); // left-align item in 15 chars, quantity in 5, price with 2 decimals
    }

    public static void main(String[] args) {
        System.out.println("=== Equality ===");
        System.out.println(compareEquality("Hello", "hello"));

        System.out.println("\n=== Lexicographic ===");
        System.out.println("apple vs banana: " + compareLexicographic("apple", "banana"));

        System.out.println("\n=== Search ===");
        System.out.println(searchString("Hello World", "World"));

        System.out.println("\n=== Replace ===");
        System.out.println(replaceDemo("I have 3 cats and 2 dogs", "cats", "birds"));

        System.out.println("\n=== Split ===");
        System.out.println(splitDemo("apple,banana,cherry,date", ","));

        System.out.println("\n=== StartsWith / EndsWith ===");
        System.out.println(checkStartEnd("TestRunner.java", "Test", ".java"));

        System.out.println("\n=== Substring ===");
        System.out.println(substringDemo("Hello World", 0, 5));

        System.out.println("\n=== Formatted Receipt ===");
        System.out.println(formatReceipt("Apple", 3, 2.50));
        System.out.println(formatReceipt("Banana", 12, 1.25));
    }
}
