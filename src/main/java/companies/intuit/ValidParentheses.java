package companies.intuit;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));

        s = "()[]{}";
        System.out.println(isValid(s));

        s = "(]";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            final Character character = s.charAt(i);

            if (isOpen(character)) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    final Character open = stack.pop();
                    if (!checkOpenAndClose(open, character)) {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static boolean checkOpenAndClose(Character open, Character close) {
        if ((open.equals('(') && close.equals(')')) || (open.equals('[') && close.equals(']')) || (open.equals('{') && close.equals('}'))) {
            return true;
        }

        return false;
    }

    private static boolean isOpen(Character character) {
        if (character.equals('(') || character.equals('{') || character.equals('[')) {
            return true;
        }

        return false;
    }
}
