package companies.intuit;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        //System.out.println(calculate(s));

        s = "2-1 + 2";
        //System.out.println(calculate(s));

        s = "1 - (-2)";
        System.out.println(calculate(s));
    }

    private static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final Stack<Integer> stack = new Stack<>();

        int rst = 0;
        int num = 0;
        int sign = 1;
        stack.push(sign);

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if ('+' == ch || '-' == ch) {
                rst = rst + sign * num;
                sign = stack.peek() * (ch == '+' ? 1 : -1);
                num = 0;
            } else if (ch == '(') {
                stack.push(sign);
            } else if (ch == ')') {
                stack.pop();
            }
        }

        rst = rst + sign * num;

        return rst;
    }
}
