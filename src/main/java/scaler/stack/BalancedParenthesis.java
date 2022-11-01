package scaler.stack;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String A = "{([])}";
        System.out.println(solve(A));

        A = "(){";
        System.out.println(solve(A));

        A = "})[]";
        System.out.println(solve(A));
    }

    private static int solve(String A) {
        final Stack<Character> stack = new Stack<>();

        for (char ch : A.toCharArray()) {
            if (isOpeningParenthesis(ch)) {
                stack.add(ch);
            } else {
                if (stack.isEmpty() || !isCorrectClosingParenthesis(stack.pop(), ch)) {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    private static boolean isCorrectClosingParenthesis(char lastCh, char ch) {
        return (lastCh == '(' && ch == ')') || (lastCh == '{' && ch == '}') || (lastCh == '[' && ch == ']');
    }

    private static boolean isOpeningParenthesis(char ch) {
        return '[' == ch || '{' == ch || '(' == ch;
    }
}
