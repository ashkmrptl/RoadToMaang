package scaler.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 * The digits are stored such that the most significant digit is at the head of the list.
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
 * Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
 * A: For the purpose of this question, YES
 * Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
 * A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 * <p>
 * Problem Constraints
 * 1 <= size of the array <= 1000000
 * <p>
 * Input Format
 * First argument is an array of digits.
 * <p>
 * Output Format
 * Return the array of digits after adding one.
 * <p>
 * Example Input
 * Input 1:
 * [1, 2, 3]
 * <p>
 * Example Output
 * Output 1:
 * [1, 2, 4]
 * <p>
 * Example Explanation
 * Explanation 1:
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToNumber {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println(solve(A));

        A = new ArrayList<>();
        A.add(0);
        System.out.println(solve(A));

        A = new ArrayList<>(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5));
        System.out.println(solve(A));

        A = new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9));
        System.out.println(solve(A));

        A = new ArrayList<>(Arrays.asList(0, 6, 0, 6, 4, 8, 8, 1));
        System.out.println(solve(A));
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) != 0) {
                nonZeroIndex = i;
                break;
            }
        }

        A.subList(0, nonZeroIndex).clear();

        if (A.isEmpty()) {
            A.add(1);
            return A;
        }

        Collections.reverse(A);

        int quotient = 1;

        for (int i = 0; i < A.size(); i++) {
            int sum = A.get(i) + quotient;
            int rem = sum % 10;
            A.set(i, rem);
            quotient = sum / 10;
        }

        if (quotient != 0) {
            A.add(quotient);
        }

        Collections.reverse(A);

        return A;
    }
}
