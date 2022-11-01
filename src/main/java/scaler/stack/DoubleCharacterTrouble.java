package scaler.stack;

import java.util.Stack;

/**
 * You are given a string A.
 * An operation on the string is defined as follows:
 * Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
 * Therefore the string after this operation will be "acd".
 * Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
 */
public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        String A = "abccbc";
        System.out.println(solve(A));
    }

    private static String solve(String A) {
        if (A == null || A.equals("")) {
            return "";
        }

        char[] arr = A.toCharArray();

        final Stack<Character> stack = new Stack<>();
        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else {
                if (stack.peek() == arr[i]) {
                    stack.pop();
                } else {
                    stack.add(arr[i]);
                }
            }
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }
}
