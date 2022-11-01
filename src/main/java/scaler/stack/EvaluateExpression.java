package scaler.stack;

import java.util.Stack;

/**
 * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each string may be an integer or an operator.
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        String[] A = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(solve(A));

        A = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(solve(A));
    }

    private static int solve(String[] A) {
        final Stack<String> stack = new Stack<>();

        for (String s : A) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                String result = performOperation(s, Integer.parseInt(operand1), Integer.parseInt(operand2));
                stack.add(result);
            } else {
                stack.add(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private static String performOperation(String operator, int a, int b) {
        if ("*".equals(operator)) {
            return String.valueOf(a * b);
        } else if ("+".equals(operator)) {
            return String.valueOf(a + b);
        } else if ("/".equals(operator)) {
            return String.valueOf(a / b);
        } else {
            return String.valueOf(a - b);
        }
    }
}
