package com.amigoscode._4_datastructures._3_stacks;


import java.util.Stack;

public class StackExercises {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("JavaScript");
        stack.push("Go");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.isEmpty());



        // --- String Reversal ---
        System.out.println("\n--- String Reversal ---");
        String original = "Hello World";
        Stack<Character> reverse = new Stack<>();
        for (Character c : original.toCharArray()) {
            reverse.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!reverse.isEmpty()) {
            sb.append(reverse.pop());
        }
        System.out.println(original);
        System.out.println(sb);

        // --- Balanced Brackets ---
        System.out.println("\n--- Balanced Brackets ---");
        String balanced = "({[()]})";
        String unbalanced = "({[})";
        System.out.println(isBalanced(balanced));
        System.out.println(isBalanced(unbalanced));
    }

    static boolean isBalanced(String in) {
        if (in.length() < 2) return false;

        Stack<Character> balanced = new Stack<>();
        for (Character c : in.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                balanced.push(c);
            } else {
                Character ch = balanced.pop();
                if ((ch == '(' && c != ')') || (ch == '{' && c != '}') || (ch == '[' && c != ']') ) {
                    return false;
                }
            }
        }
        return true;
    }
}
