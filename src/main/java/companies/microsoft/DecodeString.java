package companies.microsoft;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));

        s = "3[a2[c]]";
        System.out.println(decodeString(s));

        s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));

        s = "100[leetcode]";
        System.out.println(decodeString(s));
    }

    private static String decodeString(String s) {
        final Stack<Character> stack = new Stack<>();

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                final StringBuilder stringToRepeat = new StringBuilder();

                while (stack.peek() != '[') {
                    stringToRepeat.insert(0, stack.pop());
                }

                //remove the closing square bracket
                stack.pop();

                final StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.insert(0, stack.pop());
                }

                int k = Integer.parseInt(num.toString());

                final StringBuilder str = new StringBuilder();
                while (k >= 1) {
                    str.append(stringToRepeat);
                    k--;
                }

                for (int j = 0; j < str.length(); j++) {
                    stack.push(str.charAt(j));
                }
            }
            i++;
        }

        final StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }

        return ans.toString();
    }

    public String decodeString_faster_copied(String s) {
        final Stack<Integer> integerStack = new Stack<>();
        final Stack<StringBuilder> sb = new Stack<>();

        int num = 0;
        StringBuilder answer = new StringBuilder();

        for (char ch : s.toCharArray()) {
            // There will be 4 types of characters --> number, [ , ], character

            if (ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';
            } else if (ch == '[') {
                sb.push(answer);
                answer = new StringBuilder();

                integerStack.push(num);
                num = 0;
            } else if (ch == ']') {
                StringBuilder temp = answer;
                answer = sb.pop();
                int count = integerStack.pop();

                while (count-- > 0) {
                    answer.append(temp);
                }
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }
}
