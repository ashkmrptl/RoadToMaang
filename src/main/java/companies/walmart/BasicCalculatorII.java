package companies.walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate("42"));
    }

    public static int calculate(String s) {
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

        for (final String element : expression) {
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
        return switch (op) {
            case "/" -> a / b;
            case "*" -> a * b;
            case "+" -> a + b;
            default -> a - b;
        };
    }

    private static boolean isNumber(final char ch) {
        return ch != '/' && ch != '*' && ch != '+' && ch != '-';
    }

    private static boolean isNumber(final String ch) {
        return !"/".equals(ch) && !"*".equals(ch) && !"+".equals(ch) && !"-".equals(ch);
    }

    private static int precedence(String a) {
        return switch (a) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }
}
