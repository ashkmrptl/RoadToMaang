package companies.intuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 */
public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));

        s = "3 + 5 / 2";
        System.out.println(calculate(s));
    }

    /**
     * Approach: Using post fix or prefix we can solve this
     *
     * Note: The SC can be optimized by taking two variables(currentNumber and lastNumber) and calculating the numbers on the fly.
     * In this way the expression list can be avoided so as the first for loop to form the expression and also the operands stack can be avoided
     */
    private static int calculate(String s) {
        final List<String> expression = new ArrayList<>();

        StringBuilder current = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (isNumber(s.charAt(i))) {
                current.append(s.charAt(i));
            } else {
                expression.add(current.toString());
                expression.add(String.valueOf(s.charAt(i)));
                current = new StringBuilder();
            }
        }

        expression.add(current.toString());

        final Stack<String> stack = new Stack<>();
        final Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < expression.size(); i++) {
            final String element = expression.get(i);
            if (isNumber(element)) {
                operands.add(Integer.parseInt(element));
            } else {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else if (precedence(element) > precedence(stack.peek())) {
                    stack.push(element);
                } else {
                    while (!stack.isEmpty() && precedence(element) <= precedence(stack.peek())) {
                        final String op = stack.pop();
                        final int operandTwo = operands.pop();
                        final int operandOne = operands.pop();

                        operands.add(calculate(operandOne, operandTwo, op));
                    }
                    stack.push(element);
                }
            }
        }

        while (!stack.isEmpty()) {
            final String op = stack.pop();
            final int operandTwo = operands.pop();
            final int operandOne = operands.pop();
            operands.add(calculate(operandOne, operandTwo, op));
        }

        return operands.peek();
    }

    private static int calculate(int a, int b, String op) {
        if (op.equals("/")) {
            return a / b;
        } else if (op.equals("*")) {
            return a * b;
        } else if (op.equals("+")) {
            return a + b;
        } else { //if (op.equals("-"))
            return a - b;
        }
    }

    private static boolean isNumber(final char ch) {
        if (ch == '/' || ch == '*' || ch == '+' || ch == '-') {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isNumber(final String ch) {
        if ("/".equals(ch) || "*".equals(ch) || "+".equals(ch) || "-".equals(ch)) {
            return false;
        } else {
            return true;
        }
    }

    private static int precedence(String a) {
        return switch (a) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }
}
