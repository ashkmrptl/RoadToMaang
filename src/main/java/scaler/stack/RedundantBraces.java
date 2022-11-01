package scaler.stack;

import java.util.Stack;

/**
 * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
 * Check whether A has redundant braces or not.
 * NOTE: A will be always a valid expression and will not contain any white spaces.
 * Input 1:
 * A = "((a+b))" Output: 1
 * Input 2:
 * A = "(a+(a+b))" Output: 0
 * Input 3:
 * A = "(a)" Output: 1
 */
public class RedundantBraces {
    public static void main(String[] args) {
        String A = "((a+b))";
        System.out.println(solve(A));

        A = "(a+(a+b))";
        System.out.println(solve(A));

        A = "(a)";
        System.out.println(solve(A));
    }

    private static int solve(String A) {
        final Stack<Character> stack = new Stack<>();

        for (Character character : A.toCharArray()) {
            if (character == ')') {
                if (stack.peek() == '(') {
                    return 1;
                } else {
                    boolean isOperatorFound = false;
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        char ch = stack.pop();
                        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                            isOperatorFound = true;
                        }
                    }
                    if (!isOperatorFound) {
                        return 1;
                    }
                    stack.pop();
                }
            } else {
                stack.add(character);
            }
        }
        return 0;
    }
}
