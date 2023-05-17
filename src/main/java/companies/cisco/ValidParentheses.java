package companies.cisco;

import java.util.Stack;

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
        final Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpening(ch)) {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() || isValid(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isOpening(final char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private static boolean isValid(final char opening, final char closing) {
        return (opening == '(' && closing == ')') || (opening == '{' && closing == '}') || (opening == '[' && closing == ']');
    }
}
