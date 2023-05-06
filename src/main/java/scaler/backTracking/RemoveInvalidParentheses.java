package scaler.backTracking;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(solve("()())()"));
        System.out.println(solve("(a)())()"));
    }

    static ArrayList<String> solve(String A) {
        int left = 0;
        int right = 0;

        //Finding misplaced left and right parentheses
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                left++;
            } else if (A.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }

        final List<Character> permutation = new ArrayList<>();

        findPermutation(A, 0, 0, 0, left, right, permutation);

        return new ArrayList<>(result);

    }

    final static Set<String> result = new HashSet<>();

    private static void findPermutation(String A, int index, int leftCount, int rightCount, int leftRem, int rightRem, List<Character> permutation) {
        //Base case - if we reach the end of the string, check if the permutation is valid and also if we have removed all remaining left and right parentheses
        if (index == A.length()) {
            if (leftRem == 0 && rightRem == 0) {
                final StringBuilder temp = new StringBuilder();
                for (final Character ch : permutation) {
                    temp.append(ch);
                }

                result.add(temp.toString());
            }
        } else {
            //We don't recurse if the remaining count for the parentheses is == 0
            int f1 = 0;
            int f2 = 0;
            if (A.charAt(index) == '(') {
                f1 = 1;
            }
            if (A.charAt(index) == ')') {
                f2 = 1;
            }

            if ((A.charAt(index) == '(' && leftRem > 0) || (A.charAt(index) == ')' && rightRem > 0)) {
                findPermutation(A, index + 1, leftCount, rightCount, leftRem - f1, rightRem - f2, permutation);
            }

            permutation.add(A.charAt(index));

            //Recurse one step further if the current character is not a parenthesis.
            if (A.charAt(index) != '(' && A.charAt(index) != ')') {
                findPermutation(A, index + 1, leftCount, rightCount, leftRem, rightRem, permutation);
            } else if (A.charAt(index) == '(') {//For opening bracket
                findPermutation(A, index + 1, leftCount + 1, rightCount, leftRem, rightRem, permutation);
            } else if (A.charAt(index) == ')' && leftCount > rightCount) {//For closing bracket
                findPermutation(A, index + 1, leftCount, rightCount + 1, leftRem, rightRem, permutation);
            }

            //Remove last char from permutation for backtracking
            permutation.remove(permutation.size() - 1);
        }
    }
}
