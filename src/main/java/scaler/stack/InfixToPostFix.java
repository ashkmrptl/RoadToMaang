package scaler.stack;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String A = "x^y/(a*z)+b";
        System.out.println(solve(A));

        A = "q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)";
        System.out.println(solve(A));
    }

    private static String solve(String A) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            Character element = A.charAt(i);

            if (Character.isLetterOrDigit(element)) {
                answer.append(element);
            } else if (element == '(') {
                stack.push(element);
            } else if (element == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else if (precedence(element) > precedence(stack.peek())) {
                    stack.push(element);
                } else {
                    while (!stack.isEmpty() && precedence(element) <= precedence(stack.peek())) {
                        answer.append(stack.pop());
                    }
                    stack.push(element);
                }
            }
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return String.valueOf(answer);
    }

    private static int precedence(Character a) {
        switch (a) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
