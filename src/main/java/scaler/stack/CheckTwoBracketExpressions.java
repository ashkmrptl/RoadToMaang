package scaler.stack;

import java.util.Stack;

/**
 * Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
 * The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
 * NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
 * <p>
 * ex:
 * A = "-(a+b+c)"
 * B = "-a-b-c"
 * <p>
 * O/P: 1
 */
public class CheckTwoBracketExpressions {
    public static void main(String[] args) {
        String A = "-(a+((b-c)-(d+e)))";
        String B = "-(a+b-c-d-e)";
        System.out.println(solve(A, B));
    }

    private static int solve(String A, String B) {
        int[] first = eval(A);
        int[] second = eval(B);
        for (int i = 0; i < 26; i++)
            if (first[i] != second[i])//Exit on any single missmatch
                return 0;
        return 1;
    }

    private static int[] eval(String str) {
        int[] ans = new int[26];
        Stack<Boolean> stack = new Stack<>();
        stack.push(true);//default sign is positive

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '+' || c == '-') //skip local sign until alphabet is found
                continue;

            if (c == '(' && i > 0) {//push next global sign
                if (str.charAt(i - 1) == '-') {
                    stack.push(!stack.peek());
                } else {
                    stack.push(stack.peek());
                }
                continue;
            }

            if (c >= 'a' && c <= 'z') {//evaluating alphabets
                if (i > 0 && str.charAt(i - 1) == '-') {
                    ans[c - 'a'] = (stack.peek() ? -1 : 1);
                } else {
                    ans[c - 'a'] = (stack.peek() ? 1 : -1);
                }
                continue;
            }

            if (c == ')') {//end of previous global sign, hence pop it.
                stack.pop();
            }
        }
        return ans;
    }
}
